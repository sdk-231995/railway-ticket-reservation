package com.cancelticket.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cancelticket.exception.TicketReservationException;

@Repository
public class CancelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String pnrNo, BigDecimal refundableAmount) {
        if (pnrNo == null || refundableAmount == null) {
            throw new IllegalArgumentException("pnrNo and refundableAmount must not be null");
        }

        String sql = "INSERT INTO cancelled_ticket (pnr_no, refund_amount, cancelled_at) VALUES (?, ?, NOW())";
        
        try {
            int rowNumber = jdbcTemplate.update(sql, pnrNo, refundableAmount);
            
            String message = (rowNumber == 1) ? "Update successful for PNR: " + pnrNo : "Update failed for PNR: " + pnrNo;

            System.out.println(message);
            
        } catch (DataAccessException ex) {
            throw new TicketReservationException( "Failed to insert cancelled ticket for PNR: " + pnrNo + ", amount: " + refundableAmount, ex );
        }
    }

}