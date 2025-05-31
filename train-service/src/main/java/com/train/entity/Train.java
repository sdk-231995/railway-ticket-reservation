package com.train.entity;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Train {
    private String trainCode;
    private String trainName;
    private int distance;
    private LocalTime startTime;
    private LocalTime endTime;
    private String startStationCode;
    private String endStationCode;
    private String frequency;
}
