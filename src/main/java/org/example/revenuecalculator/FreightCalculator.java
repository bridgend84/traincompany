package org.example.revenuecalculator;

import org.example.model.FreightTrain;
import org.example.model.Train;

import java.math.BigDecimal;

public class FreightCalculator implements RevenueCalculator{
    private static final BigDecimal FREIGHT_BASE_REVENUE_PER_MONTH = BigDecimal.valueOf(550);

    @Override
    public BigDecimal getMonthlyRevenue(Train train) {
        FreightTrain freightTrain = (FreightTrain) train;
        return FREIGHT_BASE_REVENUE_PER_MONTH
                .add(freightTrain.getCargo().getAdditionalRevenuePerMonth())
                .subtract(freightTrain.getCostPerMonth());
    }
}
