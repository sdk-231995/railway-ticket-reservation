package com.admin.model;

import lombok.Data;

@Data
public class SeatAvailability {
    private String trainCode;
    private String classCode;
    private int numberOfSeats;
}