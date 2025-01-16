package com.Project.ExpenseTracker.service.Income;

import com.Project.ExpenseTracker.dto.IncomeDTO;
import com.Project.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {
    public List<Income> getAllIncome();
    public List<IncomeDTO> getAllIncomeSorting();
    public Income saveOrUpdate(IncomeDTO incomeDTO);
    public Income updateIncome(Long id, IncomeDTO incomeDTO);
}
