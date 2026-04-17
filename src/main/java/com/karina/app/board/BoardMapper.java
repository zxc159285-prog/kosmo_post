package com.karina.app.board;

import java.util.List;

import com.karina.app.file.FileDTO;
import com.karina.app.pager.Pager;

public interface BoardMapper {
	
	//CRUD - read / create / update / delete
	
	public Long getCount(Pager pager)throws Exception;//블록
	//read
	//페이지계산을 해놓은 Pager클래스를 가져와야해서 매개변수로 넣어준다
	public List<BoardDTO> list(Pager pager) throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//create
	public int create(BoardDTO boardDTO)throws Exception;
	
	public int createFile(FileDTO fileDTO)throws Exception;
	
	//update
	public int update(BoardDTO boardDTO)throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO)throws Exception;

}
