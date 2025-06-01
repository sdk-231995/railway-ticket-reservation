package com.pnr.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PnrStatusResponse {
    private String pnrNo;
    private String trainCode;
    private String fromStation;
    private String toStation;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String status; // CONFIRMED, RAC, WL
    private List<PassengerInfo> passengerInfo;
}
