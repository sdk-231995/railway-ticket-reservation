package com.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.constant.SqlQueries;
import com.user.entity.LoginCredential;
import com.user.entity.PassengerInfo;
import com.user.exception.DatabaseException;


@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveLogin(LoginCredential login) {
        try {
            jdbcTemplate.update(SqlQueries.INSERT_LOGIN, login.getLoginId(), login.getPassword());
        } catch (DataAccessException e) {
            throw new DatabaseException("Failed to save login credentials", e);
        }
    }

    public void savePax(PassengerInfo passengerInfo) {
        try {
            jdbcTemplate.update(SqlQueries.INSERT_PASSENGER, passengerInfo.getSrlNo(), passengerInfo.getPassengerName(),
                    passengerInfo.getPassengerAge(), passengerInfo.getEmail(), passengerInfo.getMobileNumber(),
                    passengerInfo.getPassengerGender(), passengerInfo.getFare(), passengerInfo.getSeatNo(), passengerInfo.getLoginId());
        } catch (DataAccessException e) {
            throw new DatabaseException("Failed to save passenger information", e);
        }
    }

    public LoginCredential findLogin(String loginId) {
        try {
            return jdbcTemplate.queryForObject(SqlQueries.FIND_LOGIN, new BeanPropertyRowMapper<>(LoginCredential.class), loginId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Login not found for ID: " + loginId, e);
        }
    }
}
