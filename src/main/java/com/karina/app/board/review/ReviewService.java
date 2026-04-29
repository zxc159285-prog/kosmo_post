package com.karina.app.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReviewService {
	
	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewDTO> list(ReviewDTO reviewDTO)throws Exception{
		
		return reviewMapper.list(reviewDTO);
	}
	public int create()throws Exception{
		return reviewMapper.create();
	}
}
