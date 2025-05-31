package com.ticketreservation.dto;

import java.time.LocalDate;
import java.util.List;

import com.ticketreservation.entiry.PassengerInfo;

import lombok.Data;

@Data
public class TicketBookingRequest {
    private LocalDate fromDate;
    private LocalDate toDate;
    private int fromKm;
    private int toKm;
    private String fromStation;
    private String toStation;
    private String trainCode;
    private List<PassengerInfo> passengers;
}
