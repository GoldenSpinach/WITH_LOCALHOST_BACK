package com.with.withlocalhost.reservation.model.service;

import java.sql.SQLException;
import java.util.List;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;

public interface ReservationService {

	List<ReservationTourDto> guidList(String guidId) throws SQLException;
	
	List<ReservationTourDto> guestList(String guestId) throws SQLException;
	
	String makeReservation(ReservationDto reservationDto) throws SQLException;
	
	String modify(ReservationDto reservationDto) throws SQLException;
}
