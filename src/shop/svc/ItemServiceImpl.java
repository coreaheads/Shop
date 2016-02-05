package shop.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ItemDAO;
import shop.dto.Item;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	ItemDAO dao;

	@Override
	public ArrayList<Item> itemList() {
		return dao.itemList();
	}
}
