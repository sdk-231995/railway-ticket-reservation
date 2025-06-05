package com.ticketreservation.constant;

public class SQLConstants {
	
		 public static final String FIND_BY_PNR = "SELECT * FROM passenger_info WHERE pnr_no = ? LIMIT 1";
		 public static final String INSERT_PASSENGER_INFO =
			        """
		 		
		 	INSERT INTO pax_info (pnr_no, srl_no, passenger_name, passenger_age, email, mobileNumber, passenger_gender, fare, login_id, seat_no) 
		 	 VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		 	
		 	""";
		 
		 public static final String INSERT_TICKET =
			        """
			      INSERT INTO ticket_reservation (pnr_no, from_date, to_date, from_km, to_km, from_station, to_station, train_code) 
			       VALUES (?, ?, ?, ?, ?, ?, ?, ?)""";
		 public static final String FIND_TICKET_BY_PNR = "SELECT * FROM ticket_reservation WHERE pnr_no = ?	";
		 
		 	
	
}

