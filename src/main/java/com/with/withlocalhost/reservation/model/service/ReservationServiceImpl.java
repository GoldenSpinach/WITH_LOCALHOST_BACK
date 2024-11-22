package com.with.withlocalhost.reservation.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;
import com.with.withlocalhost.reservation.model.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository  reservationRepository;
	
	public ReservationServiceImpl(ReservationRepository repo) {
		this.reservationRepository = repo;
	}
	
	@Override
	public List<ReservationTourDto> guidList(String guidId) {
		System.out.println(guidId);
		return reservationRepository.guidList(guidId);
	}

	@Override
	public List<ReservationTourDto> guestList(String guestId) {
		
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
	public String modify(ReservationDto reservationDto) {
		int result =reservationRepository.modify(reservationDto);
		if(result>0) {
			return "success";
		}
		return "fail";
	}

}
