package org.example.model;

import org.example.revenuecalculator.FreightCalculator;

import java.math.BigDecimal;
import java.time.Year;

public class FreightTrain extends Train{
    private static final BigDecimal FREIGHT_TRAIN_COST_PER_MONTH = BigDecimal.valueOf(300);
    private final Cargo cargo;
    public FreightTrain(Year productionYear, Cargo cargo) {
        super(
                productionYear,
                FREIGHT_TRAIN_COST_PER_MONTH,
                new FreightCalculator());
        this.cargo = cargo;
    }
    public Cargo getCargo() {
        return cargo;
    }
}
