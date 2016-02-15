package shop.cart.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.cart.dao.CartDAO;
import shop.dto.Cart;
import shop.dto.Item;



@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO dao;
	
	@Override
	public ArrayList<Cart> cartList() {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.cartList();
		
		return list;
	}

	@Override
	public ArrayList<Cart> cartSearch(String search, String word) {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.cartSearch(search, word);
		
		return list;
	}

	@Override
	public void cartDelete(int idx) {
		// TODO Auto-generated method stub
		dao.cartDelete(idx);
	}

	@Override
	public ArrayList<Cart> memberCartList(String memberId) {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.memberCartList(memberId);

		return list;
	}

	@Override
	public Item getItemByIdx(String itemId) {
		// TODO Auto-generated method stub
		
		Item item = dao.getItemByIdx(itemId);
		
		return item;
	}

	@Override
	public Cart cartIsSearch(String itemId, String memberId) {
		// TODO Auto-generated method stub
		
		
		Cart cart = dao.cartIsSearch(itemId, memberId);
		
		
		
		return cart;
	}

	@Override
	public void memberCartInsert(Cart cart) {
		// TODO Auto-generated method stub
		
		dao.memberCartInsert(cart);
		
		
	}

	@Override
	public void memberCartCountUpdate(Cart cart) {
		// TODO Auto-generated method stub
		
		dao.memberCartCountUpdate(cart);
		
	}
	
	

}
