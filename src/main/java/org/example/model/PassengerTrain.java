package org.example.model;

import org.example.revenuecalculator.PassengerCalculator;

import java.math.BigDecimal;
import java.time.Year;

public class PassengerTrain extends TrainWithPassengers{
    public static final BigDecimal PASSENGER_TRAIN_COST_PER_MONTH = BigDecimal.valueOf(1000);
    public PassengerTrain(Year productionYear, int numberOfCoaches) {
        super(
                productionYear,
                PASSENGER_TRAIN_COST_PER_MONTH,
                numberOfCoaches,
                BASE_TICKET_PRICE,
                new PassengerCalculator());
    }
}
