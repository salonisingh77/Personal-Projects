package com.Project.ExpenseTracker.service.Stats;

import com.Project.ExpenseTracker.dto.GraphDTO;
import com.Project.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    public GraphDTO getChart();
    StatsDTO getStats();
}
