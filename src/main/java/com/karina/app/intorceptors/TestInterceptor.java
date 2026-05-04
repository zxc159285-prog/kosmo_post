package com.karina.app.intorceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class TestInterceptor implements HandlerInterceptor{
	
	//Controller 들어오기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//리턴이 트루면 컨트롤러로 진입 폴스면 컨트롤러로 진입을 막음
		System.out.println("Pre handle");
		return true;
	}
	
	//Controller 빠져나갈때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Post handle");
	}
	
	//jsp에서 html로 렌더링 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("after");
	}

}
