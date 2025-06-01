package com.cancelticket.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PaymentInfo {
    private int paymentId;
    private String payMode;
    private BigDecimal amount;
    private Date payDate;
    private int srlNo;
    private String pnrNo;
    private String instType;
    private BigDecimal instAmt;
}