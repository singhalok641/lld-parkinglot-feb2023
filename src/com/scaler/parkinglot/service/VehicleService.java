package com.scaler.parkinglot.service;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(){

    }

    VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByNumber(String number) {
        return null;
    }

    public Vehicle registerVehicle(String number, VehicleType vehicleType) {

        // Ideally you will have an object of VehicleRepo and you will call Db to get the Vehicle
        Vehicle v = new Vehicle();
        v.setNumber("HR534768");
        v.setVehicleType(VehicleType.LARGE);


//        vehicleRepository.fetchVehicleFromDbByVehicleNumber(number);

        return v;
    }
}
