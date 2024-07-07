package com.worktracker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worktracker.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}