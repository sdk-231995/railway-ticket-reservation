package com.ticketreservation.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketreservation.dto.TicketBookingRequest;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.entiry.TicketReservation;
import com.ticketreservation.repository.PassengerRepository;
import com.ticketreservation.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired private TicketRepository ticketRepo;
    @Autowired private PassengerRepository passengerRepository;

    public String bookTicket(TicketBookingRequest request) {
    	  Random random = new Random();
        String pnr = "PNR" +( 100000 + random.nextInt(900000));

        TicketReservation ticket = new TicketReservation();
        ticket.setPnrNo(pnr);
        ticket.setFromDate(request.getFromDate());
        ticket.setToDate(request.getToDate());
        ticket.setFromKm(request.getFromKm());
        ticket.setToKm(request.getToKm());
        ticket.setFromStation(request.getFromStation());
        ticket.setToStation(request.getToStation());
        ticket.setTrainCode(request.getTrainCode());

        ticketRepo.save(ticket);

        int srl = 1;
        for (PassengerInfo passengerInfo : request.getPassengers()) {
        	passengerInfo.setSrlNo(srl++);
        	passengerInfo.setPnrNumber(pnr);
        }

        passengerRepository.saveAll(request.getPassengers(), pnr);
        return pnr;
    }
}
