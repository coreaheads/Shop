package shop.item.svc;

import java.util.ArrayList;

import shop.dto.Item;
import shop.dto.ParamVO;

public interface ItemService {

	ArrayList<Item> itemList(ParamVO paramVO);

	Item itemDetail(int idx);

	void itemDelete(int idx);

	void insert(Item item);

	void itemUpdate(Item item);

	ArrayList<Item> itemListSel(int itemCategory);

	ArrayList<Item> itemBestList(int f, int s);

	ArrayList<Item> itemNewList(int f , int s);

	int totalCnt();

	
	
}
