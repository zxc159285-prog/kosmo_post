package com.karina.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.karina.app.board.BoardDTO;
import com.karina.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/notice/*")//어떤 url이 왔을떄 얘를 실행할것인가 /밑에 notice밑에 모든것
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${app.board.notice}")
	private String name;
	
	@ModelAttribute("name")
	public String getName() {
		return this.name;
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ멤버변수
	@GetMapping("list") //notice밑에 list라는 url이 왔을때
	public String list(Pager pager,Model model) throws Exception{
		List<BoardDTO> ar =noticeService.list(pager); //서비스에서 리턴해주는 값이 List<BoardDTO>니까
		
		model.addAttribute("list", ar);
		//페이저도 담아줘야하는데 매개변수 Pager 앞에 @Modelattribute("pager")이 생략되어있다
		
		return "board/list";
	}
	@GetMapping("create")
	public String create()throws Exception{
		
		return "board/create";
	}
	@PostMapping("create")
	public String create(NoticeDTO noticeDTO,@RequestParam("attach") MultipartFile[]attach,Model model)throws Exception{
		
		int result=noticeService.create(noticeDTO, attach);
		if(result>0) {
			model.addAttribute("result","글 등록 성공");
			model.addAttribute("url","./list");
		}
		
		
		
		return "commons/result";
	}
	@GetMapping("detail")
	public String detail(NoticeDTO noticeDTO,Model model)throws Exception{
		BoardDTO boardDTO=noticeService.detail(noticeDTO);
		if(boardDTO==null) {
			model.addAttribute("result","없는 글입니다");
			model.addAttribute("url", "./list");
			return "commons/result";
		}else {
		model.addAttribute("detail", boardDTO);
		return "board/detail";}
		
		
	}
	
	@GetMapping("update")
	public String update(NoticeDTO noticeDTO,Model model)throws Exception{
		BoardDTO boardDTO=noticeService.detail(noticeDTO);
		model.addAttribute("update",boardDTO);
		return "board/update";
	}
	@PostMapping("update")
	public String update(NoticeDTO noticeDTO,@RequestParam("attach") MultipartFile[]attach)throws Exception{
		int result=noticeService.update(noticeDTO,attach);
		return "redirect:./list";
		
	}
	@PostMapping("delete")
	public String delete(NoticeDTO noticeDTO) throws Exception{
		int result= noticeService.delete(noticeDTO);
		return "redirect:./list";
	}


}
