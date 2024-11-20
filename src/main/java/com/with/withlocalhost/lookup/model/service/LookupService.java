package com.with.withlocalhost.lookup.model.service;

import java.sql.SQLException;
import java.util.List;

import com.with.withlocalhost.lookup.model.CategoryDto;
import com.with.withlocalhost.lookup.model.CityDto;
import com.with.withlocalhost.lookup.model.RegionDto;

public interface LookupService {

	List<RegionDto> getRegionList() throws SQLException;
	
	List<CityDto> getCityList(int regionId) throws SQLException;
	
	List<CategoryDto> getCategory(String type) throws SQLException;
	
	
}
