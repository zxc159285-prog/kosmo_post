package com.karina.app.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.security.auth.login.CredentialException;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFailHandler implements AuthenticationFailureHandler{
	@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			
		
		
		
			String message="로그인 실패";
			//instanceof 이 변수가 어느 클래스 타입입니까?
			
			if(exception instanceof AccountExpiredException) {
				//계정이 만료되었을때
				message="계정만료";
			}
			if (exception instanceof LockedException) {
				//계정이 잠겼을때
				message="계정 잠금상태";
			}
			if (exception instanceof CredentialsExpiredException) {
				//비밀번호 유효기간 만료
				message="비밀번호 유효기간 만료";
			}
			if (exception instanceof DisabledException) {
				//휴면계정
				message="휴면계정";
			}
			if (exception instanceof BadCredentialsException) {
				//비밀번호가 틀림
				message="비밀번호 불일치";
			}
			if (exception instanceof InternalAuthenticationServiceException) {
				//ID가 틀림
				message="ID 불일치";
			}
			message=URLEncoder.encode(message,"UTF-8");
			response.sendRedirect("/member/login?message="+message);
		}

}
