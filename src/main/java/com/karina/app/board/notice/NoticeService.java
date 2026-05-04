package com.karina.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.BoardService;
import com.karina.app.file.FileDTO;
import com.karina.app.file.FileManager;
import com.karina.app.pager.Pager;

@Service
@Transactional(rollbackFor = Exception.class)//중간에 문제발생시(예외발생) 진행한일을 전부 취소
//보통 서비스에 붙힌다
public class NoticeService implements BoardService{ //서비스를 구현할땐 implements 소스에서 오버라이드
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.notice}")
	private String name;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		//테스트에서 했던일을 여기서하면됨 받아오는건 제외
		pager.makeStartNum();
		pager.makePageNum(noticeMapper.getCount(pager));
		return noticeMapper.list(pager);
	}

	
	@Override
	public int create(BoardDTO boardDTO,MultipartFile[]attach) throws Exception {
		//1. 게시판 테이블에 글을 추가 글이있어야 글번호를참조해서 파일을첨부할수있음
		int result=noticeMapper.create(boardDTO);
		
		if(attach==null) {
			return result;
		}
		//2. 파일을 하드디스크에 저장
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {//파일을 안보냈으면 반복문돌지말아라
				continue;
			}
			String fileName=fileManager.fileSave(name, f);
			//3. 파일의 정보들을 DB에 저장
			NoticeFileDTO noticeFileDTO=new NoticeFileDTO();
			noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeFileDTO.setOriName(f.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			
			result=noticeMapper.createFile(noticeFileDTO);
			
		}
		
		return result;
		
	}

	@Override
	public int update(BoardDTO boardDTO,MultipartFile[]attach) throws Exception {
		int result=noticeMapper.update(boardDTO);
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		//파일명 조회
		boardDTO=noticeMapper.detail(boardDTO);
		// 하드디스크에서 파일삭제
		for(FileDTO fileDTO:boardDTO.getList()) {
			fileManager.fileDelete(name, fileDTO);
		}
		//DB에서 삭제
		int result=noticeMapper.delete(boardDTO);
		return result;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		
		return noticeMapper.detail(boardDTO);
	}
	
	@Override
		public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
			// TODO Auto-generated method stub
			return noticeMapper.fileDetail(fileDTO);
		}
	

}
