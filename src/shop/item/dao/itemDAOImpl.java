package shop.item.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Item;
import shop.dto.ParamVO;

@Repository
public class itemDAOImpl implements ItemDAO {

	@Autowired
	SqlSessionFactory factory;

	@Override
	public int insert(Item item) {
		int num = -1;
		SqlSession session = factory.openSession();
		session.insert("item.insert", item);
		session.close();
		return num;

	}

	@Override
	public Item itemDetail(int idx) {
		SqlSession session = factory.openSession();
		Item item = session.selectOne("item.detail", idx);
		session.close();
		return item;
	}
	

	@Override
	public ArrayList<Item> itemList(ParamVO paramVO) {
		SqlSession session = factory.openSession();
		List<Item> list = session.selectList("item.list",paramVO);
		session.close();
		return (ArrayList<Item>) list;

	}

	@Override
	public void itemDelete(int idx) {
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

	@Override
	public ArrayList<Item> itemBestList(int f, int s) {
		SqlSession session = factory.openSession();
		HashMap< String, Integer> map= new HashMap<>();
		map.put("f", f);
		map.put("s", s);
		List<Item> list = session.selectList("item.bestlist", map);
		session.close();
		return (ArrayList<Item>) list;
	}

	@Override
	public ArrayList<Item> itemNewList(int f, int s) {
		SqlSession session = factory.openSession();
		HashMap< String, Integer> map= new HashMap<>();
		map.put("f", f);
		map.put("s", s);
		List<Item> list = session.selectList("item.newlist",map);
		session.close();
		return (ArrayList<Item>) list;
	}

	@Override
	public int totalCnt() {
		SqlSession session = factory.openSession();
		int totalCnt = session.selectOne("item.total");
		session.close();
		return totalCnt;
	}

}
