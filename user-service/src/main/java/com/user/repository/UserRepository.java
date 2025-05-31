package com.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.entity.LoginCredential;
import com.user.entity.PassengerInfo;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveLogin(LoginCredential login) {
        String sql = "INSERT INTO login_credentials (login_id, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, login.getLoginId(), login.getPassword());
    }

    public void savePax(PassengerInfo passengerInfo) {
        String sql = "INSERT INTO passenger_info (srl_no, passenger_name, passenger_age,email,mobileNumber, passenger_gender, fare, seat_no, login_id) " +
                     "VALUES (?, ?, ?, ?, ?,?,?, ?, ?)";
        jdbcTemplate.update(sql, passengerInfo.getSrlNo(), passengerInfo.getPassengerName(),
        		passengerInfo.getPassengerAge(),passengerInfo.getEmail(),passengerInfo.getMobileNumber(), passengerInfo.getPassengerGender(),
        		passengerInfo.getFare(), passengerInfo.getSeatNo(), passengerInfo.getLoginId());
    }

    public LoginCredential findLogin(String loginId) {
        String sql = "SELECT * FROM login_credentials WHERE login_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LoginCredential.class), loginId);
    }
}
