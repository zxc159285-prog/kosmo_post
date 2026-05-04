package com.karina.app.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //설정파일입니다 라고 알려줌
public class FileMappingConfig implements WebMvcConfigurer{
	
	//파일즈로 시작하는애들은 업로드로 가서 찾아라 (파일이 저장되어있는곳)
	
	@Value("${app.upload.url}")
	private String url;
	
	@Value("${app.upload.path}")
	private String path;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		registry.addResourceHandler(url)
				.addResourceLocations(path);
	}
}
