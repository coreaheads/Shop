package shop.cart.svc;

import java.util.ArrayList;

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



	

}
