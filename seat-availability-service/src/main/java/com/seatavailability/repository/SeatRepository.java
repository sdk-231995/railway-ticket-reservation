package com.seatavailability.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seatavailability.entity.SeatAvailability;

@Repository
public class SeatRepository {
    @Autowired private JdbcTemplate jdbcTemplate;

    public SeatAvailability findByTrainAndClass(String trainCode, String classCode) {
        String sql = "SELECT * FROM seat_availability WHERE train_code = ? AND class_code = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SeatAvailability.class),
                trainCode, classCode);
    }
}
