package com.payinfo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.payinfo.entity.PaymentInfo;

@Repository
public class PaymentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(PaymentInfo payment) {
        String sql = "INSERT INTO pay_info (pay_mode, amount, pay_date, srl_no, pnr_no, inst_type, inst_amt) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(sql,
            payment.getPayMode(), payment.getAmount(), payment.getPayDate(),
            payment.getSrlNo(), payment.getPnrNo(),
            payment.getInstType(), payment.getInstAmt());
    }

    public List<PaymentInfo> findByPnr(String pnrNo) {
        String sql = "SELECT * FROM pay_info WHERE pnr_no = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(PaymentInfo.class), pnrNo);
    }
}
