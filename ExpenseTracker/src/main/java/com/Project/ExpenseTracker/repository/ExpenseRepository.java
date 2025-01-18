package com.Project.ExpenseTracker.repository;

import com.Project.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.ExpenseTracker.entity.Expense;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{
List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
