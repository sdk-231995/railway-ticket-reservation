package com.ticketreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketreservation.entiry.TicketReservation;
import com.ticketreservation.repository.TicketReservationRepository;

@Service
public class TicketReservationService {

    @Autowired
    private TicketReservationRepository repository;

    public TicketReservation getByPNR(String pnrNo) {
        return repository.findByPNR(pnrNo);
    }
}
