package org.example.logic;

import org.example.model.Cargo;
import org.example.model.FreightTrain;
import org.example.model.Train;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class TrainCompany {
    private final Set<Train> trainSet;

    public TrainCompany(Set<Train> trainSet) {
        this.trainSet = trainSet;
    }

    public void addTrain(Train train) {
        trainSet.add(train);
    }

    public BigDecimal calculateAggregatedRevenue() {
        return trainSet.stream().map(Train::getMonthlyRevenue).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public List<FreightTrain> getFreightTrainWithDangerousCargo() {
        return trainSet
                .stream()
                .filter(train -> train instanceof FreightTrain)
                .map(train -> (FreightTrain) train)
                .filter(freightTrain -> freightTrain.getCargo().equals(Cargo.DANGEROUS))
                .toList();
    }
}
