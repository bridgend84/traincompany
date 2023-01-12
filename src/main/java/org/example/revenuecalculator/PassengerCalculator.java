package org.example.revenuecalculator;

import org.example.model.PassengerTrain;
import org.example.model.TrainWithPassengers;

public class PassengerCalculator extends TrainWithPassengersCalculator{
    private static final Class<? extends TrainWithPassengers> PASSENGER_TRAIN = PassengerTrain.class;
    public PassengerCalculator() {
        super(PASSENGER_TRAIN);
    }
}
