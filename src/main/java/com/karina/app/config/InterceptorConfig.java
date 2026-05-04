package com.karina.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.karina.app.intorceptors.LoginCheckInterceptor;
import com.karina.app.intorceptors.TestInterceptor;

@Configuration //설정파일입니다
public class InterceptorConfig implements WebMvcConfigurer {

    private final LoginCheckInterceptor loginCheckInterceptor;

	@Autowired
	private TestInterceptor testInterceptor;

    InterceptorConfig(LoginCheckInterceptor loginCheckInterceptor) {
        this.loginCheckInterceptor = loginCheckInterceptor;
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//적용할 인터셉터 등록
		registry.addInterceptor(testInterceptor)
		//적용할 url등록 addPathPatterns 쉼표로도 가능, 여러번호출로도 가능
				.addPathPatterns("/notice/*","/qna/*")
				.excludePathPatterns("/notice/detail");//제외
		
		//member로 시작하는 모든 url, login, join
		//qna list를 제외한 모든것
		//상품가임,장바구니
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/member/*")
				.addPathPatterns("/qna/*")
				.excludePathPatterns("/member/login","/member/join")
				.excludePathPatterns("/qna/list");	
	}
}
