package org.example.revenuecalculator;

import org.example.model.Train;
import org.example.model.TrainWithPassengers;

import java.math.BigDecimal;

public abstract class TrainWithPassengersCalculator implements RevenueCalculator{
    private static final int AVERAGE_PEOPLE_PER_COACHES_DAILY = 50;
    private static final int DAYS_PER_MONTH = 30;
    private static final double TICKET_BUYING_ON_TRAIN_PERCENTAGE = 0.25;
    private static final BigDecimal TICKET_BUYING_ON_TRAIN_FEE = BigDecimal.valueOf(2);

    protected Class<? extends TrainWithPassengers> typeOfTrain;

    public TrainWithPassengersCalculator(Class<? extends TrainWithPassengers> typeOfTrain) {
        this.typeOfTrain = typeOfTrain;
    }

    @Override
    public BigDecimal getMonthlyRevenue(Train train) {
        TrainWithPassengers trainWithPassengers = typeOfTrain.cast(train);
        int allPassengersPerMonth =
                DAYS_PER_MONTH * trainWithPassengers.getNumberOfCoaches() * AVERAGE_PEOPLE_PER_COACHES_DAILY;
        BigDecimal revenueOfTicketBuyingOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.valueOf(TICKET_BUYING_ON_TRAIN_PERCENTAGE))
                .multiply(trainWithPassengers.getTicketPrice().add(TICKET_BUYING_ON_TRAIN_FEE));
        BigDecimal revenueOfTicketBuyingNotOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(TICKET_BUYING_ON_TRAIN_PERCENTAGE)))
                .multiply(trainWithPassengers.getTicketPrice());
        return revenueOfTicketBuyingOnTrain
                .add(revenueOfTicketBuyingNotOnTrain)
                .subtract(trainWithPassengers.getCostPerMonth());
    }
}
