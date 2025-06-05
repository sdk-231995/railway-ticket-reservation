package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticketreservation.constant.SQLConstants;
import com.ticketreservation.entiry.TicketReservation;
import com.ticketreservation.exception.DatabaseException;

@Repository
public class TicketRepository {
	 @Autowired
	    private JdbcTemplate jdbc;

	    @Transactional
	    public void save(TicketReservation ticket) {
	        try {
	            jdbc.update(SQLConstants.INSERT_TICKET,
	                ticket.getPnrNo(),
	                ticket.getFromDate(),
	                ticket.getToDate(),
	                ticket.getFromKm(),
	                ticket.getToKm(),
	                ticket.getFromStation(),
	                ticket.getToStation(),
	                ticket.getTrainCode()
	            );
	        } catch (DataAccessException ex) {
	            throw new DatabaseException("Failed to save ticket reservation for PNR: " + ticket.getPnrNo(), ex);
	        }
	    }
	}