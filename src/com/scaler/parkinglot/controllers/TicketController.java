package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.dto.ResponseStatus;
import com.scaler.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.service.TicketService;


public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){
        /*
        1. Get Vehicle
        2. Generate Ticket
         */

        /*
        TicketService - generateTicket()
            VehicleService - getVehicleBYNumber()
            VehcileService - createVehicle()
            assignSpot()
            createTicketObjectAndStore()

         */

        try{
            Ticket ticket = ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());
            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setTicket(ticket);

            return response;
        }
        catch (NoParkingSpotAvailableException noParkingSpotAvailableException){
            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }
}

// /ticket
// POST /ticket
// {
//    spot:
// }
// GET /ticket?id={}

/*
Problems with directly involving models as parameters:
1. if we need more or less params, current clients will start failing
2. Models are internal implementation details of my system and I may not want to give them to the client
3. Client has to do a lot of GET requests to be able to make this network call


DTO - Data Transfer Objects

 */