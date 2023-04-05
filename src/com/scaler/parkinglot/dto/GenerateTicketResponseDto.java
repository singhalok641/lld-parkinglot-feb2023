package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
