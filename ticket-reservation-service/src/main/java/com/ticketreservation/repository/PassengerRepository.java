package com.ticketreservation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.constant.SQLConstants;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.exception.DatabaseException;

@Repository
public class PassengerRepository {
	 @Autowired
	    private JdbcTemplate jdbc;

	    public void saveAll(List<PassengerInfo> passengerInfoList, String pnrNo) {
	        try {
	            String sql = SQLConstants.INSERT_PASSENGER_INFO;
	            for (PassengerInfo passengerInfo : passengerInfoList) {
	                jdbc.update(sql,
	                    pnrNo,
	                    passengerInfo.getSrlNo(),
	                    passengerInfo.getPassengerName(),
	                    passengerInfo.getPassengerAge(),
	                    passengerInfo.getEmail(),
	                    passengerInfo.getMobileNumber(),
	                    passengerInfo.getPassengerGender(),
	                    passengerInfo.getFare(),
	                    passengerInfo.getLoginId(),
	                    passengerInfo.getSeatNo()
	                );
	            }
	        } catch (DataAccessException ex) {
	            throw new DatabaseException("Error saving passenger info for PNR: " + pnrNo, ex);
	        }
	    }
	}