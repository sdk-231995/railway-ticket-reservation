package com.train.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.train.entity.Station;
import com.train.entity.Train;
import com.train.entity.TrainClass;
import com.train.entity.ViaDetails;

@Repository
public class TrainRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Train> getAllTrains() {
        return jdbcTemplate.query("SELECT * FROM train", new BeanPropertyRowMapper<>(Train.class));
    }

    public List<TrainClass> getAllClasses() {
        return jdbcTemplate.query("SELECT * FROM class", new BeanPropertyRowMapper<>(TrainClass.class));
    }

    public List<Station> getAllStations() {
        return jdbcTemplate.query("SELECT * FROM station", new BeanPropertyRowMapper<>(Station.class));
    }

    public List<ViaDetails> getViaDetails(String trainCode) {
        return jdbcTemplate.query("SELECT * FROM via_details WHERE train_code = ?",
            new BeanPropertyRowMapper<>(ViaDetails.class), trainCode);
    }
}
