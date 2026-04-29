package com.karina.app.board.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ReviewDTO {
	private Long reviewNum;
	private Long productNum;
	private Long reviewStar;
	private String reviewContents;
	private String username;
	private LocalDateTime reviewDate;

}
