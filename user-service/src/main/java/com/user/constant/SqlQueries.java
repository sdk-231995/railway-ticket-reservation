package com.user.constant;

public class SqlQueries {

    public static final String INSERT_LOGIN = 
        "INSERT INTO login_credentials (login_id, password) VALUES (?, ?)";

    public static final String INSERT_PASSENGER = 
        "INSERT INTO passenger_info (srl_no, passenger_name, passenger_age, email, mobileNumber, passenger_gender, fare, seat_no, login_id) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String FIND_LOGIN = 
        "SELECT * FROM login_credentials WHERE login_id = ?";
}
