package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.cart.svc.CartService;
import shop.dto.Cart;

@Controller
public class CartController {

	@Autowired
	private CartService svc;

	@RequestMapping("/cartList.do") // 관리자용 카트 리스트
	public String cartList() {

		ArrayList<Cart> list = new ArrayList<Cart>();
		list =  svc.cartList();
		
		return "redirect:/cartList.do";
	}

}
