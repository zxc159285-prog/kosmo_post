package com.karina.app.board.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.karina.app.account.AccountController;
import com.karina.app.member.MemberDTO;
import com.karina.app.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("cart")
public class CartController {

    private final AccountController accountController;

	@Autowired
	private CartService cartService;

    CartController(AccountController accountController) {
        this.accountController = accountController;
    }
	
	@PostMapping("create")
	public String create(HttpSession session,CartDTO cartDTO, Model model) throws Exception{
		MemberDTO memberDTO=(MemberDTO) session.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());
		
		int result = cartService.create(cartDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	@GetMapping("list")
	public void list()throws Exception{}
	
	@GetMapping("cartlist")
	public void list(Model model,HttpSession session)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		List<ProductDTO>ar = cartService.list(memberDTO);
		model.addAttribute("list", ar);
		
	}
//	@PostMapping("delete")
//	public String delete(CartDTO cartDTO,HttpSession session,Model model) throws Exception{
//		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
//		cartDTO.setUsername(memberDTO.getUsername());
//		int result=cartService.delete(cartDTO);
//		model.addAttribute("result", result);
//		return "commons/ajaxResult";
//	}
	@PostMapping("delete")
	public String delete(@RequestParam("productNum") Long[]productNum,HttpSession session,Model model) throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		List<CartDTO> ar=new ArrayList<>();
		for(Long l : productNum) {
			CartDTO cartDTO=new CartDTO();
			cartDTO.setProductNum(l);
			cartDTO.setUsername(memberDTO.getUsername());
			ar.add(cartDTO);
		}

		int result=cartService.delete(ar);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
}
