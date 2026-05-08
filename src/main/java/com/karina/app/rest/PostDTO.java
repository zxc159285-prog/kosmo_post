package com.karina.app.rest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDTO {

	private Long userId;
	private Long id;
	private String title;
	private String body;
}
