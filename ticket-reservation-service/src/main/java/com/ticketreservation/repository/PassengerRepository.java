package com.ticketreservation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ticketreservation.entiry.PassengerInfo;

@Repository
public class PassengerRepository {
	@Autowired
	private JdbcTemplate jdbc;

	public void saveAll(List<PassengerInfo> passengerInfoList, String pnrNo) {
		try {
			String sql = "INSERT INTO pax_info (pnr_no, srl_no, passenger_name, passenger_age,email,mobileNumber, passenger_gender, fare,login_id, seat_no) VALUES (?, ?, ?,?,?, ?, ?,?,?, ?, ?)";
			for (PassengerInfo passengerInfo : passengerInfoList) {
				jdbc.update(sql, passengerInfo.getSrlNo(), passengerInfo.getPassengerName(),
						passengerInfo.getPassengerAge(), passengerInfo.getEmail(), passengerInfo.getMobileNumber(),
						passengerInfo.getPassengerGender(), passengerInfo.getFare(), passengerInfo.getLoginId(),
						passengerInfo.getSeatNo(), pnrNo);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
