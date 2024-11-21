package com.with.withlocalhost.tour.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.with.withlocalhost.tour.model.TourDto;
import com.with.withlocalhost.tour.model.repository.TourRepository;

@Service
public class TourServiceImpl implements TourService {

	private final TourRepository tourRepo;

	public TourServiceImpl(TourRepository tourRepo) {
		this.tourRepo = tourRepo;
	}

	/*
	 * 투어 모든 list
	 */
	@Override
	@Transactional
	public List<TourDto> tourAllList() throws SQLException {
		// TODO Auto-generated method stub
		return tourRepo.tourAllList();
	}

	/*
	 * 투어 상세
	 */
	@Override
	@Transactional
	public TourDto tourDetail(int tourId) throws SQLException {
		// TODO Auto-generated method stub
		return tourRepo.tourDetail(tourId);
	}

	/*
	 * 투어 검색
	 */
	@Override
	@Transactional
	public List<TourDto> tourSearch() throws SQLException {
		
		return null;
	}

	/*
	 * 램덤한 투어 list
	 */
	@Override
	public List<TourDto> tourRecentList() throws SQLException {
		// TODO Auto-generated method stub
		return tourRepo.tourRecentList();
	}

}
