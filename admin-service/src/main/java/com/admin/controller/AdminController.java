package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.SeatAvailability;
import com.admin.model.Station;
import com.admin.model.Train;
import com.admin.model.TrainFare;
import com.admin.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-train")
    public ResponseEntity<String> addTrain(@RequestBody Train train) {
        adminService.addTrain(train);
        return ResponseEntity.ok("Train added successfully.");
    }

    @PostMapping("/add-station")
    public ResponseEntity<String> addStation(@RequestBody Station station) {
        adminService.addStation(station);
        return ResponseEntity.ok("Station added successfully.");
    }

    @PostMapping("/add-fare")
    public ResponseEntity<String> addFare(@RequestBody TrainFare fare) {
        String fareAdded = adminService.addFare(fare);
        return ResponseEntity.ok(fareAdded);
    }

    @PostMapping("/add-seat-availability")
    public ResponseEntity<String> addSeatAvailability(@RequestBody SeatAvailability seatAvailability) {
        adminService.addSeatAvailability(seatAvailability);
        return ResponseEntity.ok("Seat availability added.");
    }
}