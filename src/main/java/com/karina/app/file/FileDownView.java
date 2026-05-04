package com.karina.app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
import com.karina.app.board.notice.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownView extends AbstractView {
	// 익스텐즈 앱스트랙뷰를 하면 jsp같은 뷰객체가됨 Bean Name View Resolver 라고 부름
    private final NoticeService noticeService;
    
    @Value("${app.upload.base}")
    private String base;

    FileDownView(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//만약 키를 모른다고 가정하면
//		Iterator<String> it =model.keySet().iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		FileDTO fileDTO = (FileDTO)model.get("fileDTO");
		String name=(String)model.get("name");
		
		File file= new File(base,name);//upload/name
		
		file = new File(file, fileDTO.getFileName()); //upload/notice/xxx.xxx
		//한글 파일명 인코딩처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기를 알려주기
		response.setContentLengthLong(file.length());
		
		//다운로드시 파일명을 올릴때의 이름으로 한글인코딩
		String oriName=fileDTO.getOriName();
		oriName=URLEncoder.encode(oriName,"UTF-8");
		
		//파일의 종류 header에 담겨있음
		response.setHeader("Content-Disposition","attachement;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding","binary");
		
		//파일 읽어오는 준비
		FileInputStream fi = new FileInputStream(file);//file에 저장된 경로와 이름으로 파일을 이진수로읽어옴
		//Client로 내보내는 준비
		OutputStream os = response.getOutputStream();
		
		//최종 전송
		FileCopyUtils.copy(fi, os);
		
		//자원 해제
		os.close();
		fi.close();
	}
}
