package com.seatavailability.entity;

import lombok.Data;

@Data
public class SeatAvailability {
    private int id;
    private String trainCode;
    private String classCode;
    private int noOfSeats;
}
