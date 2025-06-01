package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.SeatAvailability;
import com.admin.model.Station;
import com.admin.model.Train;
import com.admin.model.TrainFare;
import com.admin.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void addTrain(Train train) {
        adminRepository.addTrain(train);
    }

    public void addStation(Station station) {
        adminRepository.addStation(station);
    }

    public String addFare(TrainFare fare) {
      return  adminRepository.addFare(fare);
    }

    public void addSeatAvailability(SeatAvailability sa) {
        adminRepository.addSeatAvailability(sa);
    }
}