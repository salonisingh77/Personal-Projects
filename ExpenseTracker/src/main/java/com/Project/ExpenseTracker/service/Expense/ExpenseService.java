package com.Project.ExpenseTracker.service.Expense;

import java.util.List;

import com.Project.ExpenseTracker.dto.ExpenseDTO;
import com.Project.ExpenseTracker.entity.Expense;

public interface ExpenseService {
	Expense postExpense(ExpenseDTO expenseDto);
	List<Expense> getAllExpense();
	Expense getById(long Id);
	Expense updateExpense(long id,ExpenseDTO expenseDto);
	void deleteExpense(long id);
	}
