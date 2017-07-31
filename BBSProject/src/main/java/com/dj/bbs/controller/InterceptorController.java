package com.dj.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inter")
public class InterceptorController {
	
	@RequestMapping("/doA")
	public String doA(Model model){
		System.out.println(".......doA");
		model.addAttribute("str", "юнем╪аем doA");
		return "/inter/example1";
	}
	
	@RequestMapping("/doB")
	public String doB(){
		System.out.println(".......doB");
		return "/inter/example1";
	}
	
	@RequestMapping("/doC")
	public String doC(HttpServletRequest request){
		System.out.println(".......doC");
		request.getSession().invalidate();
		return "/inter/example1";
	}
	
	@RequestMapping("/doD")
	public String doD(){
		System.out.println(".......doD");
		return "/inter/example1";
	}
}
