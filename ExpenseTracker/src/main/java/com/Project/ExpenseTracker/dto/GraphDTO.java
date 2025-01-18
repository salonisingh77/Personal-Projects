package com.Project.ExpenseTracker.dto;

import com.Project.ExpenseTracker.entity.Expense;
import com.Project.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;
@Data
public class GraphDTO {
    List<Expense> expenseList;
    List<Income> incomeList;
}
