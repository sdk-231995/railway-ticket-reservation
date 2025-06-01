package com.cancelticket.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelResponse {
    private String pnrNo;
    private BigDecimal paidAmount;
    private BigDecimal refundableAmount;
    private String message;
}