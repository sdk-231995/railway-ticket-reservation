package com.train.entity;

import java.time.LocalTime;

import lombok.Data;

@Data
public class ViaDetails {
    private int detailsId;
    private String trainCode;
    private String viaStationCode;
    private int kmFromOrigin;
    private LocalTime reachTime;
}
