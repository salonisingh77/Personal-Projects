package com.Project.ExpenseTracker.dto;

import com.Project.ExpenseTracker.entity.Income;
import lombok.Data;
import com.Project.ExpenseTracker.entity.Expense;
@Data
public class StatsDTO {
    private Double expense;
    private Double income;
    private Expense latestExpense;
    private Income latestIncome;

    private Double maxIncome;
    private Double minIncome;
    private Double balance;
    private Double maxExpense;
    private Double minExpense;


}
