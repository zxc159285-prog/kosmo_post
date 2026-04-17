package com.karina.app.board.qna;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.notice.NoticeService;
import com.karina.app.pager.Pager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

    private final NoticeService noticeService;
	
	@Autowired
	private QnaService qnaService;

    QnaController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
	@GetMapping("list")
	public String list(Pager pager,Model model) throws Exception{
		List<BoardDTO> ar=qnaService.list(pager);
		
		model.addAttribute("list", ar);
		
		return "board/list";
		
	}

	@GetMapping("create")
	public String create() throws Exception {
		return "board/create";
	}
	@PostMapping("create")
	public String create(QnaDTO qnaDTO,@RequestParam("attach") MultipartFile[]attach) throws Exception{
		int result=qnaService.create(qnaDTO, attach);
		return "redirect:./list";
		
	}
}
