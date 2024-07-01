package com.worktracker.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private boolean enabled;
    
    private String role = "USER";

    @NotBlank
    private String company;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

     // Default constructor
     public User() {
    }

    public User(User user, String hashedPassword) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = hashedPassword; // Use the provided hashed password
        this.enabled = user.isEnabled();
        this.role = user.getRole();
        this.company = user.getCompany();
        this.email = user.getEmail();
        this.creationDate = user.getCreationDate();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}