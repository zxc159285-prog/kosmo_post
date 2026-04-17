package com.karina.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karina.app.board.BoardDTO;
import com.karina.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	
//	@Test
//	void testCreate() throws Exception{
//		
//		for(int i=0;i<23;i++) {
//		NoticeDTO noticeDTO= new NoticeDTO();
//		noticeDTO.setBoardTitle("title"+1);
//		noticeDTO.setBoardWriter("writer"+1);
//		noticeDTO.setBoardContents("contents"+1);
//		
//		noticeMapper.create(noticeDTO);
//		if(i%3==0) {
//			Thread.sleep(500);
//		}
//		}
//		System.out.println("Finish");
//	}
	@Test
	void testList() throws Exception{
		Pager pager = new Pager();
		pager.setSearch("9");
		pager.setPage(1L);
		pager.makeStartNum();
		List<BoardDTO> ar=noticeMapper.list(pager);
		log.info("{}",ar);
		assertEquals(5, ar.size());
	}

	

}
