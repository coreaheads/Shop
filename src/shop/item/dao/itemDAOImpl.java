package shop.item.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Item;

@Repository
public class itemDAOImpl implements ItemDAO {

	@Autowired
	SqlSessionFactory factory;

	// public int insert(Item item) {
	// // ?犿毃??瓴?偓??svc?愳劀
	// int num = -1; // ?标车 ??毳??滉赴, ?标车??1,?ろ尐??10
	// SqlSession session = factory.openSession();
	// session.insert("item.insert", item);
	//
	// if (detail(item.getIdx()) == null) {
	// num = 10;
	// } else {
	// num = 1;
	// }
	// session.close();
	// return num;
	//
	// }

	public Item itemDetail(String idx) {
		SqlSession session = factory.openSession();
		Item item = session.selectOne("item.detail", Integer.parseInt(idx));
		session.close();
		return item;
	}

	public ArrayList<Item> itemList() {
		SqlSession session = factory.openSession();
		List<Item> list = session.selectList("item.list");
		session.close();
		return (ArrayList<Item>) list;

	}

	@Override
	public void itemDelete(String idx) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		session.update("item.delete",idx);
		session.close();
	}

}
