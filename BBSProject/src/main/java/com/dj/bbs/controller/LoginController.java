package com.dj.bbs.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dj.bbs.service.LoginService;
import com.dj.bbs.vo.EmpVO;

@Controller
@RequestMapping("login")
public class LoginController {
	
	public static Logger logger = LoggerFactory.getLogger(LoginController.class); 

	@Inject
	private LoginService service;

	@RequestMapping("/login")
	public void checkLogin(@CookieValue(value = "bbs", defaultValue = "0") String id, Model model) {
		/* System.out.println("ÄíÅ°°ª : "+id); */
		model.addAttribute("id", id);
	}
	
	@RequestMapping("/result")
	public String checkAccount(@ModelAttribute EmpVO vo, HttpServletResponse response, HttpServletRequest requset) {
		if (service.isExistEmp(vo)) {
			Cookie cookie = new Cookie("bbs", vo.getUserid());
			if (vo.getRemeber() != null) {
				cookie.setMaxAge(6000);
				response.addCookie(cookie);
			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "login/result";
		} else {
			return "redirect:login";
		}
	}
}
