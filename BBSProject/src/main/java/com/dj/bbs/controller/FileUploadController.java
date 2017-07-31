package com.dj.bbs.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(
					FileUploadController.class);
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	
	@RequestMapping("/uploadForm")
	public void uploadForm(){
		
	}
	
	@RequestMapping("/uploadForm1")
	public void uploadForm1(MultipartFile file, 
			Model model) throws Exception{
		logger.info("originalName : "+file.getOriginalFilename());
		logger.info("size : "+file.getSize());
		logger.info("contentType : "+file.getContentType());
		
		String savedName = uploadFile(
				file.getOriginalFilename(), 
				file.getBytes());
		
		model.addAttribute("savedName", savedName);
		//logger.info(savedName);
	}
	
	private String uploadFile(
			String originalName, byte[] fileData) 
	throws Exception{
		// ������ �ֱ����� ������ ����
		// UUID (Universally unique identifier)
		UUID uid = UUID.randomUUID();
		logger.info(uid.toString());
		// ������ + ���� Ŭ���̾�Ʈ �̸����� �ռ�
		String savedName = uid.toString() +"_"+originalName;
		// FILE��ü�� ���� ���� ���ϴ� ���� ���� ���ε�
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData,target);
		// Save�� ���� �̸� ����
		return savedName;
	}
}