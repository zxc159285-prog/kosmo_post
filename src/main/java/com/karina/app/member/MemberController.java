package com.karina.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;//이렇게해도 impl이 가능하다
	
	@GetMapping("join")
	public void join() throws Exception{
	}
	@PostMapping("join")
	public String join(MemberDTO memberDTO,@RequestParam("attach") MultipartFile attach) throws Exception{
		int result = memberService.join(memberDTO, attach);
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() throws Exception{
		
	}

	@PostMapping("login")
	public String login(MemberDTO memberDTO,HttpSession session) throws Exception{
		memberDTO=memberService.detail(memberDTO);
		if(memberDTO != null) {
			session.setAttribute("member",memberDTO);
		}
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();//세션의 유지시간을 0으로 만들어준다
		return "redirect:/";
	}
}
