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

	@Override
	public int insert(Item item) {
		int num = -1;
		SqlSession session = factory.openSession();
		session.insert("item.insert", item);

		if (itemDetail(item.getIdx() + "") == null) {
			num = 10;
		} else {
			num = 1;
		}
		session.close();
		return num;

	}

	@Override
	public Item itemDetail(String idx) {
		SqlSession session = factory.openSession();
		Item item = session.selectOne("item.detail", Integer.parseInt(idx));
		session.close();
		return item;
	}
	

	@Override
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
		session.update("item.delete", idx);
		session.close();
	}

	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		session.update("item.update",item);
		session.close();
	}

	@Override
	public ArrayList<Item> itemListSel(int itemCategory) {
		SqlSession session = factory.openSession();
		List<Item> list = session.selectList("item.listsel",itemCategory);
		session.close();
		return (ArrayList<Item>) list;
	}

}
