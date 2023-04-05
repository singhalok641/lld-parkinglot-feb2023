package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.repositories.VehicleRepository;
import com.scaler.parkinglot.service.GateService;
import com.scaler.parkinglot.service.TicketService;
import com.scaler.parkinglot.service.VehicleService;
import com.scaler.parkinglot.strategies.spotassignment.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotassignment.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry = new ObjectRegistry();
        VehicleService vehicleService = new VehicleService();
        GateService gateService = new GateService();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);

        TicketService ticketService = new TicketService(vehicleService,
                gateService, spotAssignmentStrategy, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        objectRegistry.register("ticketRepository", ticketRepository);

        GenerateTicketRequestDto request = new GenerateTicketRequestDto();
        request.setVehicleNumber("HR439743");
        request.setVehicleType(VehicleType.SMALL);
        request.setGateId(1L);

        GenerateTicketResponseDto response = ticketController.generateTicket(request);

        // do whatever you want to do next based on the reponse
    }
}

/*
Requirements

1. Operator should be able to generate a ticket
2. Admin should be able to create a new parking lot

// MVC
// Controller
// Service
// Repository


1. Identify which model is the requirement around(CRUD)
 - Ticket

 2. Create Controller, Service, Repository for that model
  - TicketController
  - TicketService
  - TicketRepository

         A
    |    |   |
    B    C   D
    |    |
    E    F

    Dependency graph -> Topological Sort -> create objects in an order

Homework
Implement the following reqs:
1. create a parking lot
2. Add gates to the parking lot
3. Create an operator
4. Assign operator to a gate
4. [BUGFIX] ParkingSpot should become unavailable on assignment of ticket



 */


