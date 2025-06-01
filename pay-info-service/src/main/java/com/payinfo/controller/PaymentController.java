package com.payinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payinfo.entity.PaymentInfo;
import com.payinfo.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<String> pay(@RequestBody PaymentInfo payment) {
        service.processPayment(payment);
        return ResponseEntity.ok("Payment recorded successfully.");
    }

    @GetMapping("/{pnrNo}")
    public ResponseEntity<List<PaymentInfo>> getPayments(@PathVariable String pnrNo) {
        return ResponseEntity.ok(service.getPaymentsByPnr(pnrNo));
    }
}
