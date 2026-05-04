package com.karina.app.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect //aop 설정
@Slf4j
public class Card {

	//"execution(접근지정자 패키지명.클래스명.메서드명(매개변수타입))"
	@Around("execution(* com.karina.app.aop.test.Transport.take*(..))")
	public Object cardCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("타기 전 card check");
		Object [] ar=proceedingJoinPoint.getArgs();
		log.info("{}",ar);
		
		Object obj=proceedingJoinPoint.proceed(); //메서드에서 리턴하는걸 obj로 받고 리턴으로 다시돌려준다
		System.out.println("하차 후 card check");
		
		log.info("return : {}",obj);
		return obj;
	}
}
