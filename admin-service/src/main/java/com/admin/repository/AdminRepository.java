package com.admin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.admin.model.SeatAvailability;
import com.admin.model.Station;
import com.admin.model.Train;
import com.admin.model.TrainFare;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void addTrain(Train train) {
        String sql = "INSERT INTO train (Train_code, Train_name, Start_time, End_time, Start_station_code, End_station_code, Distance, Frequency) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, train.getTrainCode(), train.getTrainName(), train.getStartTime(), train.getEndTime(), train.getStartStationCode(), train.getEndStationCode(), train.getDistance(), train.getFrequency());
    }

    public void addStation(Station station) {
        String sql = "INSERT INTO station (Station_id, Station_code, Station_name, zone_id) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, station.getStationId(), station.getStationCode(), station.getStationName(), station.getZoneId());
    }

    public String addFare(TrainFare fare) {
        String sql = "INSERT INTO train_fare (train_code,from_date, to_date, from_km, to_km, fare, class_id) VALUES (?, ?, ?,?, ?, ?, ?)";
        int update = jdbc.update(sql,fare.getTrainCode(), fare.getFromDate(), fare.getToDate(), fare.getFromKm(), fare.getToKm(), fare.getFare(), fare.getClassId());
        return "Fare added successfully "+update;
    }

    public void addSeatAvailability(SeatAvailability sa) {
        String sql = "INSERT INTO seat_availability (train_code, class_code, no_of_seats) VALUES (?, ?, ?)";
        jdbc.update(sql, sa.getTrainCode(), sa.getClassCode(), sa.getNumberOfSeats());
    }
}