package com.cancelticket.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cancelticket.exception.TicketReservationException;
import com.cancelticket.model.PaymentInfo;

@Repository
public class PaymentRepository {

    @Autowired
    private JdbcTemplate jdbc;

	public PaymentInfo findLatestPaymentByPnr(String pnrNo) {
		String sql = "SELECT * FROM pay_info WHERE PNR_no = ? ORDER BY pay_date DESC LIMIT 1";

		try {
			PaymentInfo paymentInfo = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(PaymentInfo.class), pnrNo);
			return paymentInfo;
		} catch (DataAccessException ex) {
			throw new TicketReservationException("Failed to fetch ticket reservation for PNR: " + pnrNo, ex);
		}
	}
}