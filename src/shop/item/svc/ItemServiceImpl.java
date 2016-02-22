package shop.item.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dto.Item;
import shop.dto.ParamVO;
import shop.item.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO dao;

	@Override
	public ArrayList<Item> itemList(ParamVO paramVO) {
		return dao.itemList(paramVO);
	}

	@Override
	public Item itemDetail(int idx) {

		return dao.itemDetail(idx);
	}

	@Override
	public void itemDelete(int idx) {
		// TODO Auto-generated method stub
		dao.itemDelete(idx);

	}

	@Override
	public void insert(Item item) {
		// TODO Auto-generated method stub
		dao.insert(item);
		
	}

	@Override
	public void itemUpdate(Item item) {
		// TODO Auto-generated method stub
		dao.update(item);
		
	}

	@Override
	public ArrayList<Item> itemListSel(int itemCategory) {
		return dao.itemListSel(itemCategory);
	}

	@Override
	public ArrayList<Item> itemBestList(int f , int s) {
		return dao.itemBestList(f,s);
	}

	@Override
	public ArrayList<Item> itemNewList(int f , int s) {
		return dao.itemNewList(f,s);
	}

	@Override
	public int totalCnt() {
		return dao.totalCnt();
	}
}
