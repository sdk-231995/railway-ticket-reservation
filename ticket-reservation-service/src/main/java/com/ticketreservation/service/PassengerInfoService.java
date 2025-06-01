package com.ticketreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketreservation.entiry.PassengerInfo;
import com.ticketreservation.repository.PassengerInfoRepository;

@Service
public class PassengerInfoService {

    @Autowired
    private PassengerInfoRepository repository;

    public PassengerInfo getByPNR(String pnrNo) {
        return repository.findByPNR(pnrNo);
    }
}
