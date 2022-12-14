package com.pet.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils2 {

	public static String fileUpload(String uploadPath, String fileName, byte[] fileData)
			throws Exception {

		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();

		String newFileName = uid + "_" + fileName; // "랜덤문자_파일명"
		String imgPath = uploadPath; // 업로드 경로 + 연월일 경로 = 이미지 저장 경로
		
		// 이미지 저장 경로에 원본 파일을 저장
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		
		return newFileName;
	}


}