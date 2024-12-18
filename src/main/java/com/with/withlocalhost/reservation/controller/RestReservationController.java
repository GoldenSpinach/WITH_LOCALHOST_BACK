package com.with.withlocalhost.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.with.withlocalhost.common.annotation.AccessTokenAop;
import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.ReservationTourDto;
import com.with.withlocalhost.reservation.model.service.ReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "Reservation API", description = "예약 관련 API")  // @Api 대신 @Tag 사용
@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:5173")
public class RestReservationController {
	private final ReservationService reservationService;
	
	public RestReservationController(ReservationService rs) {
		this.reservationService = rs;
	}

	
	
	
	/*
	 * 가이드 예약 정보 확인하기
	 */
	@AccessTokenAop
	@Operation(summary = "가이드 예약 정보", description = "type : param , guidId")
	@GetMapping("/guidList")
	public ResponseEntity<?> guidList(HttpServletRequest request) throws Exception{
		String userId = (String) request.getAttribute("userId");
		System.out.println("가이드 예약 도착");
		List<ReservationTourDto> reservationList = reservationService.guidList(userId);
		System.out.println(reservationList);
		return ResponseEntity.ok(reservationList);
	}
	
	/*
	 * 게스트 예약 정보 확인
	 */
	@AccessTokenAop
	@Operation(summary = "게스트 예약 정보 ", description = "type : param , guestId")
	@GetMapping("/guestList")
	public ResponseEntity<?> guestList(HttpServletRequest request) throws Exception{
		String userId = (String) request.getAttribute("userId");
		List<ReservationTourDto> reservationList = reservationService.guestList(userId);
		return ResponseEntity.ok(reservationList);
	}
	
	
	/*
	 * 예약 하기 (insert)
	 */
	@AccessTokenAop
	@Operation(summary = "예약하기", description = "type : requestBody , 예약 dto")
	@PostMapping("/makeReservation")
	public ResponseEntity<?> makeReservation(HttpServletRequest request,@RequestBody ReservationDto reservationDto) throws Exception{
		String userId = (String) request.getAttribute("userId");
		String nickName = (String) request.getAttribute("nickname");
		reservationDto.setReservater(userId);
		reservationDto.setReservaterNickName(nickName);
		System.out.println("reservation nick name : " + nickName);
		return ResponseEntity.ok(reservationService.makeReservation(reservationDto));
	}
	
	
	/*
	 * 예약 정보 수정 하기(update)
	 */
	@AccessTokenAop
	@Operation(summary = " testId : minji123 / 예약 수정 투어 호스트만 할 수 있음 / P:대기, A:승인, C:취소", description = "reservation_id 와 reservation_type만 던져도 됨")
	@PutMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody ReservationDto reservationDto) throws Exception{
		return ResponseEntity.ok(reservationService.modify(reservationDto));
	}
	
	/*
	 * 예약 취소 하기
	 */
//	@PutMapping("/cancel")
//	public ResponseEntity<?> cancel() throws Exception{
//		
//		return ResponseEntity.ok("te");
//	}
	
	
	
	
	
	
}
