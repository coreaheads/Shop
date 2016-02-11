package shop.item.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dto.Item;
import shop.item.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO dao;

	@Override
	public ArrayList<Item> itemList() {
		return dao.itemList();
	}

	@Override
	public Item itemDetail(String idx) {

		return dao.itemDetail(idx);
	}

	@Override
	public void itemDelete(String idx) {
		// TODO Auto-generated method stub
		dao.itemDelete(idx);

	}

	@Override
	public void insert(Item item) {
		// TODO Auto-generated method stub
		dao.insert(item);
		
	}
}
