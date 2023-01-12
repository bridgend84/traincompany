package org.example.model;

import org.example.revenuecalculator.ICCalculator;

import java.math.BigDecimal;
import java.time.Year;

public class ICTrain extends TrainWithPassengers{
    private static final BigDecimal IC_TRAIN_COST_PER_MONTH = BigDecimal.valueOf(1200);
    private static final BigDecimal IC_TICKET_EXTRA_FEE = BigDecimal.valueOf(0.5);
    private static final int MAX_NUMBER_OF_IC_COACHES = 10;
    public ICTrain(Year productionYear, int numberOfCoaches) {
        super(
                productionYear,
                IC_TRAIN_COST_PER_MONTH,
                Math.min(numberOfCoaches, MAX_NUMBER_OF_IC_COACHES),
                BASE_TICKET_PRICE.add(IC_TICKET_EXTRA_FEE),
                new ICCalculator());
    }
}
