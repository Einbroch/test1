package com.dj.bbs.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.bbs.service.LoginService;
import com.dj.bbs.vo.EmpVO;

@Controller
@RequestMapping("/login")
public class Login2Controller {
	public static Logger logger = 
			LoggerFactory.getLogger(
					LoginController.class);
	
	@Inject
	private LoginService service;
	
	@RequestMapping("/login2")
	public void checkLogin(){
		
	}
	
	@ResponseBody
	@RequestMapping("/result2")
	public ResponseEntity<String> 
	checkIdAndPassword(
			@RequestBody @Valid EmpVO vo,
			BindingResult result){
		System.out.println("오긴 오냐?");
		System.out.println(result.getAllErrors());
		if(result.getAllErrors().size()==0){
			return new ResponseEntity<String>("sss",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("ddd",HttpStatus.BAD_REQUEST);
		}
	}
}





