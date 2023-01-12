package org.example.revenuecalculator;

import org.example.model.ICTrain;
import org.example.model.TrainWithPassengers;

public class ICCalculator extends TrainWithPassengersCalculator{
    private static final Class<? extends TrainWithPassengers> IC_TRAIN = ICTrain.class;
    public ICCalculator() {
        super(IC_TRAIN);
    }
}
