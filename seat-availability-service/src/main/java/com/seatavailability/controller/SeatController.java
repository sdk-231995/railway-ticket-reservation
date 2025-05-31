package com.seatavailability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seatavailability.entity.SeatAvailability;
import com.seatavailability.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired private SeatService seatService;

    @GetMapping
    public ResponseEntity<SeatAvailability> checkAvailability(
        @RequestParam String trainCode,
        @RequestParam String classCode) {
        return ResponseEntity.ok(seatService.getAvailability(trainCode, classCode));
    }
}
