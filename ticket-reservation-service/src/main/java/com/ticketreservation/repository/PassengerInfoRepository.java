package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.entiry.PassengerInfo;

@Repository
public class PassengerInfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PassengerInfo findByPNR(String pnrNo) {
        String sql = "SELECT * FROM passenger_info WHERE pnr_no = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(PassengerInfo.class), pnrNo);
    }
}
