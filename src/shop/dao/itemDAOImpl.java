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
		//��ȿ�� �˻�� svc����
		int num=-1; //���� ���θ� ǥ��. ������ 1,���д� 10
		SqlSession session = factory.openSession();
		session.insert("",item);
		
		session.close();
		return 0;
		
	}
}
