package com.karina.app.board.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.karina.app.member.MemberDTO;
import com.karina.app.product.ProductDTO;

@Mapper
public interface CartMapper {

	public int create(CartDTO cartDTO)throws Exception;
	public List<ProductDTO> list(MemberDTO memberDTO)throws Exception;
//	public int delete(CartDTO cartDTO)throws Exception;
	public int delete(List<CartDTO>ar)throws Exception;
}
