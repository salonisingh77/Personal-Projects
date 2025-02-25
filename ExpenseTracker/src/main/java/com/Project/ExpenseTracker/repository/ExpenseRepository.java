package com.Project.ExpenseTracker.repository;

import com.Project.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.ExpenseTracker.entity.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{
List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
@Query("SELECT SUM(e.amount) FROM Expense e")
    Double sumAmount();
Optional<Expense> findFirstByOrderByDateDesc();


}
