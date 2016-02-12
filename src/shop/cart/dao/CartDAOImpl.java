package shop.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Cart;

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

}
