package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.entiry.TicketReservation;

@Repository
public class TicketReservationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TicketReservation findByPNR(String pnrNo) {
        String sql = "SELECT * FROM ticket_reservation WHERE pnr_no = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(TicketReservation.class), pnrNo);
    }
}
