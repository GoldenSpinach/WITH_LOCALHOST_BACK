package com.with.withlocalhost.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

	@Value("${server.host}")
    private String serverHost;
	
	
	
	// 파일 업로드 메인 함수
	public String uploadFile(MultipartFile img) {
		// 1. 실제 경로 얻기
		String realPath = getRealPath();
		if (realPath == null) {
			System.out.println("경로를 찾을 수 없습니다.");
			return null;
		}

		// 2. 원본 파일 이름 가져오기
		String fileName = createFileName(getOriginName(img));
		System.out.println("fileName : " + fileName);
		// 3. 파일 저장 경로
		String fullPathName = realPath + fileName;
		System.out.println("저장파일 명 : " + fullPathName);
		
		String fullPath = serverHost + fileName;
		
		// 4. 파일 저장
		if (saveFile(img, fullPathName)) {
			System.out.println("File successfully uploaded: " + fileName);
			System.out.println("full path : " + serverHost+fileName);
			
			return fullPath;
		} else {
			System.out.println("error 발생했음!!!!");
			return null;
		}
	}

	// 실제 파일 저장 경로 얻기
	private String getRealPath() {
		String projectPath = getProjectPath(); // 프로젝트 경로
		if (projectPath == null) {
			return null;
		}
		String uploadDir = "/src/main/resources/static/img/"; // 상대 경로로 설정
		return projectPath + uploadDir;
	}

	// 프로젝트 경로 얻기
	private String getProjectPath() {
		try {
			String projectPath = Paths.get("").toAbsolutePath().toString();
			System.out.println("프로젝트 경로: " + projectPath);
			return projectPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 원본 파일 이름을 가져오는 메서드
	private String getOriginName(MultipartFile image) {
		return image.getOriginalFilename();
	}

	// 파일 저장 메서드
	private boolean saveFile(MultipartFile img, String fullPathName) {
		try {
			img.transferTo(new File(fullPathName));
			return true;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 파일 이름 생성 (UUID + 원본 파일 이름)
	private String createFileName(String fileName) {
		UUID uuid = UUID.randomUUID();
		return uuid.toString()+fileName;
	}
	
    // 파일 삭제 메서드
    public boolean deleteFile(String fileName) {
        // 1. 파일의 경로를 계산
        String realPath = getRealPath();
        if (realPath == null) {
            System.out.println("경로를 찾을 수 없습니다.");
            return false;
        }
        String filePath = realPath + fileName;

        // 2. 파일 객체 생성
        File fileToDelete = new File(filePath);
        if (fileToDelete.exists()) {
            // 3. 파일 삭제
            return fileToDelete.delete();
        } else {
            System.out.println("파일이 존재하지 않습니다: " + filePath);
            return false;
        }
    }
	
}
