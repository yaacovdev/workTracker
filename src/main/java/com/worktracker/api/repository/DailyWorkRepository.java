package com.worktracker.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worktracker.api.model.DailyWork;

public interface DailyWorkRepository extends JpaRepository<DailyWork, Long> {
    List<DailyWork> findByUserIdAndDate(Long userId, LocalDate date);
    List<DailyWork> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
