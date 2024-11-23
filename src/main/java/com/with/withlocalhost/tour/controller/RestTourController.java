package com.with.withlocalhost.tour.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.with.withlocalhost.tour.model.CreateTourDto;
import com.with.withlocalhost.tour.model.SearchCriteriaDto;
import com.with.withlocalhost.tour.model.TourDto;
import com.with.withlocalhost.tour.model.service.TourService;
import com.with.withlocalhost.util.FileUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tour")
@CrossOrigin(origins = "http://localhost:5173")  // 프론트엔드 URL 지정
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
	public ResponseEntity<?> tourAllList() throws Exception {
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
	public ResponseEntity<?> tourDetail(@PathVariable("tourId") int tourId) throws Exception {
		TourDto tourDto = tourService.tourDetail(tourId);
		return ResponseEntity.ok(tourDto);
	}

	/*
	 * 최신 투어 리스트
	 */
	@Operation(summary = "메인페이지 최근 투어 List 10개", description = "10개만 전달해줌")
	@GetMapping("/recentlist")
	public ResponseEntity<?> tourRandomList() throws Exception {
		List<TourDto> recentList = tourService.tourRecentList();
		return ResponseEntity.ok(recentList);
	}

	/*
	 * 투어 검색
	 */
	@Operation(summary = "투어 검색 ( 구분해놨음 )", description = "10개만 전달해줌")
	@PostMapping("/search")
	public ResponseEntity<?> tourSearch(@RequestBody SearchCriteriaDto searchCriteriaDto) throws Exception {
		System.out.println("tourSearch");
		System.out.println(searchCriteriaDto);
		List<TourDto> searchList = tourService.tourSearch(searchCriteriaDto);
		return ResponseEntity.ok(searchList);
	}

	@Operation(summary = "tour 생성 ( insert )", description = "")
	@PostMapping("/create")
	public ResponseEntity<?> createTour(@RequestPart(required = false) CreateTourDto tourdto,
			@RequestPart(required = false) MultipartFile mainImg,
			@RequestPart(required = false) List<MultipartFile> activityImg) throws Exception {
			tourService.createTour(tourdto, mainImg, activityImg);

		return ResponseEntity.ok("success");
	}

	@Operation(summary="내가 등록한 투어 목록 ( 마이 투어 리스트 ) ")
	@GetMapping("/mytour")
	public ResponseEntity<?> myTourList(@RequestParam String userId) throws Exception{
		List<TourDto> myTourList = tourService.myTourList(userId);
		return ResponseEntity.ok(myTourList);
	}
	
	
	/*
	 * 
	 * 수정은 상의 하고 나서 구현하기
	 */

}
