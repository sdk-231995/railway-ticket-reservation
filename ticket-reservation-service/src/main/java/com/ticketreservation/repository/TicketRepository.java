package com.ticketreservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticketreservation.entiry.TicketReservation;

@Repository
public class TicketRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Transactional
    public void save(TicketReservation ticket) {
        String sql = "INSERT INTO ticket_reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(sql,
            ticket.getPnrNo(), ticket.getFromDate(), ticket.getToDate(),
            ticket.getFromKm(), ticket.getToKm(),
            ticket.getFromStation(), ticket.getToStation(), ticket.getTrainCode());
    }
}
