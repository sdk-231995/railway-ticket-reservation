package com.user.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PassengerInfo {
    private Integer passengerId;
    private Integer srlNo;
    private String passengerName;
    private Integer passengerAge;
    private String email;
    private long mobileNumber;
    private String passengerGender;
    private BigDecimal fare;
    private String seatNo;
    private String loginId;
}
