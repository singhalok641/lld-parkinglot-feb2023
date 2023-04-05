package com.scaler.parkinglot.strategies.feescalculation;

import com.scaler.parkinglot.models.Ticket;

public interface FeesCalculationStrategy {
    int calculateFees(Ticket ticket);
}
