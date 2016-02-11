package shop.item.dao;

import java.util.ArrayList;

import shop.dto.Item;

public interface	 ItemDAO {

	ArrayList<Item> itemList();

	Item itemDetail(String idx);

	void itemDelete(String idx);

	int insert(Item item);

}
