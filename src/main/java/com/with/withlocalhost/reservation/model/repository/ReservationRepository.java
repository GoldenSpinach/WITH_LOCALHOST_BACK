package com.with.withlocalhost.reservation.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.reservation.model.ReservationDto;

@Mapper
public interface ReservationRepository {

		List<ReservationDto> guidList(String guidId);
		
		List<ReservationDto> guestList(String guestId);
		
		int makeReservation(ReservationDto reservationDto);
		
		int modify();
	
}
