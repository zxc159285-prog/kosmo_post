package com.karina.app.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karina.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("reviewlist")
	
	public void list(ReviewDTO reviewDTO,Model model) throws Exception{
		
		List<ReviewDTO> ar= reviewService.list(reviewDTO);
		model.addAttribute("list", ar);
		return ;
	}
	@GetMapping("list")
	public void list() throws Exception{}
	
	@PostMapping("create")
	@ResponseBody //리턴으로 나가는걸json으로 jsp를 안거치고바로 내보내겠다
	public int create(HttpSession session,ReviewDTO reviewDTO,Model model)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		reviewDTO.setUsername(memberDTO.getUsername());		
		int result=reviewService.create(reviewDTO);
		model.addAttribute("result", result);
		return result;
	}
	
	@PostMapping("delete")
	@ResponseBody
	public int delete(ReviewDTO reviewDTO,Model model) throws Exception{
		int result = reviewService.delete(reviewDTO);
		model.addAttribute("result", result);
		return result;
	}
	
	@PostMapping("update")
	@ResponseBody
	public int update(ReviewDTO reviewDTO,Model model)throws Exception{
		int result= reviewService.update(reviewDTO);
		model.addAttribute("result", result);
		return result;
	}
}