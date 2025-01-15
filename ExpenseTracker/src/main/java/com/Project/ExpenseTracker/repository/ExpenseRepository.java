package com.Project.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.ExpenseTracker.entity.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{

}
