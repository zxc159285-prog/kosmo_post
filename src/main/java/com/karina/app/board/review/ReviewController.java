package com.karina.app.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String create(HttpSession session,ReviewDTO reviewDTO,Model model)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		reviewDTO.setUsername(memberDTO.getUsername());		
		int result=reviewService.create(reviewDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	@PostMapping("delete")
	public String delete(ReviewDTO reviewDTO,Model model) throws Exception{
		int result = reviewService.delete(reviewDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	@PostMapping("update")
	public String update(ReviewDTO reviewDTO,Model model)throws Exception{
		int result= reviewService.update(reviewDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
}