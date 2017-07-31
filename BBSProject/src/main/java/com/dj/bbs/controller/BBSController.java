package com.dj.bbs.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.bbs.model.BbsDAO;
import com.dj.bbs.service.BbsService;
import com.dj.bbs.service.LoginService;
import com.dj.bbs.vo.BbsVO;
import com.dj.bbs.vo.EmpVO;

@Controller
@RequestMapping("/list")
public class BBSController {
	
	@Inject
	private BbsService service;
	@Inject
	private LoginService service1;
	
	@RequestMapping("/bbs")
	public void bbsList(){
		
	}
	
	@RequestMapping("/bbs2")
	public void bbsList2(){
		
	}
	
	@RequestMapping("/input")
	public void bbsInput(HttpServletRequest request){
		request.getSession().setAttribute("user", service1.getEmpDetail());
	}
	
	@RequestMapping("/data/{page}")
	public @ResponseBody List<BbsVO> 
	callListController(@PathVariable int page){	
		return service.getBbsList(page);
	}
	
	@RequestMapping("/inputResult")
	public @ResponseBody String inputBBSinfo(@RequestBody BbsVO vo, HttpServletRequest request){
		
		try {
			EmpVO evo = (EmpVO)request.getSession().getAttribute("user");
			vo.setOwnerId(evo.getId());
			vo.setOwnerName(evo.getName());
			service.setBbsInfo(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "성공적 입력";
	}
	
	@RequestMapping("/det")
	public void showBbsDetail(){
		
	}
	
	@RequestMapping("/detail")
	public @ResponseBody BbsVO getBbsDetailController(@RequestBody BbsVO vo) throws Exception{
		vo = service.getBBSDetail(vo);
		return vo;
	}
}




