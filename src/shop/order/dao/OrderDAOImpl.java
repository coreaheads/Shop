package shop.order.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSessoion(){
		return factory.openSession();
	}
	
	private void close(SqlSession ss){
		ss.close();
	}
	
}
