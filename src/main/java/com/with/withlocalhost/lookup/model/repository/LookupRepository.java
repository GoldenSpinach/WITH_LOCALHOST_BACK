package com.with.withlocalhost.lookup.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.with.withlocalhost.lookup.model.CategoryDto;
import com.with.withlocalhost.lookup.model.CityDto;
import com.with.withlocalhost.lookup.model.RegionDto;

@Mapper
public interface LookupRepository {

	//select 도
	List<RegionDto> getRegionList() throws SQLException;
	
	//select 시
	List<CityDto> getCityList(int regionId) throws SQLException;
	
	//select 카테고리
	List<CategoryDto> getCategory(String type) throws SQLException;
	
}
