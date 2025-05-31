package com.fare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fare.entity.TrainFare;
import com.fare.repository.FareRepository;

@Service
public class FareService {
    @Autowired private FareRepository fareRepository;

    public List<TrainFare> getFare(String trainCode, int classId) {
        return fareRepository.getFareByTrainAndClass(trainCode, classId);
    }
}
