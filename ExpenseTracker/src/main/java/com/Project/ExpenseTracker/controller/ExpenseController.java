package com.Project.ExpenseTracker.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.ExpenseTracker.dto.ExpenseDTO;
import com.Project.ExpenseTracker.entity.Expense;
import com.Project.ExpenseTracker.service.Expense.ExpenseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	@PostMapping
	public ResponseEntity<?> addExpense(@RequestBody ExpenseDTO expenseDto)
	{
		Expense createdExpense= expenseService.postExpense(expenseDto);
		if(createdExpense!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/getAllExpense")
	public ResponseEntity<?> getAllExpense()
	{
		List<Expense> listOfExpense=expenseService.getAllExpense();
		if(listOfExpense!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(listOfExpense);
			
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable long id)
	{
		try{
			return ResponseEntity.status(HttpStatus.OK).body(expenseService.getById(id));

		}catch(EntityNotFoundException ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	
		//if(expense!=null)
//		{
//			return ResponseEntity.status(HttpStatus.OK).body(expense);
//		}
//		else
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}



@PutMapping("updateExpense/{id}")
public ResponseEntity<?> updateExpense(@PathVariable long id, @RequestBody ExpenseDTO expenseDto)
{

	try
	{return ResponseEntity.status(HttpStatus.OK).body(expenseService.updateExpense(id,expenseDto));

	}catch(EntityNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	catch(Exception ex)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}

@DeleteMapping("deleteExpense/{id}")
public ResponseEntity<?> deleteExpense(@PathVariable long id)
{
	try
	
	{
		expenseService.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted Expense with id:"+id);
	}

	catch(EntityNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	catch(Exception ex)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	
}
}
}