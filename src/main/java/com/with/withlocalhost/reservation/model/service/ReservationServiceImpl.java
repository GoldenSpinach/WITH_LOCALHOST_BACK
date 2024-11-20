package com.with.withlocalhost.reservation.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository  reservationRepository;
	
	public ReservationServiceImpl(ReservationRepository repo) {
		this.reservationRepository = repo;
	}
	
	@Override
	public List<ReservationDto> guidList(String guidId) {
		
		return reservationRepository.guidList(guidId);
	}

	@Override
	public List<ReservationDto> guestList(String guestId) {
		
		return reservationRepository.guestList(guestId);
	}

	@Override
	public String makeReservation(ReservationDto reservationDto) {
		int result =reservationRepository.makeReservation(reservationDto);
		if(result>0) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String modify() {
		int result =reservationRepository.modify();
		if(result>0) {
			return "success";
		}
		return "fail";
	}

}
