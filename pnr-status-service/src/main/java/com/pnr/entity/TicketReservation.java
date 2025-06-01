package com.pnr.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketReservation {
    private String pnrNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int fromKm;
    private int toKm;
    private String fromStation;
    private String toStation;
    private String trainCode;
}
