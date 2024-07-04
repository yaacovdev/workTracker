package com.worktracker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worktracker.api.model.DailyWork;
import com.worktracker.api.repository.DailyWorkRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkService {

    @Autowired
    private DailyWorkRepository dailyWorkRepository;

    public DailyWork saveWork(DailyWork dailyWork) {
        return dailyWorkRepository.save(dailyWork);
    }

    public List<DailyWork> getDailyWork(Long userId, LocalDate date) {
        return dailyWorkRepository.findByUserIdAndDate(userId, date);
    }

    public List<DailyWork> getWeeklyWork(Long userId, LocalDate startDate, LocalDate endDate) {
        return dailyWorkRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    public List<DailyWork> getMonthlyWork(Long userId, LocalDate startDate, LocalDate endDate) {
        return dailyWorkRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }
}