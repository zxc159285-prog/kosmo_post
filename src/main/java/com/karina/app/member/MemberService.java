package com.karina.app.member;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	
	public int update(MemberDTO memberDTO) throws Exception;
	public boolean doubleCheck(MemberDTO memberDTO, BindingResult bindingResult) throws Exception;

	public int join(MemberDTO memberDTO,MultipartFile file)throws Exception;
	
	public MemberDTO detail(MemberDTO memberDTO)throws Exception;
	
	public MemberDTO idCheck(MemberDTO memberDTO) throws Exception;
}
