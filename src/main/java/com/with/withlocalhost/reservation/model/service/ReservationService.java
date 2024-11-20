package com.with.withlocalhost.reservation.model.service;

import java.util.List;

import com.with.withlocalhost.reservation.model.ReservationDto;

public interface ReservationService {

	List<ReservationDto> guidList(String guidId);
	
	List<ReservationDto> guestList(String guestId);
	
	String makeReservation(ReservationDto reservationDto);
	
	String modify();
}
