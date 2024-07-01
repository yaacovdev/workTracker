package com.worktracker.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.worktracker.api.model.User;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

    private final Environment environment;

    public JwtTokenProvider(Environment environment) {
        this.environment = environment;
    }

    public String generateToken(User user, boolean isRefreshToken) {
        Date now = new Date();
        Date expiryDate;
        if (isRefreshToken) {
            expiryDate = new Date(now.getTime() + Long.parseLong(environment.getProperty("jwt.expiration_token")));
        } else {
            expiryDate = new Date(
                    now.getTime() + Long.parseLong(environment.getProperty("jwt.expiration_refresh_token")));
        }

        // Decode the Base64 encoded secret key
        byte[] keyBytes = Base64.getDecoder().decode(environment.getProperty("jwt.secret"));
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .claim("role", user.getRole())
                .claim("username", user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateAccessToken(User user) {
        return generateToken(user, false);
    }

    public String generateRefreshToken(User user) {
        return generateToken(user, true);
    }

    // Add other methods to validate token if needed
}
