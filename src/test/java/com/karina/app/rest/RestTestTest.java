package com.karina.app.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTestTest {

	@Autowired
	private RestTest restTest;
	
	
	@Test
	void test() throws Exception{
		restTest.list();
		
		
	}

}
