package shop.cart.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dto.Cart;
import shop.dto.Item;

public interface CartService {

	ArrayList<Cart> cartList();

	ArrayList<Cart> cartSearch(String search, String word);

	void cartDelete(int idx);

	ArrayList<Cart> memberCartList(String memberId);

	Item getItemByIdx(String itemId);

	Cart cartIsSearch(String itemId, String memberId);

	void memberCartInsert(Cart cart);

	void memberCartCountUpdate(Cart cart);

	void guestCartAdd(String idx, int itemCount, HttpSession session, HttpServletRequest request, HttpServletResponse response );

	ArrayList<Cart> guestCartList(HttpServletRequest request, HttpSession session);

	void guestCartDelete(String idx, HttpServletRequest request, HttpSession session);

	void guestCartItemCountUp(String itemId, HttpServletRequest request, HttpSession session);

	void guestCartItemCountDown(String itemId, HttpServletRequest request, HttpSession session);



	

}
