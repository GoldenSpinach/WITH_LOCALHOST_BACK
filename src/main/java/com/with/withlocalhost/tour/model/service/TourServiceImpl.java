package com.with.withlocalhost.tour.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.with.withlocalhost.tour.model.CreateActivityDto;
import com.with.withlocalhost.tour.model.CreateTourDto;
import com.with.withlocalhost.tour.model.SearchCriteriaDto;
import com.with.withlocalhost.tour.model.TourDto;
import com.with.withlocalhost.tour.model.repository.TourRepository;
import com.with.withlocalhost.util.FileUtil;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service
public class TourServiceImpl implements TourService {

	private final TourRepository tourRepo;
	
	private final FileUtil fileUtil;

	public TourServiceImpl(TourRepository tourRepo , FileUtil fileUtil) {
		this.tourRepo = tourRepo;
		this.fileUtil = fileUtil;
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
	public List<TourDto> tourSearch(SearchCriteriaDto searchCriteriaDto) throws SQLException {
		return tourRepo.tourSearch(searchCriteriaDto);
	}

	/*
	 * 최근 등록한 게시물
	 */
	@Override
	public List<TourDto> tourRecentList() throws SQLException {
		return tourRepo.tourRecentList();
	}

	/*
	 * 투어 만들기
	 */
	@Transactional
	@Override
	public String createTour(CreateTourDto tourdto, MultipartFile mainImg, List<MultipartFile> activityImg)
			throws SQLException {
		FileUpload(tourdto , mainImg , activityImg);
		
		tourRepo.createTour(tourdto);
		int tourId = tourdto.getTourId();
		
		// category add
		tourRepo.createCategory(tourdto);
		// activity add
		tourRepo.createActivity(tourdto);
		// option add
		tourRepo.createOption(tourdto);
		
		
		
		
		return "fail";
		
	}

	/*
	 * fileUpload 처리
	 */
	public void FileUpload(CreateTourDto tourdto, MultipartFile mainImg, List<MultipartFile> activityImg) {
//		FileUtil fileUtil = new FileUtil();
		
		// mainImg 파일 저장
		if(mainImg !=null) {
			String fileName = fileUtil.uploadFile(mainImg);
			System.out.println(" @@@@@@@ fileName : " + fileName);
			tourdto.setMainImgUrl(fileName);			
		}
		List<CreateActivityDto> actList = tourdto.getActivities();
		if(actList != null && activityImg != null) {
			for(int i=0;i<activityImg.size() ;i++) {
				String actFileName = fileUtil.uploadFile(activityImg.get(i));
				actList.get(i).setActImgUrl(actFileName); // 이미지 이름 설정
             
			}
		}
		
		//데이터 저장이 완료되었을 경우 isert하는 구문 생성이 필요함
		
		
	}

	/*
	 * 내 투어 목록
	 */
	@Override
	public List<TourDto> myTourList(String userId) throws SQLException {
		
		return tourRepo.myTourList(userId);
	}
	
	
	
}
