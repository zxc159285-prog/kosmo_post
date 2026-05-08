package com.karina.app.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RestTest {
	
	public void test()throws Exception{
		//WebClient webClient=WebClient.builder().baseUrl("http://192.168.0.253")
	}
	
	//webClient
	public void detail2()throws Exception{
		WebClient webClient = WebClient
								.builder()
								.baseUrl("https://jsonplaceholder.typicode.com/posts/1")
								.build()
								;
		Mono<ResponseEntity<PostDTO>> mono=webClient.get()
				.retrieve()
				.toEntity(PostDTO.class)
				;
		PostDTO postDTO=mono.block().getBody();
		log.info("{}",postDTO);
				
										
		
	}
	//resttemplate
	public void detail()throws Exception{
		RestTemplate restTemplate=new RestTemplate();
		
		PostDTO s=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", PostDTO.class);
		log.info("{}",s);
	}
	
	public void list()throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		List<PostDTO> ar=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",List.class);
		log.info("{}",ar);
	}
	
	
}
