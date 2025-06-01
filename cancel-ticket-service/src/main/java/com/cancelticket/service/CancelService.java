package com.cancelticket.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cancelticket.model.CancelResponse;
import com.cancelticket.model.PaymentInfo;
import com.cancelticket.model.RefundRule;
import com.cancelticket.model.TicketReservation;
import com.cancelticket.repository.CancelRepository;
import com.cancelticket.repository.PaymentRepository;
import com.cancelticket.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Value;

@Service
public class CancelService {

    @Autowired private TicketRepository ticketRepo;
    @Autowired private PaymentRepository paymentRepo;
    @Autowired private CancelRepository cancelRepo;
    @Autowired private RestTemplate restTemplate;

    @Value("${refund.service.url}")
    private String refundServiceUrl;

    public CancelResponse cancelTicket(String pnrNo) {
        TicketReservation ticket = ticketRepo.findByPnr(pnrNo);
        PaymentInfo payment = paymentRepo.findLatestPaymentByPnr(pnrNo);

        RefundRule refundRule = restTemplate.getForObject(refundServiceUrl + "/api/refund-rules/current", RefundRule.class);

        BigDecimal paidAmount = payment.getAmount();
        BigDecimal refundableAmount = paidAmount.multiply(refundRule.getRefundableAmt().divide(new BigDecimal("100")));

        cancelRepo.save(pnrNo, refundableAmount);

        return CancelResponse.builder()
                .pnrNo(pnrNo)
                .paidAmount(paidAmount)
                .refundableAmount(refundableAmount)
                .message("Ticket cancelled successfully.")
                .build();
    }
}