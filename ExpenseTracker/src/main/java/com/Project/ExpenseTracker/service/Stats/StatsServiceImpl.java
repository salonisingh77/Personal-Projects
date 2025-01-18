package com.Project.ExpenseTracker.service.Stats;

import com.Project.ExpenseTracker.dto.GraphDTO;
import com.Project.ExpenseTracker.entity.Expense;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.repository.ExpenseRepository;
import com.Project.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements  StatsService{

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    @Override
    public GraphDTO getChart() {
        LocalDate endDate= LocalDate.now();
        LocalDate startDate=endDate.minusDays(27);
        GraphDTO graph=new GraphDTO();
        List<Expense> expenseList=expenseRepository.findByDateBetween(startDate,endDate);
        List<Income> incomeList=incomeRepository.findByDateBetween(startDate,endDate);

        graph.setExpenseList(expenseList);
        graph.setIncomeList(incomeList);


        return graph;
    }
}
