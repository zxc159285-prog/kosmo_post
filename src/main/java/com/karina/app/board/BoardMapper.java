package com.karina.app.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD - read / create / update / delete
	
	
	//read
	
	public List<BoardDTO> list() throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//

}
