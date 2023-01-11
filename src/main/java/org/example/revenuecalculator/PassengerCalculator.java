package org.example.revenuecalculator;

import java.math.BigDecimal;

public class PassengerCalculator implements RevenueCalculator{
    private static final int AVERAGE_PEOPLE_PER_COACHES_DAILY = 50;
    private static final int DAYS_PER_MONTH = 30;
    private static final double TICKET_BUYING_ON_TRAIN_PERCENTAGE = 0.25;
    private static final BigDecimal TICKET_BUYING_ON_TRAIN_FEE = BigDecimal.valueOf(2);
    private final BigDecimal costPerMonth;
    private final int numberOfCoaches;
    private final BigDecimal ticketPrice;

    public PassengerCalculator(BigDecimal costPerMonth, int numberOfCoaches, BigDecimal ticketPrice) {
        this.costPerMonth = costPerMonth;
        this.numberOfCoaches = numberOfCoaches;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public BigDecimal getMonthlyRevenue() {
        int allPassengersPerMonth = DAYS_PER_MONTH * numberOfCoaches * AVERAGE_PEOPLE_PER_COACHES_DAILY;
        BigDecimal revenueOfTicketBuyingOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.valueOf(TICKET_BUYING_ON_TRAIN_PERCENTAGE))
                .multiply(ticketPrice.add(TICKET_BUYING_ON_TRAIN_FEE));
        BigDecimal revenueOfTicketBuyingNotOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(TICKET_BUYING_ON_TRAIN_PERCENTAGE)))
                .multiply(ticketPrice);
        return revenueOfTicketBuyingOnTrain.add(revenueOfTicketBuyingNotOnTrain).subtract(costPerMonth);
    }
}
