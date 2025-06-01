package com.refundrule.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

import lombok.Data;

@Data
public class RefundRule {
    private int id;
    private LocalTime fromTime;
    private LocalTime toTime;
    private BigDecimal refundableAmt;
}
