package com.cancelticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cancelticket.model.CancelRequest;
import com.cancelticket.model.CancelResponse;
import com.cancelticket.service.CancelService;

@RestController
@RequestMapping("/api/cancel")
public class CancelController {

    @Autowired
    private CancelService cancelService;

    @PostMapping
    public ResponseEntity<CancelResponse> cancel(@RequestBody CancelRequest request) {
        CancelResponse response = cancelService.cancelTicket(request.getPnrNo());
        return ResponseEntity.ok(response);
    }
}
