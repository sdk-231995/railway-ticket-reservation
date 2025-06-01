package com.admin.model;

import lombok.Data;

@Data
public class Train {
    private String trainCode;
    private String trainName;
    private String startTime;
    private String endTime;
    private String startStationCode;
    private String endStationCode;
    private int distance;
    private String frequency;
}