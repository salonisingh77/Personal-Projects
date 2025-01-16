package com.Project.ExpenseTracker.repository;

import com.Project.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Long> {
}
