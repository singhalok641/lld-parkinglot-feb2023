package com.scaler.parkinglot.service;

import com.scaler.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.spotassignment.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;

    private GateService gateService;

    private SpotAssignmentStrategy spotAssignmentStrategy;

    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         TicketRepository ticketRepository){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotAvailableException {
        /*
        Check if Vehicle is present in the DB
         1. VehicleService.getVehicleByNumber() - Approach
         2. VehicleRepository.fetchByNumber()

         if yes, get the vehicle object
         else create a vehicle object

         Create a ticket
         */

        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);

        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if(parkingSpot == null){
            throw new NoParkingSpotAvailableException("No available spot for parking");
        }

        ticket.setParkingSpot(parkingSpot);

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
}