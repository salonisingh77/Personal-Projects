package com.Project.ExpenseTracker.controller;

import com.Project.ExpenseTracker.service.Income.IncomeService;
import com.Project.ExpenseTracker.service.Stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;
    @GetMapping("/getChart")
    public ResponseEntity<?> getChart()
    {

          return ResponseEntity.status(HttpStatus.OK).body(statsService.getChart());


    }
}
