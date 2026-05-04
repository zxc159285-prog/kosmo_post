package com.karina.app.aop.test;

import com.karina.app.intorceptors.LoginCheckInterceptor;
import org.springframework.stereotype.Component;

@Component
public class Transport {

    private final LoginCheckInterceptor loginCheckInterceptor;

    Transport(LoginCheckInterceptor loginCheckInterceptor) {
        this.loginCheckInterceptor = loginCheckInterceptor;
    }
	
	public Long takeBus(int num) {
		System.out.println(num+"번호 버스 이용");
		return 2000L;
	}
	
	public String takeSubway(String color) {
		System.out.println("지하철 이용 :"+color);
		return "subway";
	}
	
	public void useTaxi() {
		System.out.println("택시 이용");
	}
	
	public void walk() {
		System.out.println("걷기");
	}
}
