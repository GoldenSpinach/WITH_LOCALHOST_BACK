package com.with.withlocalhost.tour.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.with.withlocalhost.tour.model.CreateTourDto;
import com.with.withlocalhost.tour.model.SearchCriteriaDto;
import com.with.withlocalhost.tour.model.TourDto;

public interface TourService {

	List<TourDto> tourAllList()  throws SQLException;
	
	TourDto tourDetail(int tourId) throws SQLException;
	
	List<TourDto> tourSearch( SearchCriteriaDto  searchCriteriaDto) throws SQLException;
	
	List<TourDto> tourRecentList() throws SQLException;
	
	String createTour(CreateTourDto tourdto , MultipartFile mainImg , List<MultipartFile> activityImg) throws SQLException;

	List<TourDto> myTourList(String userId) throws SQLException;
}
