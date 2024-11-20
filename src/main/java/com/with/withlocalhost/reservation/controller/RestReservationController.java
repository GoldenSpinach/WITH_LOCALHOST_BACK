package com.with.withlocalhost.reservation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.with.withlocalhost.reservation.model.ReservationDto;
import com.with.withlocalhost.reservation.model.service.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reservation API", description = "예약 관련 API")  // @Api 대신 @Tag 사용
@RestController
@RequestMapping("/reservation")
public class RestReservationController {
	private final ReservationService reservationService;
	
	public RestReservationController(ReservationService rs) {
		this.reservationService = rs;
	}
	
	
	/*
	 * 가이드 예약 정보 확인하기
	 */
	@GetMapping("/guidList")
	public ResponseEntity<?> guidList(@RequestParam String guidId) throws Exception{
		List<ReservationDto> reservationList = reservationService.guidList(guidId);
		return ResponseEntity.ok("te");
	}
	
	/*
	 * 게스트 예약 정보 확인
	 */
	@GetMapping("/guestList")
	public ResponseEntity<?> guestList(@RequestParam String guestId) throws Exception{
		List<ReservationDto> reservationList = reservationService.guestList(guestId);
		return ResponseEntity.ok("te");
	}
	
	
	/*
	 * 예약 하기 (insert)
	 */
	@PostMapping("/makeReservation")
	public ResponseEntity<?> makeReservation(@RequestBody ReservationDto reservationDto) throws Exception{
		
		return ResponseEntity.ok("te");
	}
	
	
	/*
	 * 예약 정보 수정 하기(update)
	 */
	@PutMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody ReservationDto reservationDto) throws Exception{
	
		return ResponseEntity.ok("te");
	}
	
	/*
	 * 예약 취소 하기
	 */
	@PutMapping("/cancel")
	public ResponseEntity<?> cancel() throws Exception{
		
		return ResponseEntity.ok("te");
	}
	
	
	
	
	
	
}
