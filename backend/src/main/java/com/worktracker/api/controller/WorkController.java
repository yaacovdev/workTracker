package com.worktracker.api.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import com.worktracker.api.model.DailyWork;
import com.worktracker.api.model.User;
import com.worktracker.api.repository.UserRepository;
import com.worktracker.api.service.UserService;
import com.worktracker.api.service.WorkService;
import com.worktracker.api.security.JwtTokenProvider;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    public WorkController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/save")
    public DailyWork saveWork(@RequestHeader("Authorization") String authorizationHeader,
            @Valid @RequestBody DailyWork dailyWork) {
        User user = getUser(authorizationHeader);

        if (user == null) {
            throw new RuntimeException("User not found for your token");
        }
        dailyWork.setUser(user);

        // Save dailyWork
        return workService.saveWork(dailyWork);
    }

    @GetMapping("/daily")
    public ResponseEntity<Map<String, Object>> getDailyWork(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(required = false) Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        System.out.println("getDailyWork");

        User user = getUser(authorizationHeader);
        if (userId == null) {
            userId = user.getId();
        } else if (!user.getId().equals(userId) && !user.getRole().equals("LEADSHIP")) {
            throw new RuntimeException("You are not authorized to view other user's work");
        }
        List<DailyWork> workList = workService.getDailyWork(userId, date);
        double totalHours = workList.stream().mapToDouble(DailyWork::getHoursWorked).sum();
        return ResponseEntity.ok(Map.of("userId", userId, "date", date, "hoursWorked", totalHours));
    }

    @GetMapping("/daily/all")
    public ResponseEntity<List<DailyWork>> getAllDailyWork(@RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(required = false) Long userId) {
        User user = getUser(authorizationHeader);
        if (userId == null) {
            userId = user.getId();
        } else if (!user.getId().equals(userId) && !user.getRole().equals("LEADSHIP")) {
            throw new RuntimeException("You are not authorized to view other user's work");
        }
        return ResponseEntity.ok(workService.getAllDailyWork(user.getId()));
    }

    @GetMapping("/weekly")
    public Map<String, Object> getWeeklyWork(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(required = false) Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        User user = getUser(authorizationHeader);
        if (userId == null) {
            userId = user.getId();
        } else if (!user.getId().equals(userId) && !user.getRole().equals("LEADSHIP")) {
            throw new RuntimeException("You are not authorized to view other user's work");
        }
        LocalDate endDate = startDate.plusDays(6);
        List<DailyWork> workList = workService.getWeeklyWork(userId, startDate, endDate);
        double totalHours = workList.stream().mapToDouble(DailyWork::getHoursWorked).sum();
        return Map.of("userId", userId, "startDate", startDate, "endDate", endDate, "hoursWorked", totalHours);
    }

    @GetMapping("/monthly")
    public Map<String, Object> getMonthlyWork(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(required = false) Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate month) {

        User user = getUser(authorizationHeader);
        if (userId == null) {
            userId = user.getId();
        } else if (!user.getId().equals(userId) && !user.getRole().equals("LEADSHIP")) {
            throw new RuntimeException("You are not authorized to view other user's work");
        }
        LocalDate startDate = month.withDayOfMonth(1);
        LocalDate endDate = month.withDayOfMonth(month.lengthOfMonth());
        List<DailyWork> workList = workService.getMonthlyWork(userId, startDate, endDate);
        double totalHours = workList.stream().mapToDouble(DailyWork::getHoursWorked).sum();
        return Map.of("userId", userId, "month", month, "hoursWorked", totalHours);
    }

    private User getUser(String authorizationHeader) {
        String token = getToken(authorizationHeader);
        String email = jwtTokenProvider.getEmailFromToken(token);
        return userRepository.findByEmail(email);
    }

    private String getToken(String authorizationHeader) {
        String token = extractToken(authorizationHeader);

        if (!jwtTokenProvider.validateToken(token)) {
            throw new RuntimeException("Invalid token");
        }
        return token;
    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Remove "Bearer " prefix
        }
        throw new IllegalArgumentException("Bearer token not found in Authorization header");
    }
}
