package com.seatavailability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seatavailability.entity.SeatAvailability;
import com.seatavailability.repository.SeatRepository;

@Service
public class SeatService {
    @Autowired private SeatRepository seatRepository;

    public SeatAvailability getAvailability(String trainCode, String classCode) {
        return seatRepository.findByTrainAndClass(trainCode, classCode);
    }
}
