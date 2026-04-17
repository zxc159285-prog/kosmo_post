package com.karina.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.notice.NoticeDTO;
import com.karina.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
//	@Test
//	void testCreate()throws Exception{
//		for(int i=0;i<23;i++) {
//			QnaDTO qnaDTO = new QnaDTO();
//			qnaDTO.setBoardTitle("qna title"+i);
//			qnaDTO.setBoardWriter("qna writer"+i);
//			qnaDTO.setBoardContents("qna contents"+i);
//			qnaMapper.create(qnaDTO);
//			if(i%3==0) {
//				Thread.sleep(500);
//				
//			}
//			
//		}
//		System.out.println("Finsh");
//	}
	
	@Test
	void testList() throws Exception {
		Pager pager = new Pager();
		pager.setSearch("8");
		pager.makeStartNum();
		List<BoardDTO> ar=qnaMapper.list(pager);
		log.info("{}",ar);
		assertEquals(5,ar.size());
	}


}
