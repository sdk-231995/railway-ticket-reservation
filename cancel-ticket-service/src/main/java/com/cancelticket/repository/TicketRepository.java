package com.cancelticket.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cancelticket.exception.TicketReservationException;
import com.cancelticket.model.TicketReservation;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate jdbc;

	public TicketReservation findByPnr(String pnrNo) {
		String sql = "SELECT * FROM ticket_reservation WHERE PNR_no = ?";

		try {
			TicketReservation ticketReservation = jdbc.queryForObject(sql,
					new BeanPropertyRowMapper<>(TicketReservation.class), pnrNo);
			return ticketReservation;
		} catch (DataAccessException ex) {
			throw new TicketReservationException("Failed to fetch ticket reservation for PNR: " + pnrNo, ex);
		}
	}
    
    

}