package com.with.withlocalhost.reservation.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;

@Mapper
public interface ReservationRepository {

		List<ReservationTourDto> guidList(String guidId);
		
		List<ReservationTourDto> guestList(String guestId);
		
		int makeReservation(ReservationDto reservationDto);
		
		int modify(ReservationDto reservationDto);
	
}
