package com.with.withlocalhost.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.with.withlocalhost.tour.model.ActivityDto;
import com.with.withlocalhost.tour.model.CreateActivityDto;
import com.with.withlocalhost.tour.model.CreateTourDto;

public class FileUtil {

	private final String uploadDir ="C:\\imgs";
//	@Value("${test.upload-dir}")
//	private String uploadDir;

	public String uploadFile(MultipartFile img) {
	    System.out.println("여기왔음@@@@@@@@@");

	    String fileName = getOriginName(img); 
	    String fullPathName = uploadDir + fileName;
	    try {
			img.transferTo(new File(fullPathName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    System.out.println("fileName : " + fileName);
	    return fileName;  // fileName만 반환
	}

	private String getOriginName(MultipartFile image){
	    return image.getOriginalFilename();
	}
}
