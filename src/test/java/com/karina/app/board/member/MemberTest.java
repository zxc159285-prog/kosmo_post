package com.karina.app.board.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.karina.app.member.MemberMapper;

@SpringBootTest
public class MemberTest {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Test
	void setPassword()throws Exception{
		
		String s = passwordEncoder.encode("!Wlalfjf123");
		System.out.println(s);
	}
}
