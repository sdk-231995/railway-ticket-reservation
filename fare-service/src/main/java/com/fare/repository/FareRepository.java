package com.fare.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fare.entity.TrainFare;

@Repository
public class FareRepository {
    @Autowired private JdbcTemplate jdbcTemplate;

    public List<TrainFare> getFareByTrainAndClass(String trainCode, int classId) {
        String sql = "SELECT * FROM train_fare WHERE train_code = ? AND class_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TrainFare.class), trainCode, classId);
    }
}
