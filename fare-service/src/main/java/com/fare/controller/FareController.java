package com.fare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fare.entity.TrainFare;
import com.fare.service.FareService;

@RestController
@RequestMapping("/api/fares")
public class FareController {
    @Autowired private FareService fareService;

    @GetMapping
    public ResponseEntity<List<TrainFare>> getFare(
        @RequestParam String trainCode,
        @RequestParam int classId) {
        return ResponseEntity.ok(fareService.getFare(trainCode, classId));
    }
}
