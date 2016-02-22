package shop.item.dao;

import java.util.ArrayList;

import shop.dto.Item;
import shop.dto.ParamVO;

public interface	 ItemDAO {

	ArrayList<Item> itemList(ParamVO paramVO);

	Item itemDetail(int idx);

	void itemDelete(int idx);

	int insert(Item item);

	void update(Item item);

	ArrayList<Item> itemListSel(int itemCategory);

	ArrayList<Item> itemBestList(int f, int s);

	ArrayList<Item> itemNewList(int f, int s);

	int totalCnt();

}
