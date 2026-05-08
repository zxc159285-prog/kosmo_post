package com.karina.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.karina.app.member.MemberServiceImpl;
import com.karina.app.security.AddLogout;
import com.karina.app.security.AddLogoutHandler;
import com.karina.app.security.LoginFailHandler;
import com.karina.app.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
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
				.usernameParameter("username")//기존 세터이름이 유저네임 패스워드라면 두개는 안해도됨
				.passwordParameter("password")
				.loginProcessingUrl("/member/login")
				//.defaultSuccessUrl("/") // 석세스핸들러와 동시에 사용못함 둘중하나만 가능
				.successHandler(loginSuccessHandler)//로그인 성공후 추가적인 작업을 하고싶을때(아이디저장)
				//.failureUrl("/") //로그인 실패했을때
				.failureHandler(new LoginFailHandler())
				;
		})
		
		.logout(logout->{
			logout
				.logoutUrl("/member/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				//.logoutSuccessUrl("/")
				.addLogoutHandler(new AddLogout())
				.logoutSuccessHandler(new AddLogoutHandler())
				;
			
		})
		
		.rememberMe(remember->{
			remember
				.rememberMeParameter("rememberMe")
				.key("rememberKey")
				.tokenValiditySeconds(60*60*24*7)
				.userDetailsService(memberServiceImpl)
				.authenticationSuccessHandler(loginSuccessHandler)
				.useSecureCookie(true)
				;
		})
		//동시접속 제어
		.sessionManagement(session->{
			session
				.maximumSessions(1)//인원
				.maxSessionsPreventsLogin(true)//누구를 거부할것인가
				.expiredUrl("/member/login")
				;
		})
		
		;
		
	
		
		return security.build();
	}
	
}
