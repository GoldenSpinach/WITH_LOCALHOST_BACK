package com.with.withlocalhost.tour.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.with.withlocalhost.tour.model.TourDto;
import com.with.withlocalhost.tour.model.service.TourService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Tour API", description = "투어 관련 API")  // @Api 대신 @Tag 사용
@RestController
@RequestMapping("/tour")
public class RestTourController {

	private final TourService tourService;
	
	public RestTourController(TourService tourService) {
		this.tourService = tourService;
	}
	
	
	
	/*
	 * 투어 전체 리스트
	 */
	@Operation(summary = "투어 전체 리스트 조회", description = "모든 투어 데이터를 조회")
	@GetMapping("/list")
	public ResponseEntity<?> tourAllList() throws Exception{
		System.out.println("tour List");
		List<TourDto> tourList = tourService.tourAllList();
		System.out.println(tourList);
		return ResponseEntity.ok(tourList);
				
	}
	

	/*
	 * 투어 상세
	 */
	@Operation(summary = "투어의 상세 정보를 가져옴", description = "투어 상세 정보")
	@GetMapping("/{tourId}")
	public ResponseEntity<?> tourDetail(@PathVariable("tourId") int tourId) throws Exception{
		TourDto tourDto = tourService.tourDetail(tourId);
		return ResponseEntity.ok(tourDto);
	}
	
	/*
	 * 최신 투어 리스트
	 */
	@Operation(summary = "메인페이지 최근 투어 List 10개", description = "10개만 전달해줌")
	@GetMapping("/recentlist")
	public ResponseEntity<?> tourRandomList() throws Exception{
		List<TourDto> recentList = tourService.tourRecentList();
		return ResponseEntity.ok(recentList);
	}
	
	
	/*
	 * 투어 검색
	 */
//	@GetMapping("/search")
//	public ResponseEntity<?> tourSearch(@RequestBody ) throws Exception{
//		
//		return null;
//	}
	
	
	
	
	
	
	
	
}
