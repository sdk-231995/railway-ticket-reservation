package com.payinfo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payinfo.entity.PaymentInfo;
import com.payinfo.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public void processPayment(PaymentInfo payment) {
        payment.setPayDate(LocalDate.now());
        repo.save(payment);
    }

    public List<PaymentInfo> getPaymentsByPnr(String pnrNo) {
        return repo.findByPnr(pnrNo);
    }
}
