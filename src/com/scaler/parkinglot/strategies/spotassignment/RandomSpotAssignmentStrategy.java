package com.scaler.parkinglot.strategies.spotassignment;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }


    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
//        ParkingLot parkingLot = parkingLotRepository.getParkingLotWithGate(gate);
//        List<ParkingSpot> parkingSpotList = ParkingSpotRepository.getParkingSpotsByParkingLot();
//
//        for(ParkingSpot parkingSpot: parkingSpotList){
//            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)
//                    && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
//                return parkingSpot;
//            }
//        }

        return null;

    }
}
