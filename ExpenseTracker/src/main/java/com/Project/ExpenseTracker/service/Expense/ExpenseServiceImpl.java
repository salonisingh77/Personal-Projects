package com.Project.ExpenseTracker.service.Expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.Project.ExpenseTracker.dto.ExpenseDTO;
import com.Project.ExpenseTracker.entity.Expense;
import com.Project.ExpenseTracker.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public Expense postExpense(ExpenseDTO expenseDto) {
		return saveOrUpdateExpense(new Expense(),expenseDto);
	}
	private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDto)
	{
		expense.setTitle(expenseDto.getTitle());
		expense.setDescription(expenseDto.getDescription());
		expense.setCategory(expenseDto.getCategory());
		expense.setDate(expenseDto.getDate());
		expense.setAmount(expenseDto.getAmount());
		return expenseRepository.save(expense);
	}

	public List<Expense> getAllExpense()
	{
		return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).collect(Collectors.toList());
	}
	
	public Expense getById(long id)
	{
		Optional<Expense> expense=expenseRepository.findById(id);
		if(expense.isPresent())
		{
			return expense.get();
		}
		else 
			throw new EntityNotFoundException("Expense not found with this Id"+id);
	}
	
	public Expense updateExpense(long id,ExpenseDTO expenseDto)
	{
		Optional<Expense> expense=expenseRepository.findById(id);
		if(expense.isPresent()) {
			return saveOrUpdateExpense(expense.get(),expenseDto);
	}
	else
		throw new EntityNotFoundException("Expense not found with this Id"+id);
}
	public void deleteExpense(long id)
	{
		Optional<Expense> expense=expenseRepository.findById(id);
		if(expense.isPresent())
		{
			expenseRepository.deleteById(id);
		}
		else
			throw new EntityNotFoundException("Expense not found with this Id"+id);
	}
	
}
