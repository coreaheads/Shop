package shop.controller;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.cart.svc.CartService;
import shop.category.svc.CategoryService;
import shop.dto.Cart;
import shop.dto.Category;
import shop.dto.Item;
import shop.dto.ParamVO;

@Controller
public class CartController {

	@Autowired
	private CartService svc;
	@Autowired
	private CategoryService catesvc;
	

	@RequestMapping("/adminCartList.do") // 관리자용 카트 리스트
	public String cartList(Model model) {

		ArrayList<Cart> cartList = new ArrayList<Cart>();
		cartList = svc.cartList();

		model.addAttribute("cartList", cartList);

		return "cart/adminCartList";
	}

	@RequestMapping("/adminCartSearch.do")
	public String cartSearch(@RequestParam String search, @RequestParam String word, Model model) {

		ArrayList<Cart> cartList = new ArrayList<Cart>();
		cartList = svc.cartSearch(search, word);

		model.addAttribute("cartList", cartList);
		return "cart/adminCartList";
	}

	@RequestMapping("/adminCartDelete.do")
	public String cartDelete(@RequestParam int idx) {

		svc.cartDelete(idx);

		return "redirect:/adminCartList.do";
	}

	@RequestMapping("/memberCartList.do")
	public String cartList(@RequestParam String memberId, Model model) {
		
		if (memberId == "") {
			return "redirect:/guestCartList.do";
		}

		ArrayList<Cart> cartList = new ArrayList<Cart>();
		cartList = svc.memberCartList(memberId);
		int totalPrice = svc.cartTotalPrice(cartList); // 총 금액

		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);

		return "cart/memberCartList";
	}

	@RequestMapping("/memberCartInsert.do") // itemId, memberId, itemCount(장바구니에
											// 담을 상품 수량) 넘겨받을것
	public String memberCartAdd (@RequestParam int itemId, @RequestParam String memberId,
			@RequestParam String itemCount, HttpServletRequest request) {
		if (itemCount == "") {
			itemCount = "1";
		}
		
		int itemCountInt = Integer.parseInt(itemCount);
		System.out.println("선태11111111111111111111111111111111111");
		if (memberId == "") { // 비회원 물품 추가시 비회원 장바구니로 이동
			return "redirect:/guestCartAdd.do?idx="+itemId+"&itemCount="+itemCountInt;
		}
		
		System.out.println("서냍222222222222222222222222222222222");
		String ip = request.getRemoteAddr(); // 클라이언트 IP 받기
		System.out.println("1111111111111111111111111111");
		Item item = svc.getItemByIdx(itemId); // 아이템 정보 가져옴
		System.out.println("2222222222222222222222");
		if (item == null) {
			System.out.println("상품 정보가 없습니다.");
			return "redirect:/index.do";
		}

		if (item.getItemCount() == 0) {
			System.out.println("상품 수량이 0입니다.");
			return "redirect:/index.do";
		}
		System.out.println("333333333333333333333333333333333333333");
		Cart cartOrigine = svc.cartIsSearch(itemId, memberId); // 해당 멤버의 장바구니에
																// 해당 아이템이 있는지
																// 검사
		// idx, memberId, ip, itemId, itemCount, itemPrice, cartDate, url

		Cart cart = new Cart(0, memberId, ip, itemId, itemCountInt, item.getItemPrice(), null,
				item.getUrl(), item.getItemName(), 0);

		if (cartOrigine == null) { // 없으면 Insert
			if (itemCountInt > item.getItemCount()) {
				System.out.println("담으려는 수량이 상품재고를 초과합니다.");
				return "redirect:/memberCartList.do?memberId=" + memberId;
			}
			svc.memberCartInsert(cart);

		} else { // 이미 있다면 수량 update
			int count = cartOrigine.getItemCount() + itemCountInt;
			cart.setItemCount(count);
			if (cart.getItemCount() > item.getItemCount()) {
				System.out.println("담으려는 수량의 총 합이 상품재고를 초과합니다.");
				return "redirect:/memberCartList.do?memberId=" + memberId;
			}
			svc.memberCartCountUpdate(cart);
		}

		return "redirect:/memberCartList.do?memberId=" + memberId;
	}

	@RequestMapping("/memberCartItemCountUp.do") // 수량 위쪽 화살표 클릭
	public String memberCartItemCountUp(@RequestParam int itemId, @RequestParam String memberId) {

		svc.memberCartItemCountUp(itemId, memberId);

		return "redirect:/memberCartList.do?memberId=" + memberId;
	}

	@RequestMapping("/memberCartItemCountDown.do") // 수량 아래쪽 화살표 클릭
	public String memberCartItemCountDown(@RequestParam int itemId, @RequestParam String memberId) {

		svc.memberCartItemCountDown(itemId, memberId);
		
		return "redirect:/memberCartList.do?memberId=" + memberId;
	}

	@RequestMapping("/memberCartDelete.do")
	public String memberCartDelete(@RequestParam int idx, @RequestParam String memberId) {

		svc.cartDelete(idx);

		return "redirect:/memberCartList.do?memberId=" + memberId;
	}

	@RequestMapping("/guestCartAdd.do") // 비회원 카트 추가
	public String guestCartAdd(@RequestParam int idx, @RequestParam int itemCount, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
	
		svc.guestCartAdd(idx, itemCount, session, request, response);

		return "redirect:/guestCartList.do";
	}

	@RequestMapping("/guestCartList.do")
	public String guestCartList(Model model, HttpServletRequest request, HttpSession session,ParamVO paramVO,PrintWriter out) {
		ArrayList<Cart> cartList = svc.guestCartList(request, session);
		ArrayList<Category> categoryFirst = catesvc.categoryList();
		model.addAttribute("categoryFirst", categoryFirst);
		int totalPrice = svc.cartTotalPrice(cartList);
		paramVO.setUrl("guestCartList.jsp");
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("paramvo", paramVO);
	
		System.out.println(paramVO);
		return "cart/cart_body";
		//return "cart/guestCartList";
	}

	@RequestMapping("/guestCartDelete.do")
	public String guestCartDelete(@RequestParam String idx, HttpServletRequest request, HttpSession session) {

		svc.guestCartDelete(idx, request, session);
		
		return "redirect:/guestCartList.do";
	}
	
	@RequestMapping("/guestCartItemCountUp.do")
	public String guestCartItemCountUp(@RequestParam int itemId, HttpServletRequest request, HttpSession session){
	
		svc.guestCartItemCountUp(itemId,request,session);
		
		return "redirect:/guestCartList.do"; 
	}
	
	@RequestMapping("/guestCartItemCountDown.do")
	public String guestCartItemCountDown(@RequestParam String itemId, HttpServletRequest request, HttpSession session){
	
		svc.guestCartItemCountDown(itemId,request,session);
		
		return "redirect:/guestCartList.do"; 
	}
	
}
