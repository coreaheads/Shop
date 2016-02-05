package shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void close(SqlSession ss){
		ss.close();
	}
	
	@Override
	public ArrayList<Category> categoryList() {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		List<Category> categoryList = session.selectList("category.categoryList");
		
		close(session);
		
		return (ArrayList<Category>) categoryList;
	}

	
}
