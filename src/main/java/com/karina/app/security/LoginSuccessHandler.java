package com.karina.app.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String s = request.getParameter("rememberId");
		try {
			if (s.equals("1")) {
				log.info("Login Success :{}",authentication.getName());
				//jakarta servlet 어쩌구 하는걸로해야함 
				Cookie cookie=new Cookie("rememberId",authentication.getName());
				cookie.setMaxAge(604800);//얼마동안 이 쿠키를 저장할것인가
				cookie.setPath("/");
				response.addCookie(cookie);
				
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			Cookie cookie=new Cookie("rememberId","");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		} 
		
		
		response.sendRedirect("/");
	}
}
