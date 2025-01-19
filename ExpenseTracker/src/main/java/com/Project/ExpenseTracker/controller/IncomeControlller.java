package com.Project.ExpenseTracker.controller;

import com.Project.ExpenseTracker.dto.IncomeDTO;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.service.Income.IncomeService;
import jakarta.persistence.EntityNotFoundException;
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
    @GetMapping("/getAllIncome")
    public ResponseEntity<List<IncomeDTO>> getAllIncomeSorting(){
        try{
            List<IncomeDTO> incomeList=  incomeService.getAllIncomeSorting();
            return ResponseEntity.status(HttpStatus.OK).body(incomeList);
        }catch (RestClientException ex) {
            throw new RestClientException(ex.getMessage());
        }
    }

    @PutMapping("/updateIncome/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id ,@RequestBody IncomeDTO incomeDTO)
    {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(incomeService.updateIncome(id,incomeDTO));

        }
        catch(RestClientException ex)
        {
            throw new RestClientException(ex.getMessage());
        }
    }
    @GetMapping("getIncomeById/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(incomeService.getIncomeById(id));
        } catch (RestClientException ex) {
            throw new RestClientException(ex.getMessage());
        }
    }
        @DeleteMapping("/deleteIncome/{id}")
                public ResponseEntity<?> deleteIncomeById(@PathVariable long id)
        {
            try{
                incomeService.deleteIncomeById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
            }catch(EntityNotFoundException ex)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            catch(RestClientException ex)
            {
                throw new RestClientException(ex.getMessage());
        }
        
    }
    @GetMapping("/allIncome")
    public List<Income> getallIncome()
    {
        return incomeService.findbydate();
    }

}
