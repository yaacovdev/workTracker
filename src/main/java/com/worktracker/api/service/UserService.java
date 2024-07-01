package com.worktracker.api.service;

import com.worktracker.api.model.LoginResponse;
import com.worktracker.api.model.User;
import com.worktracker.api.repository.UserRepository;
import com.worktracker.api.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public User register(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        User user_security = new User(user, hashedPassword);
        try {
            user_security = userRepository.save(user_security);
        } catch (Exception e) {
            throw new RuntimeException("Email already in use");
        }
        return user_security;
    }

    @Transactional(readOnly = true)
    public LoginResponse login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("User email not found or password incorrect");
        }
        // Generate tokens
        String accessToken = jwtTokenProvider.generateAccessToken(user);
        String refreshToken = jwtTokenProvider.generateRefreshToken(user);

        return new LoginResponse(accessToken, refreshToken);
    }
}
