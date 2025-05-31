package com.train.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.entity.Station;
import com.train.entity.Train;
import com.train.entity.TrainClass;
import com.train.entity.ViaDetails;
import com.train.repository.TrainRepository;

@Service
public class TrainService {

    @Autowired
    private TrainRepository repo;

    public List<Train> getAllTrains() {
        return repo.getAllTrains();
    }

    public List<TrainClass> getAllClasses() {
        return repo.getAllClasses();
    }

    public List<Station> getAllStations() {
        return repo.getAllStations();
    }

    public List<ViaDetails> getViaDetails(String trainCode) {
        return repo.getViaDetails(trainCode);
    }
}
