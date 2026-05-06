package com.karina.app.member;

import java.time.LocalDate;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class MemberDTO {

	@NotBlank //최소한 한글자 이상은 되야합니다 라는 뜻
	private String username;
	//@NotBlank
	private String name;
	
	@Size(max=11,min=4) //최소4글자이상 11글자이하
	@NotBlank
	private String password;
	
	private String phone;
	//@Email //이메일표현식 이어야한다
	private String email;
	//@Past//현재보다 이전으로 해야한다 반대로 미래를 골라야한다면 @퓨쳐
	private LocalDate birth;
	
	// 회원 한명당 하나의 프로필을 가지고있다.  만약 여러개를 가지고있다면 리스트로한다
	private ProfileDTO profileDTO;
}
