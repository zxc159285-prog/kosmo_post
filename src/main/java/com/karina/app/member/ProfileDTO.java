package com.karina.app.member;

import com.karina.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ProfileDTO extends FileDTO{

	private String username;
}
