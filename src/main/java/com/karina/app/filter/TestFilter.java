package com.karina.app.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class TestFilter
 */
//루트밑에 qna로 시작되는 모든url은 이 필터를 거쳐가게한다 베이스페키지 메인메서드위에도 어노테이션줘야한다
public class TestFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TestFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("필터 인");
		
		HttpSession session =((HttpServletRequest) request).getSession();
		Object obj=session.getAttribute("member");
		if(obj !=null) {
			
		
		
		chain.doFilter(request, response);//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ기준
		}else {
			((HttpServletResponse)response).sendRedirect("/member/login");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
