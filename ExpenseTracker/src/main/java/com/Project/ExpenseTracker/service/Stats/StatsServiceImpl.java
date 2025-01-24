package com.Project.ExpenseTracker.service.Stats;

import com.Project.ExpenseTracker.dto.GraphDTO;
import com.Project.ExpenseTracker.dto.StatsDTO;
import com.Project.ExpenseTracker.entity.Expense;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.repository.ExpenseRepository;
import com.Project.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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
    public StatsDTO getStats()
    {
        Double totalIncome=incomeRepository.sumAmount();
        Double totalExpense= expenseRepository.sumAmount();

        Optional<Income> optionalIncome=incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense=expenseRepository.findFirstByOrderByDateDesc();
        StatsDTO statsDTO =new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);
//        if(optionalIncome.isPresent())
//            statsDTO.setLatestIncome(optionalIncome.get());
optionalIncome.ifPresent(statsDTO::setLatestIncome);
optionalExpense.ifPresent((statsDTO::setLatestExpense));
//        if(optionalExpense.isPresent())
//            statsDTO.setLatestExpense(optionalExpense.get());
statsDTO.setBalance(totalIncome-totalExpense);
List<Income> incomeList=incomeRepository.findAll();
        List<Expense> expenseList=expenseRepository.findAll();


        OptionalDouble minIncome=incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome=incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense=expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense=expenseList.stream().mapToDouble(Expense::getAmount).max();
statsDTO.setMinIncome(minIncome.isPresent()?minIncome.getAsDouble():null);
statsDTO.setMaxIncome(maxIncome.isPresent()?maxIncome.getAsDouble():null);
statsDTO.setMinExpense(minExpense.isPresent()?minExpense.getAsDouble():null);
        statsDTO.setMaxExpense(maxExpense.isPresent()?maxExpense.getAsDouble():null);
        
        return statsDTO;

    }

}
