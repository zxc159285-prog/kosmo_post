package com.karina.app.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.karina.app.board.BoardDTO;
import com.karina.app.board.BoardService;
import com.karina.app.board.notice.NoticeMapper;
import com.karina.app.file.FileDTO;
import com.karina.app.file.FileManager;
import com.karina.app.pager.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.qna}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeStartNum();
		pager.makePageNum(qnaMapper.getCount(pager));

		return qnaMapper.list(pager);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		// 1. 게시판 테이블에 글을 추가 글이있어야 글번호를참조해서 파일을첨부할수있음
		int result = qnaMapper.create(boardDTO);

		if (attach == null) {
			return result;
		}
		// 2. 파일을 하드디스크에 저장
		for (MultipartFile f : attach) {
			if (f.isEmpty()) {
				continue;
			}
			// 3. 파일의 정보들을 DB에 저장
			String fileName = fileManager.fileSave(name, f);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());

			result = qnaMapper.createFile(qnaFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		int result = qnaMapper.update(boardDTO);
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// 파일명 조회
		boardDTO = qnaMapper.detail(boardDTO);
		// 하드디스크에서 파일삭제
		for (FileDTO fileDTO : boardDTO.getList()) {
//			fileManager.fileDelete(name, fileDTO);
			qnaMapper.fileDelete(fileDTO);
		}

		qnaMapper.fileDeleteFor(boardDTO.getList());
		// DB에서 삭제
		int result = qnaMapper.delete(boardDTO);
		return result;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.detail(boardDTO);
	}

}
