package com.with.withlocalhost.reservation.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.notification.service.NotificationService;
import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;
import com.with.withlocalhost.reservation.model.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository  reservationRepository;
	private NotificationService notiService;
	
	public ReservationServiceImpl(ReservationRepository repo ,NotificationService notiService) {
		this.reservationRepository = repo;
		this.notiService = notiService;
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

	/*
	 * 예약 생성
	 */
	@Override
	public String makeReservation(ReservationDto reservationDto) throws SQLException {
		int result =reservationRepository.makeReservation(reservationDto);
		int reservationId = reservationDto.getReservationId();
		if(result>0) {
			notiService.sendReservationMessage(reservationId);
			return "success";
		}
		return "fail";
	}

	/*
	 * 예약 수정
	 */
	@Override
	public String modify(ReservationDto reservationDto) throws SQLException {
		int result =reservationRepository.modify(reservationDto);
		
		int reservationId = reservationDto.getReservationId();
		String status = reservationDto.getReservationStatus();
		
		if(result>0) {
			if(status.equals("A")) {
				notiService.sendReservationSuccessMessage(reservationId);
			}else if(status.equals("C")) {
				notiService.sendReservationCancelMessage(reservationId);
			}
			return "success";
		}
		return "fail";
	}

	
	
	
}
