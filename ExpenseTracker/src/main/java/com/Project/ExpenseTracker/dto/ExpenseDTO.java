package com.Project.ExpenseTracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {
	private long Id;
	private String title;
	private String description;
	private LocalDate date;
	private String Category;
	private Integer amount;


}
