package com.with.withlocalhost.lookup.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.with.withlocalhost.lookup.model.CategoryDto;
import com.with.withlocalhost.lookup.model.CityDto;
import com.with.withlocalhost.lookup.model.RegionDto;
import com.with.withlocalhost.lookup.model.service.LookupService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/lookup")
public class RestLookupController {

	private final LookupService lookupService;
	public RestLookupController(LookupService lookupService) {
		this.lookupService = lookupService;
	}
	
	/*
	 * select 도 ( 경기도 , 서울특별시 )
	 */
	@Operation(summary = "도 단위 리스트 조회 ", description = "")
	@GetMapping("/region")
	public ResponseEntity<?> getRegionList() throws Exception{
		System.out.println("getregion 도착");
		List<RegionDto> regionList = lookupService.getRegionList();
		
		return ResponseEntity.ok(regionList);
	}
	
	/*
	 * select 시 ( 화성시 , 성남시)
	 */
	@Operation(summary = "시 단위 리스트 조회", description = "시 regionId 입력")
	@GetMapping("/city")
	public ResponseEntity<?> getCityList(@RequestParam int regionId) throws Exception{
		System.out.println("getCity 도착" + " id : " + regionId );
		List<CityDto> cityList = lookupService.getCityList(regionId);
	
		return ResponseEntity.ok(cityList);
	}
	
	/*
	 * select 카테고리
	 * O:옵션, A:패키지, C:카테고리
	 */
	@Operation(summary = "카테고리 리스트 조회", description = "O:옵션, A:패키지, C:카테고리 parameter로 입력")
	@GetMapping("/category")
	public ResponseEntity<?> getCategoryList(@RequestParam String type) throws Exception{
		System.out.println("getre category  도착" + " type : "  +type);
		List<CategoryDto> categoryList = lookupService.getCategory(type);
		return ResponseEntity.ok(categoryList);
	}
	
}
