package com.train.constant;

public class TrainSQLConstants {
    public static final String GET_ALL_TRAINS = "SELECT * FROM train";
    public static final String GET_ALL_CLASSES = "SELECT * FROM class";
    public static final String GET_ALL_STATIONS = "SELECT * FROM station";
    public static final String GET_VIA_DETAILS_BY_TRAIN_CODE = "SELECT * FROM via_details WHERE train_code = ?";
}
