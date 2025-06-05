package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.constant.SQLConstants;
import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.exception.DatabaseException;

@Repository
public class PassengerInfoRepository {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public PassengerInfo findByPNR(String pnrNo) {
	        try {
	            return jdbcTemplate.queryForObject(
	              SQLConstants.FIND_BY_PNR,
	                new BeanPropertyRowMapper<>(PassengerInfo.class),
	                pnrNo
	            );
	        } catch (DataAccessException ex) {
	            throw new DatabaseException("Error retrieving passenger info for PNR: " + pnrNo, ex);
	        }
	    }
	}