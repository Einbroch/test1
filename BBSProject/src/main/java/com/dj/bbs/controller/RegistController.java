package com.dj.bbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.bbs.service.LoginService;
import com.dj.bbs.service.LoginServiceInterface;
import com.dj.bbs.service.LoginSubService;
import com.dj.bbs.vo.EmpVO;

@Controller
@RequestMapping("/assign")
public class RegistController {
	
	//static Logger logger = Logger.getLogger(RegistController.class);
	Logger logger = 
			LoggerFactory.getLogger(
					RegistController.class);
	
	@Inject
	//private LoginService service;
	private LoginServiceInterface service;
	
	@Inject
	private LoginSubService sService;
	
	@RequestMapping("/regist")
	public void registController(){
		logger.info("registController ����..............");
		//logger.debug("registController �����.............");
		logger.error("registController ����..............");
	}
	
	@RequestMapping("/check")
	public ResponseEntity<EmpVO> checkIdController(
			@RequestBody EmpVO vo){
		System.out.println("����� ����");
		//vo.setMsg("�̰��� �׽�Ʈ �Դϴ�.");
		ResponseEntity<EmpVO> entity = null;
		if(service.checkIdService(vo)){
			vo.setMsg("�ش� ID�� ��� �����մϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.OK);
		}else{
			vo.setMsg("�ش� ID�� ����Ͻ� �� �����ϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.NOT_FOUND);
		}
		
		return entity;
	}
	/*@RequestMapping("/check")
	public @ResponseBody EmpVO checkIdController(
			@RequestBody EmpVO vo){
		System.out.println("����� ����");
		vo.setMsg("�̰��� �׽�Ʈ �Դϴ�.");
		return vo;
	}*/
	
	@RequestMapping("/setemp")
	public ResponseEntity<EmpVO> setEmp(@RequestBody EmpVO vo){
		System.out.println("setemp Ȯ��");
		ResponseEntity<EmpVO> entity = null;
		/*if(service.setEmp(vo)){
			vo.setMsg("�ش� ID�� ��� �����մϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.OK);
		}else{
			vo.setMsg("�ش� ID�� ����Ͻ� �� �����ϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.NOT_FOUND);
		}*/
		try {
			//service.setEmp(vo);
			sService.setEmp(vo);
			vo.setMsg("�ش� ID�� ��� �����մϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.OK);
		} catch (Exception e) {
			vo.setMsg("�ش� ID�� ����Ͻ� �� �����ϴ�.");
			entity = 
					new ResponseEntity<EmpVO>(
							vo,HttpStatus.NOT_FOUND);
		}
		
		return entity;
	}
	
}





