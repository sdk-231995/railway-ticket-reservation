package com.refundrule.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.refundrule.entity.RefundRule;
import com.refundrule.exception.RefundRuleException;

@Repository
public class RefundRuleRepository {

    @Autowired
    private JdbcTemplate jdbc;

    
    public List<RefundRule> findAll() {
        String sql = "SELECT * FROM refund_rule";
        try {
            return jdbc.query(sql, new BeanPropertyRowMapper<>(RefundRule.class));
        } catch (DataAccessException ex) {
            throw new RefundRuleException("Failed to fetch all refund rules", ex);
        }
    }

    public RefundRule findByTime(LocalTime currentTime) {
        String sql = "SELECT * FROM refund_rule WHERE ? BETWEEN from_time AND to_time";
        try {
            return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(RefundRule.class), currentTime);
        } catch (DataAccessException ex) {
            throw new RefundRuleException("Failed to fetch refund rule for time: " + currentTime, ex);
        }
    }

    public void save(RefundRule rule) {
        String sql = "INSERT INTO refund_rule (from_time, to_time, refundable_amt) VALUES (?, ?, ?)";
        try {
            jdbc.update(sql, rule.getFromTime(), rule.getToTime(), rule.getRefundableAmt());
        } catch (DataAccessException ex) {
            throw new RefundRuleException("Failed to save refund rule", ex);
        }
    }

    public String deleteById(int id) {
        try {
            int deletedRowNumber = jdbc.update("DELETE FROM refund_rule WHERE id = ?", id);
            if(deletedRowNumber==1) {
            	return "Refund rule deleted.";
            }else {
            	return "Refund rule not found with id "+id;
			}
        } catch (Exception ex) {
            throw new RefundRuleException("Failed to delete refund rule with ID: " + id, ex);
        }
    }

    public void update(RefundRule rule) {
        String sql = "UPDATE refund_rule SET from_time = ?, to_time = ?, refundable_amt = ? WHERE id = ?";
        try {
            jdbc.update(sql, rule.getFromTime(), rule.getToTime(), rule.getRefundableAmt(), rule.getId());
        } catch (DataAccessException ex) {
            throw new RefundRuleException("Failed to update refund rule with ID: " + rule.getId(), ex);
        }
    }
}
