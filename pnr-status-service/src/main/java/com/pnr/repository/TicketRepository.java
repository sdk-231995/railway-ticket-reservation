package com.pnr.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pnr.entity.TicketReservation;
import com.pnr.exception.PassengerInfoException;

@Repository
public class TicketRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public TicketReservation findByPnr(String pnrNo) {
        String sql = "SELECT * FROM ticket_reservation WHERE pnr_no = ?";
     
        try {
        	   return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(TicketReservation.class), pnrNo);
        } catch (DataAccessException ex) {
        	 System.err.println("Database access error while fetching Ticket Reservation: " + ex.getMessage());
            throw new PassengerInfoException("Failed to fetch TicketReservation for PNR: " + pnrNo, ex);
        }
    }
    
   
}
