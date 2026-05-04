package com.karina.app.aop.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional //테스트케이스에 주면 메서드가 실행되도 db에 영향을 주지않는다 
				//메서드위에 @Rollback(false)를 주면 db에도 영향을준다
class TransportTest {
	
	@Autowired
	private Transport transport;
	
	@Autowired
	private Card card;

	@Test
	void test() {
	
		transport.useTaxi();
		
		transport.takeBus(50);
		
		transport.takeSubway("yellow");
		
		transport.walk();
		
	
	}

}
