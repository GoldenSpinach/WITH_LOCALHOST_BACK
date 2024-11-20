package com.with.withlocalhost.tour.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.with.withlocalhost.tour.model.TourDto;

@Mapper
public interface TourRepository {

	// 투어 전체 리스트
	List<TourDto> tourAllList() throws SQLException;

	// 투어 상세
	TourDto tourDetail(String tourId) throws SQLException;
	
	// 투어 검색 리스트
	List<TourDto> tourSearch() throws SQLException;
	
	// 투어 랜덤 리스트
	List<TourDto> tourRandomList() throws SQLException;
	

	
}
