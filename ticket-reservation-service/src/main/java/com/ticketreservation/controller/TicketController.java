package com.ticketreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketreservation.dto.TicketBookingRequest;
import com.ticketreservation.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketBookingRequest request) {
        String pnr = ticketService.bookTicket(request);
        return ResponseEntity.ok("Ticket booked successfully. PNR: " + pnr);
    }
}
