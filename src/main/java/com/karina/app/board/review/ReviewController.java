package com.karina.app.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("reviewlist")
	public String list(ReviewDTO reviewDTO,Model model) throws Exception{
		
		List<ReviewDTO> ar= reviewService.list(reviewDTO);
		model.addAttribute("list", ar);
		return "review/reviewlist";
	}
	@GetMapping("list")
	public void list() throws Exception{}
}
