package org.example.logic;

import org.example.model.Cargo;
import org.example.model.FreightTrain;
import org.example.model.ICTrain;
import org.example.model.PassengerTrain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrainCompanyTest {
    ICTrain icTrain = new ICTrain(Year.of(1995), 12);
    PassengerTrain passengerTrain = new PassengerTrain(Year.of(1990), 10);
    FreightTrain freightTrain = new FreightTrain(Year.of(1985), Cargo.DANGEROUS);
    TrainCompany trainCompany = new TrainCompany(Set.of(icTrain, passengerTrain, freightTrain));

    @Test
    void calculateAggregatedRevenue() {
        int allPassengersPerMonth = 30 * 10 * 50;
        BigDecimal passengersBuysTicketOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.valueOf(0.25));
        BigDecimal passengersBuysTicketNotOnTrain = BigDecimal
                .valueOf(allPassengersPerMonth)
                .multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(0.25)));
        BigDecimal revenueOfTicketBuyingOnIC = passengersBuysTicketOnTrain
                .multiply(BigDecimal.valueOf(4));
        BigDecimal revenueOfTicketBuyingNotOnIC = passengersBuysTicketNotOnTrain
                .multiply(BigDecimal.valueOf(2));
        BigDecimal revenueOnIC = revenueOfTicketBuyingOnIC.add(revenueOfTicketBuyingNotOnIC).subtract(BigDecimal.valueOf(1200));
        BigDecimal revenueOfTicketBuyingOnPassengerTrain = passengersBuysTicketOnTrain
                .multiply(BigDecimal.valueOf(3.5));
        BigDecimal revenueOfTicketBuyingNotOnPassengerTrain = passengersBuysTicketNotOnTrain
                .multiply(BigDecimal.valueOf(1.5));
        BigDecimal revenueOnPassengerTrain = revenueOfTicketBuyingOnPassengerTrain.add(revenueOfTicketBuyingNotOnPassengerTrain).subtract(BigDecimal.valueOf(1000));
        BigDecimal revenueOnFreightTrain = BigDecimal.valueOf(550).add(BigDecimal.valueOf(300)).subtract(BigDecimal.valueOf(300));
        assertEquals(revenueOnIC.add(revenueOnPassengerTrain).add(revenueOnFreightTrain), trainCompany.calculateAggregatedRevenue());
    }

    @Test
    void getFreightTrainWithDangerousCargo() {
        assertEquals(List.of(freightTrain), trainCompany.getFreightTrainWithDangerousCargo());
    }
}