package com.ticketreservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketreservation.dto.TicketBookingRequest;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.entiry.TicketReservation;
import com.ticketreservation.service.PassengerInfoService;
import com.ticketreservation.service.TicketReservationService;
import com.ticketreservation.service.TicketService;
import com.ticketreservation.util.PDFGeneratorUtil;
import com.ticketreservation.util.PDFGeneratorUtil2;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired private TicketService ticketService;
    @Autowired
    private PassengerInfoService passengerInfoService;
    @Autowired
    private TicketReservationService ticketReservationService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketBookingRequest request) {
        String pnr = ticketService.bookTicket(request);
        return ResponseEntity.ok("Ticket booked successfully. PNR: " + pnr);
    }
    
    @GetMapping("/generate-ticket-pdf/{pnrNo}")
    public ResponseEntity<byte[]> generatePDF(@PathVariable String pnrNo) throws Exception {
        TicketReservation ticket = ticketReservationService.getByPNR(pnrNo);
        PassengerInfo passengerInfo = passengerInfoService.getByPNR(pnrNo); 

        byte[] pdfBytes = PDFGeneratorUtil2.generateTicketPDF(pnrNo, passengerInfo, ticket);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Ticket-" + pnrNo + ".pdf").build());
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
