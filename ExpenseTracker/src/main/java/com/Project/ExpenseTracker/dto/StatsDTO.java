package com.Project.ExpenseTracker.dto;

import com.Project.ExpenseTracker.entity.Income;
import lombok.Data;
import com.Project.ExpenseTracker.entity.Expense;
@Data
public class StatsDTO {
    private Expense expense;
    private Income income;
    private Expense latestExpense;
    private Income latestIncome;
}
