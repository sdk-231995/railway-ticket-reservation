package com.payinfo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentInfo {
    private int paymentId;
    private String payMode;
    private BigDecimal amount;
    private LocalDate payDate;
    private int srlNo;
    private String pnrNo;
    private String instType;
    private BigDecimal instAmt;
}
