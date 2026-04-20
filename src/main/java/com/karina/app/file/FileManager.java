package com.karina.app.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//프로퍼티스에있는걸 불러오기위해 멤버변수로 추가하고 벨류어노테이션을 준다
	@Value("${app.upload.base}")
	private String path;
	
	//파일삭제
	public boolean fileDelete(String name,FileDTO fileDTO)throws Exception{
		File file=new File(path,name);//경로를 담는다
		file=new File(file,fileDTO.getFileName()); //경로를담은 파일+파일이름을 꺼낸다
		
		return file.delete();
	}
	
	public String fileSave(String name,MultipartFile mf)throws Exception{
		//1. 어디에 저장할것인가
		File file=new File(path,name);
		//파일이존재하는가?
		if(!file.exists()) {
			file.mkdirs();
		}	
		//2. 파일명을 어떻게할것인가
		String fileName=UUID.randomUUID().toString();
		//3.확장자는 어떻게할것인가
		fileName=fileName+"_"+mf.getOriginalFilename();
		
		file=new File(file, fileName);
		//4.저장
		//a. MultipartFile의 transferTo메서드 사용
			mf.transferTo(file);
		//b. FileCopyUtils의 copyutil메서드를 사용
//			FileCopyUtils.copy(mf.getBytes(), file);
		return fileName;
	}
}
