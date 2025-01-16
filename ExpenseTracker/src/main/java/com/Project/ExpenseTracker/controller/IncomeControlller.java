package com.Project.ExpenseTracker.controller;

import com.Project.ExpenseTracker.dto.IncomeDTO;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.service.Income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeControlller {

    private final IncomeService incomeService;
    @PostMapping("/addIncome")
    public ResponseEntity<Income> saveOrUpdateIncome(@RequestBody IncomeDTO incomeDTO) {
        try {
            Income income = incomeService.saveOrUpdate(incomeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(income);
        } catch (RestClientException ex) {
            throw new RestClientException(ex.getMessage());
        }
    }
        @GetMapping("/getAll")
                public ResponseEntity<List<Income>> getAllIncome(){
                try{
                  List<Income> incomeList=  incomeService.getAllIncome();
                    return ResponseEntity.status(HttpStatus.OK).body(incomeList);
                }catch (RestClientException ex) {
                    throw new RestClientException(ex.getMessage());
                }
    }
}
