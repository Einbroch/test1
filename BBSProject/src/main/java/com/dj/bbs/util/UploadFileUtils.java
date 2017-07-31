package com.dj.bbs.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.spi.CalendarDataProvider;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.dj.bbs.vo.BbsVO;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer;

public class UploadFileUtils {
	public static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	/*
	 * uploadPath : 재생성 
	 * originalName : 타이틀 
	 * fileData : 가지고온 데이터
	 * id : index 테이블에서 가져온 아이디 값
	 * 
	 */
	public static void contentFile(String uploadPath, BbsVO bbs)throws Exception {
		//UUID uid = UUID.randomUUID();
		//String savedName = uid.toString() + "_" + originalName;
		String savedName = bbs.getId()+".html";
		String savedPath = calcPath(uploadPath);
		System.out.println(uploadPath);
		System.out.println(savedPath);
		System.out.println(savedName);
		System.out.println(bbs.getContent());
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(bbs.getContent().getBytes(), target);
		bbs.setContentPath(savedPath);
		bbs.setContent(savedName);
	}

	// 파일 저장경로, 원본파일이름, 파일 데이터
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadFileName = null;
		if (MediaUtils.getMediaType(formatName) != null) {
			uploadFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadFileName;
	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}

	// 디렉토리를 만드는 메서드
	private static void makeDir(String uploadPath, String... paths) {
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();// 디렉토리를 생성하는 명령문
			}
		}
	}

	// 썸네일 이미지 생성하기
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		// 메모리상 이미지
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

		BufferedImage descImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(descImg, formatName.toUpperCase(), newFile);

		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}