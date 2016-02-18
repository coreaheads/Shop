package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.dto.Cart;
import shop.order.svc.OrderService;

@Controller
public class OrderListController {

	@Autowired
	private OrderService svc;
	
	@RequestMapping("/payForm.do")
	public String payForm(@RequestParam char isMember, @RequestParam ArrayList<Cart> cartList, @RequestParam int totalPrice, Model model){
		
		
		String returnPath = "order/guestPayForm"; 
		
		if (isMember == 'Y') {
			System.out.println("회원입니다.");
			returnPath = "order/memberPayForm";
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		
		return returnPath;
	}
	
	
	
}
