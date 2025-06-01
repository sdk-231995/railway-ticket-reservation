package com.pnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnr.entity.PassengerInfo;
import com.pnr.entity.PnrStatusResponse;
import com.pnr.entity.TicketReservation;
import com.pnr.repository.PassengerRepository;
import com.pnr.repository.TicketRepository;

@Service
public class PnrStatusService {

    @Autowired private TicketRepository ticketRepository;
    @Autowired private PassengerRepository passengerRepository;

    public PnrStatusResponse getPnrStatus(String pnrNo) {
        TicketReservation ticket = ticketRepository.findByPnr(pnrNo);
        List<PassengerInfo> passengerInfoList = passengerRepository.findByPnr(pnrNo);

        // Simulated logic: assume all are confirmed for now
        String status = "CONFIRMED";

        PnrStatusResponse response = new PnrStatusResponse();
        response.setPnrNo(pnrNo);
        response.setTrainCode(ticket.getTrainCode());
        response.setFromStation(ticket.getFromStation());
        response.setToStation(ticket.getToStation());
        response.setFromDate(ticket.getFromDate());
        response.setToDate(ticket.getToDate());
        response.setPassengerInfo(passengerInfoList);
        response.setStatus(status);
        return response;
    }
}
