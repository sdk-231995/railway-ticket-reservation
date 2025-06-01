package com.admin.model;

import lombok.Data;

@Data
public class Station {
    private int stationId;
    private String stationCode;
    private String stationName;
    private int zoneId;
}