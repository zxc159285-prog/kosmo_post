package com.karina.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.karina.app.pager.Pager;

public interface BoardService {
	//read
	public List<BoardDTO> list(Pager pager) throws Exception;

	//create
	public int create(BoardDTO boardDTO,MultipartFile[]attach)throws Exception;
	
	//update
	public int update(BoardDTO boardDTO,MultipartFile[]attach)throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO)throws Exception;
	
	//read
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
}
