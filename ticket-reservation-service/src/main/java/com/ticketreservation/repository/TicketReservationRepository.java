package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.constant.SQLConstants;
import com.ticketreservation.entiry.TicketReservation;
import com.ticketreservation.exception.DatabaseException;

@Repository
public class TicketReservationRepository {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public TicketReservation findByPNR(String pnrNo) {
	        try {
	            return jdbcTemplate.queryForObject(
	              SQLConstants.FIND_TICKET_BY_PNR,
	                new BeanPropertyRowMapper<>(TicketReservation.class),
	                pnrNo
	            );
	        } catch (DataAccessException ex) {
	            throw new DatabaseException("Failed to retrieve ticket for PNR: " + pnrNo, ex);
	        }
	    }
	}