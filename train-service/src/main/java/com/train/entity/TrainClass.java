package com.train.entity;

import lombok.Data;

@Data
public class TrainClass {
    private int classId;
    private String coachPrefix;
    private String classCode;
    private String className;
    private int seatPerCoach;
}
