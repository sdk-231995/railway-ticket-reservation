package com.pnr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pnr.entity.PassengerInfo;
import com.pnr.exception.PassengerInfoException;

@Repository
public class PassengerRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public List<PassengerInfo> findByPnr(String pnrNo) {
        String sql = "SELECT * FROM passenger_info WHERE pnr_no = ?";
        try {
            return jdbc.query(sql, new BeanPropertyRowMapper<>(PassengerInfo.class), pnrNo);
        } catch (DataAccessException ex) {
        	 System.err.println("Database access error while fetching passenger info: " + ex.getMessage());
            throw new PassengerInfoException("Failed to fetch passenger info for PNR: " + pnrNo, ex);
        }
    }
}
