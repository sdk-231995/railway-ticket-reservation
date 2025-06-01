package com.admin.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TrainFare {
	private String trainCode;
    private String fromDate;
    private String toDate;
    private int fromKm;
    private int toKm;
    private BigDecimal fare;
    private int classId;
}