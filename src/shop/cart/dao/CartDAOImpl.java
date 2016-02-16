package shop.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Cart;
import shop.dto.Item;

@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void close(SqlSession ss){
		ss.close();
	}
	
	@Override
	public ArrayList<Cart> cartList() {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		List<Cart> list = session.selectList("cart.cartList");
		
		session.close();
		
		return (ArrayList<Cart>) list;
	}

	@Override
	public ArrayList<Cart> cartSearch(String search, String word) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		List<Cart> list = null;
		
		if (search.equals("memberId")) {
			list = session.selectList("cart.cartMemberIdSearch", word);
		} else if (search.equals("itemId")) {
			list = session.selectList("cart.cartItemIdSearch", word);
		}
		
		session.close();
		
		return (ArrayList<Cart>) list;
	}

	@Override
	public void cartDelete(int idx) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		session.delete("cart.cartDelete",idx);
		
		session.close();
	}

	@Override
	public ArrayList<Cart> memberCartList(String memberId) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		List<Cart> list = session.selectList("cart.cartMemberIdSearch", memberId);
		
		session.close();
		
		return (ArrayList<Cart>) list;
	}

	@Override
	public Item getItemByIdx(String idx) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		Item item = session.selectOne("item.detail",idx);
		
		session.close();
		
		return item;
	}

	@Override
	public Cart cartIsSearch(String itemId, String memberId) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		Cart cart = new Cart(0, memberId, null, Integer.parseInt(itemId), 0, 0, null, null, null);
				
		Cart afterCart = session.selectOne("cart.cartIsSearch", cart); 
				
		session.close();
		
		return afterCart;
	}

	@Override
	public void memberCartInsert(Cart cart) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		session.insert("cart.memberCartInsert", cart);
		
		session.close();
	}

	@Override
	public void memberCartCountUpdate(Cart cart) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		session.update("cart.memberCartCountUpdate", cart);
		
		session.close();
		
	}
	
	
	
	

}
