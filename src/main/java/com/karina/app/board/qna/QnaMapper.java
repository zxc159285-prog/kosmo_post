package com.karina.app.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.BoardMapper;
import com.karina.app.file.FileDTO;
@Mapper
public interface QnaMapper extends BoardMapper{

	public int fileDelete(FileDTO fileDTO) throws Exception;
	
	public int fileDeleteFor(BoardDTO boardDTO) throws Exception;
		
		

}
