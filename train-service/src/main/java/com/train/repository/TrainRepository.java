package com.train.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.train.constant.TrainSQLConstants;
import com.train.entity.Station;
import com.train.entity.Train;
import com.train.entity.TrainClass;
import com.train.entity.ViaDetails;
import com.train.exception.DatabaseException;

@Repository
public class TrainRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Train> getAllTrains() {
        try {
            return jdbcTemplate.query(
                TrainSQLConstants.GET_ALL_TRAINS,
                new BeanPropertyRowMapper<>(Train.class)
            );
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error retrieving trains", ex);
        }
    }

    public List<TrainClass> getAllClasses() {
        try {
            return jdbcTemplate.query(
                TrainSQLConstants.GET_ALL_CLASSES,
                new BeanPropertyRowMapper<>(TrainClass.class)
            );
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error retrieving train classes", ex);
        }
    }

    public List<Station> getAllStations() {
        try {
            return jdbcTemplate.query(
                TrainSQLConstants.GET_ALL_STATIONS,
                new BeanPropertyRowMapper<>(Station.class)
            );
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error retrieving stations", ex);
        }
    }

    public List<ViaDetails> getViaDetails(String trainCode) {
        try {
            return jdbcTemplate.query(
                TrainSQLConstants.GET_VIA_DETAILS_BY_TRAIN_CODE,
                new BeanPropertyRowMapper<>(ViaDetails.class),
                trainCode
            );
        } catch (DataAccessException ex) {
            throw new DatabaseException("Error retrieving via details for train code: " + trainCode, ex);
        }
    }
}
