package com.karina.app.member;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class MemberDTO implements UserDetails{

	@NotBlank(groups = GroupAdd.class) //최소한 한글자 이상은 되야합니다 라는 뜻
	private String username;
	@NotBlank(groups = {GroupAdd.class, GroupUpdate.class})
	private String name;
	
	@Size(groups = GroupAdd.class,max=11,min=4) //최소4글자이상 11글자이하
	@NotBlank(groups = GroupAdd.class)
	private String password;
	//db에 안넣고 패스워드와 비교해보기위한것
	private String passwordCheck;
	
	private String phone;
	@Email(groups = {GroupAdd.class, GroupUpdate.class}) //이메일표현식 이어야한다
	private String email;
	@Past(groups = {GroupAdd.class, GroupUpdate.class})//현재보다 이전으로 해야한다 반대로 미래를 골라야한다면 @퓨쳐
	private LocalDate birth;
	
	private boolean accountNonLocked;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	// 회원 한명당 하나의 프로필을 가지고있다.  만약 여러개를 가지고있다면 리스트로한다
	private ProfileDTO profileDTO;

	private List<RoleDTO> roles;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> ar = new ArrayList<>();
		
		for(RoleDTO roleDTO :  this.roles) {
			GrantedAuthority g = new SimpleGrantedAuthority(roleDTO.getRoleName());
			ar.add(g);
		}
		
		return ar;
	}

	

	
}
