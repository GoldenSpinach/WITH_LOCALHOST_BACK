package com.with.withlocalhost.reservation.model.service;

import java.util.List;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;

public interface ReservationService {

	List<ReservationTourDto> guidList(String guidId);
	
	List<ReservationTourDto> guestList(String guestId);
	
	String makeReservation(ReservationDto reservationDto);
	
	String modify(ReservationDto reservationDto);
}
