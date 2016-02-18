package shop.item.svc;

import java.util.ArrayList;

import shop.dto.Item;

public interface ItemService {

	ArrayList<Item> itemList();

	Item itemDetail(String idx);

	void itemDelete(String idx);

	void insert(Item item);

	void itemUpdate(Item item);

	ArrayList<Item> itemListSel(int itemCategory);

	ArrayList<Item> itemBestList(int f, int s);

	ArrayList<Item> itemNewList(int f , int s);

	
	
}
