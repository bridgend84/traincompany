package org.example.model;

import org.example.revenuecalculator.TrainWithPassengersCalculator;

import java.math.BigDecimal;
import java.time.Year;

public abstract class TrainWithPassengers extends Train{
    protected static final BigDecimal BASE_TICKET_PRICE = BigDecimal.valueOf(1.5);
    private final int numberOfCoaches;
    private final BigDecimal ticketPrice;
    public TrainWithPassengers(
            Year productionYear,
            BigDecimal costPerMonth,
            int numberOfCoaches,
            BigDecimal ticketPrice,
            TrainWithPassengersCalculator trainWithPassengersCalculator) {
        super(productionYear, costPerMonth, trainWithPassengersCalculator);
        this.numberOfCoaches = numberOfCoaches;
        this.ticketPrice = ticketPrice;
    }

    public int getNumberOfCoaches() {
        return numberOfCoaches;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }
}
