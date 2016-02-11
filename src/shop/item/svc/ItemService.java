package shop.item.svc;

import java.util.ArrayList;

import shop.dto.Item;

public interface ItemService {

	ArrayList<Item> itemList();

	Item itemDetail(String idx);

	void itemDelete(String idx);

	void insert(Item item);

	
	
}
