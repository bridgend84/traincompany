package org.example.revenuecalculator;

import org.example.model.Train;

import java.math.BigDecimal;

public interface RevenueCalculator {
    BigDecimal getMonthlyRevenue(Train train);
}
