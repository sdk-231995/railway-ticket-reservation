package com.pnr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnr.entity.PnrStatusResponse;
import com.pnr.service.PnrStatusService;

@RestController
@RequestMapping("/api/pnr")
public class PnrStatusController {

    @Autowired private PnrStatusService pnrStatusService;

    @GetMapping("/{pnrNo}")
    public ResponseEntity<PnrStatusResponse> getStatus(@PathVariable String pnrNo) {
        return ResponseEntity.ok(pnrStatusService.getPnrStatus(pnrNo));
    }
}
