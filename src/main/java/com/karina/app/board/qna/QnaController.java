package com.karina.app.board.qna;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.notice.NoticeDTO;
import com.karina.app.board.notice.NoticeService;
import com.karina.app.file.FileDTO;
import com.karina.app.pager.Pager;

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

@Controller
@RequestMapping("/qna/*")
public class QnaController {

    private final NoticeService noticeService;
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${app.board.qna}")
	private String name;
	
	@ModelAttribute("name")
	public String getName() {
		return this.name;
	}

    QnaController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    @GetMapping("down")
    public String fileDown(QnaFileDTO qnaFileDTO,Model model)throws Exception{
    	FileDTO fileDTO=qnaService.fileDetail(qnaFileDTO);
    	
    	model.addAttribute("fileDTO", fileDTO);
    	
    	return "fileDownView";
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
	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO,Model model)throws Exception{
		BoardDTO boardDTO=qnaService.detail(qnaDTO);
		model.addAttribute("detail", boardDTO);
		return "board/detail";
	}
	@GetMapping("update")
	public String update(QnaDTO qnaDTO,Model model) throws Exception{
		BoardDTO boardDTO= qnaService.detail(qnaDTO);
		model.addAttribute("update", boardDTO);
		return "board/update";
	}
	@PostMapping("update")
	public String update(QnaDTO qnaDTO,@RequestParam("attach") MultipartFile[]attach)throws Exception{
		int result=qnaService.update(qnaDTO, attach);
		return "redirect:./list";
	}
	@PostMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception{
		int result= qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
}
