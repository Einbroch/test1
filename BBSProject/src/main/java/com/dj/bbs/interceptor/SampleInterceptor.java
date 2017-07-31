package com.dj.bbs.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{
	
	@Override // 컨트롤러에 메서드가 실행 되기 전 발동
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handle calling...");
		
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean : "+method.getBean());
		System.out.println("Method : "+methodObj);
		
		return super.preHandle(request, response, handler);
	}
	
	@Override // 컨트롤러 메서드 실행직 후 view 페이지 렌더링 전 발동
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post handle calling...");
		
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean : "+method.getBean());
		System.out.println("Method : "+methodObj);
		
		Map<String, Object> map = modelAndView.getModel();
		System.out.println(map.get("str"));
		modelAndView.addObject("str", "인터셉터 doB");
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
