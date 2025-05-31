package com.train.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.entity.Station;
import com.train.entity.Train;
import com.train.entity.TrainClass;
import com.train.entity.ViaDetails;
import com.train.service.TrainService;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService service;

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getTrains() {
        return ResponseEntity.ok(service.getAllTrains());
    }

    @GetMapping("/classes")
    public ResponseEntity<List<TrainClass>> getClasses() {
        return ResponseEntity.ok(service.getAllClasses());
    }

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> getStations() {
        return ResponseEntity.ok(service.getAllStations());
    }

    @GetMapping("/via/{trainCode}")
    public ResponseEntity<List<ViaDetails>> getViaDetails(@PathVariable String trainCode) {
        return ResponseEntity.ok(service.getViaDetails(trainCode));
    }
}
