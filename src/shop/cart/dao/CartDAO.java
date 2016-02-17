package shop.cart.dao;

import java.util.ArrayList;

import shop.dto.Cart;
import shop.dto.Item;

public interface CartDAO {

	ArrayList<Cart> cartList();

	ArrayList<Cart> cartSearch(String search, String word);

	void cartDelete(int idx);

	ArrayList<Cart> memberCartList(String memberId);

	Item getItemByIdx(int itemId);

	Cart cartIsSearch(int itemId, String memberId);

	void memberCartInsert(Cart cart);

	void memberCartCountUpdate(Cart cart);

}
