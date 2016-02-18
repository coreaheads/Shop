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

	Item getItemByIdx(int itemId);

	Cart cartIsSearch(int itemId, String memberId);

	void memberCartInsert(Cart cart);

	void memberCartCountUpdate(Cart cart);

	void guestCartAdd(int idx, int itemCount, HttpSession session, HttpServletRequest request, HttpServletResponse response );

	ArrayList<Cart> guestCartList(HttpServletRequest request, HttpSession session);

	void guestCartDelete(String idx, HttpServletRequest request, HttpSession session);

	void guestCartItemCountUp(int itemId, HttpServletRequest request, HttpSession session);

	void guestCartItemCountDown(String itemId, HttpServletRequest request, HttpSession session);

	int cartTotalCount(ArrayList<Cart> cartList);

	void memberCartItemCountUp(int itemId, String memberId);

	void memberCartItemCountDown(int itemId, String memberId);



	

}
