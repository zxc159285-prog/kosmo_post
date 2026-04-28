package com.karina.app.member;

import org.springframework.web.multipart.MultipartFile;

public interface MemberService {

	public int join(MemberDTO memberDTO,MultipartFile file)throws Exception;
	
	public MemberDTO detail(MemberDTO memberDTO)throws Exception;
	
	public MemberDTO idCheck(MemberDTO memberDTO) throws Exception;
}
