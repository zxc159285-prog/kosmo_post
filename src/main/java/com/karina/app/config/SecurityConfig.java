package com.karina.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Bean //정적자원(프론트자원)에 대한 설정
	WebSecurityCustomizer customizer() {
		return web -> {
			web.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/images/**","/img/**","/js/**","vendor/**")
				.requestMatchers("/files/**","/fileDown/**")
				;
		}; 
	}
	//인증과 인가에 대한 설정
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		//인가(권한)에 대한 설정 노티스 3개 를 제외하면 모두통과시키겠다
		security
			.cors(cros->{cros.disable();})
			.csrf(csrf->{csrf.disable();})
			.authorizeHttpRequests(auth->{
				auth		
			.requestMatchers("/notice/create","/notice/update","/notice/delete").hasRole("ADMIN")
			.requestMatchers("/qna/delete","/qna/update","/qna/create","/qna/detail").hasRole("MEMBER")
			.requestMatchers("/product/delete","/product/update","/product/create").hasAnyRole("ADMIN","MANAGER")
			.requestMatchers("/member/mypage","/member/logout","/mem/update").authenticated()//인증된사람들(로그인한사람들)
			
			.anyRequest().permitAll()//그외 나머지는 모두 허용
			//.anyRequest().denyAll()//모두 거절
			;
		})
		//login form 과 관련된 설정
		.formLogin(form->{
			form
				.loginPage("/member/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.loginProcessingUrl("/member/login")
				.defaultSuccessUrl("/")
				.failureUrl("/")
				;
		})
		
		.logout(logout->{
			logout
				.logoutUrl("/member/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/")
				;
			
		})
		
		;
		
	
		
		return security.build();
	}
	
}
