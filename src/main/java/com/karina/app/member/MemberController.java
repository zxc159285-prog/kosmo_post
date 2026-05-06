package com.karina.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.karina.app.board.notice.NoticeController;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    private final NoticeController noticeController;
	
	@Autowired
	private MemberService memberService;
	
	//마이페이지
	@GetMapping("mypage")
	public void mypage()throws Exception{}
	
	
	
	//개인정보수정
	@GetMapping("update")
	public void update(HttpSession session,Model model)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		model.addAttribute("memberDTO",memberDTO);
	}
	
	@PostMapping("update")
	public String update(@Validated(GroupUpdate.class) MemberDTO memberDTO,BindingResult bindingResult ,HttpSession session,Model model)throws Exception{
		
		if(bindingResult.hasErrors()) {
			return "member/update";
		}
		
		MemberDTO s=(MemberDTO)session.getAttribute("member");
		memberDTO.setUsername(s.getUsername());
		
		int result=memberServiceImpl.update(memberDTO);
		if(result>0) {
			s=memberServiceImpl.detail(s);
			session.setAttribute("member", s);
		}
		return "redirect:/";
	}
	
	

    MemberController(NoticeController noticeController, MemberServiceImpl memberServiceImpl) {
        this.noticeController = noticeController;
        this.memberServiceImpl = memberServiceImpl;
    }//이렇게해도 impl이 가능하다
	
	@GetMapping("idCheck")
	public String idCheck(MemberDTO memberDTO,Model model)throws Exception{
		memberDTO=memberService.idCheck(memberDTO);
		int result=0;
		if(memberDTO==null) {
			result=1;//1이면 중복아님
		}
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("join")
	public void join(MemberDTO memberDTO) throws Exception{
	}
	
	@PostMapping("join")
	public String join(@Validated(GroupAdd.class) MemberDTO memberDTO,BindingResult bindingResult,@RequestParam("attach") MultipartFile attach) throws Exception{
		
		if(memberServiceImpl.doubleCheck(memberDTO, bindingResult)) {
			
			return "member/join";
		}
			
			
		int result = memberService.join(memberDTO, attach);
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login(@ModelAttribute MemberDTO memberDTO) throws Exception{
		
	}

	@PostMapping("login")
	public String login(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		
		
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
