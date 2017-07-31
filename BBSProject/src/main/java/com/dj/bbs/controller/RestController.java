package com.dj.bbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.bbs.vo.EmpVO;
import com.dj.bbs.vo.TestVO;

@Controller
@RequestMapping("/rest")
public class RestController {
	
	@RequestMapping("/test1")
	public @ResponseBody TestVO test1Controller(@RequestBody TestVO test){
		System.out.println(test.getId());
		System.out.println(test.getPw());
		System.out.println(test.getName());
		System.out.println(test.getAge());
		return test;
	}
	
	@RequestMapping("/test2")
	public @ResponseBody List<TestVO> test2Controller(@RequestBody TestVO test){
		List<TestVO> list = new ArrayList<TestVO>();
		list.add(test);
		list.add(test);
		list.add(test);
		list.add(test);
		list.add(test);
		
		return list;
	}
	
	@RequestMapping("/test3")
	public @ResponseBody Map<String,TestVO> test3Controller(@RequestBody TestVO test){
		Map<String,TestVO> map = new HashMap<String, TestVO>();
		map.put("1", test);
		map.put("2", test);
		map.put("3", test);
		map.put("4", test);
		map.put("5", test);

		return map;
	}
	
	@RequestMapping("/test4")
	public @ResponseBody List<TestVO> test4Controller(@RequestBody List<TestVO> tests){
		for(TestVO vo : tests){
			System.out.println("id :"+vo.getId()+"  pw : "+vo.getPw());
		}
		return tests;
	}
	
	/*@RequestMapping("/test5")
	public @ResponseBody Map<String,TestVO> test5Controller(@RequestBody Map<String,TestVO> tests){
		for(TestVO vo : tests){
			System.out.println("id :"+vo.getId()+"  pw : "+vo.getPw());
		}
		return tests;
	}*/
	
	@RequestMapping("/test6")
	public @ResponseBody EmpVO test6Controller(){
		EmpVO vo = new EmpVO();
		vo.setUserid("abcd");
		vo.setPassword("1234");
		return vo;
	}
}
