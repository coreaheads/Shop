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

}
