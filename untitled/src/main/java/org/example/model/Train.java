package org.example.model;

import org.example.revenuecalculator.RevenueCalculator;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;
import java.util.UUID;

public abstract class Train {
    private final UUID id;
    private final Year productionYear;
    protected BigDecimal costPerMonth;
    private final RevenueCalculator revenueCalculator;
    public Train(Year productionYear, BigDecimal costPerMonth, RevenueCalculator revenueCalculator) {
        this.id = UUID.randomUUID();
        this.productionYear = productionYear;
        this.costPerMonth = costPerMonth;
        this.revenueCalculator = revenueCalculator;
    }

    public BigDecimal getMonthlyRevenue() {
        return revenueCalculator.getMonthlyRevenue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(id, train.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
