package com.Project.ExpenseTracker.repository;

import com.Project.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {

    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
