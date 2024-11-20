package com.with.withlocalhost.lookup.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.lookup.model.CategoryDto;
import com.with.withlocalhost.lookup.model.CityDto;
import com.with.withlocalhost.lookup.model.RegionDto;
import com.with.withlocalhost.lookup.model.repository.LookupRepository;

@Service
public class LookupServiceImpl implements LookupService {

	private final LookupRepository lookupRepo;

	public LookupServiceImpl(LookupRepository repo) {
		this.lookupRepo = repo;
	}

	/*
	 * select 도 ( 경기도 , 서울특별시 )
	 */
	@Override
	public List<RegionDto> getRegionList() throws SQLException {
		return lookupRepo.getRegionList();
	}

	/*
	 * select 시 ( 화성시 , 성남시)
	 */
	@Override
	public List<CityDto> getCityList(int regionId) throws SQLException {
		// TODO Auto-generated method stub
		return lookupRepo.getCityList(regionId);
	}

	/*
	 * select 카테고리 O:옵션, A:패키지, C:카테고리
	 */
	@Override
	public List<CategoryDto> getCategory(String type) throws SQLException {
		return lookupRepo.getCategory(type);
	}

}
