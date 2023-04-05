package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long idSequence = 0L;
    public Ticket save(Ticket ticket) {
        idSequence += 1;
        ticket.setId(idSequence);
        tickets.put(idSequence, ticket);

        return ticket;
    }
}
