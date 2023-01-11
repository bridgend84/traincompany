package org.example.revenuecalculator;

import org.example.model.Cargo;

import java.math.BigDecimal;

public class FreightCalculator implements RevenueCalculator{
    private static final BigDecimal FREIGHT_BASE_REVENUE_PER_MONTH = BigDecimal.valueOf(550);
    private final Cargo cargo;
    private final BigDecimal costPerMonth;

    public FreightCalculator(Cargo cargo, BigDecimal costPerMonth) {
        this.cargo = cargo;
        this.costPerMonth = costPerMonth;
    }

    @Override
    public BigDecimal getMonthlyRevenue() {
        return FREIGHT_BASE_REVENUE_PER_MONTH.add(cargo.getAdditionalRevenuePerMonth()).subtract(costPerMonth);
    }
}
