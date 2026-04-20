package com.karina.app.member;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class MemberDTO {

	private String username;
	private String name;
	private String password;
	private String phone;
	private String email;
	private LocalDate birth;
	
	// 회원 한명당 하나의 프로필을 가지고있다.  만약 여러개를 가지고있다면 리스트로한다
	private ProfileDTO profileDTO;
}
