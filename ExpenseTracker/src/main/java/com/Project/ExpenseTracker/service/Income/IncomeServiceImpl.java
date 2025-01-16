package com.Project.ExpenseTracker.service.Income;

import com.Project.ExpenseTracker.dto.IncomeDTO;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService{

    private final IncomeRepository incomeRepository;

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll() ;
    }

    @Override
    public Income saveOrUpdate(IncomeDTO incomeDTO) {
        Income income=new Income();
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());
        incomeRepository.save(income);
        return income;
    }
}
