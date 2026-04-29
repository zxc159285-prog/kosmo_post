package com.karina.app.board.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karina.app.member.MemberDTO;
import com.karina.app.product.ProductDTO;

@Service
public class CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	public int create(CartDTO cartDTO) throws Exception {
		
		return cartMapper.create(cartDTO);
	}

	public List<ProductDTO> list(MemberDTO memberDTO)throws Exception{
		return cartMapper.list(memberDTO);
	}
	
//	public int delete(CartDTO cartDTO)throws Exception{
//		return cartMapper.delete(cartDTO);
//	}
//	
	
	public int delete(List<CartDTO> ar)throws Exception{
		return cartMapper.delete(ar);
	}
	
	
	
	
}
