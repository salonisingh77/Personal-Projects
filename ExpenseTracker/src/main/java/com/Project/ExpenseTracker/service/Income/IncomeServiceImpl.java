package com.Project.ExpenseTracker.service.Income;

import com.Project.ExpenseTracker.dto.IncomeDTO;
import com.Project.ExpenseTracker.entity.Income;
import com.Project.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService{

    private final IncomeRepository incomeRepository;

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll() ;
    }

    @Override
    public List<IncomeDTO> getAllIncomeSorting() {
        return incomeRepository.findAll().stream().sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDTO).collect(Collectors.toList());
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

    @Override
    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> income=incomeRepository.findById(incomeDTO.getId());

        if(income.isPresent())

        {
           return saveOrUpdate(income.get().getIncomeDTO());
        }
else
    throw new EntityNotFoundException("Income not found with the title "+incomeDTO.getTitle());

}

    @Override
    public IncomeDTO getIncomeById(Long id) {
        Optional<Income> income=incomeRepository.findById(id);
        if(income.isPresent())
        {
            return income.get().getIncomeDTO();
        }
        else{
throw new EntityNotFoundException("Entity not found with this ID "+id);
        }
    }

    @Override
    public void deleteIncomeById(Long id) {
        Optional<Income> income=incomeRepository.findById(id);
        if(income.isPresent())
        {
           incomeRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Entity not found with this Id "+id);
        }

    }
}