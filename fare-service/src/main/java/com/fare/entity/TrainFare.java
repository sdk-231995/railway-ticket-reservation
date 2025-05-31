package com.fare.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TrainFare {
    private int fareId;
    private String trainCode;
    private int classId;
    private int fromKm;
    private int toKm;
    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal fare;
}
