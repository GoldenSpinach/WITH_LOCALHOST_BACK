package com.with.withlocalhost.tour.model.service;

import java.sql.SQLException;
import java.util.List;

import com.with.withlocalhost.tour.model.TourDto;

public interface TourService {

	List<TourDto> tourAllList()  throws SQLException;
	
	TourDto tourDetail(int tourId) throws SQLException;
	
	List<TourDto> tourSearch() throws SQLException;
	
	List<TourDto> tourRecentList() throws SQLException;
	
}
