package shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Item;
@Repository
public class itemDAOImpl implements ItemDAO {

	@Autowired
	SqlSessionFactory factory;
	
	public int insert(Item item) {
		//유효성 검사는 svc에서
		int num=-1; //성공 여부를 표기, 성공은 1,실패는 10
		SqlSession session = factory.openSession();
		session.insert("item.insert",item);
		
		if (selectIdx(item.getIdx())==null) {
			num=10;
		}else {
			num=1;
		}
		session.close();
		return num;
		
	}

	public Item selectIdx(int idx) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
