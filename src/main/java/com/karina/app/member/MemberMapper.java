package com.karina.app.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper{

	public int update(MemberDTO memberDTO) throws Exception;
	public int join(MemberDTO memberDTO)throws Exception;
	
	public int addProfile(ProfileDTO profileDTO)throws Exception;
	
	public MemberDTO detail(MemberDTO memberDTO)throws UsernameNotFoundException;
}
