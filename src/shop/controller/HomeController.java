package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.category.svc.CategoryService;
import shop.dto.Category;
import shop.dto.Item;
import shop.item.svc.ItemService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService svc;
	@Autowired
	private ItemService itemSvc;

	
	@RequestMapping("/index.do")
	public String index(Model model){
		ArrayList<Category> list = svc.categoryList();
		ArrayList<Item> bestlist = itemSvc.itemBestList(1,3);
		ArrayList<Item> bestlist2 = itemSvc.itemBestList(4,6);
		ArrayList<Item> newlist = itemSvc.itemNewList(1,3);
		ArrayList<Item> newlist2 = itemSvc.itemNewList(4,6);
		model.addAttribute("categoryFirst", list);
		model.addAttribute("itemBestList", bestlist);
		model.addAttribute("itemBestList2", bestlist2);
		model.addAttribute("itemNewList", newlist);
		model.addAttribute("itemNewList2", newlist2);
		
		return "index";
	}
	@RequestMapping("/userItemList.do")
	public String userItemList(Model model,@RequestParam(required=false, defaultValue="1") int itemCategory){
		ArrayList<Category> list = svc.categoryList();
		ArrayList<Item> itemList = itemSvc.itemListSel(itemCategory);
		
		System.out.println(itemList);
		model.addAttribute("categoryFirst", list);
		model.addAttribute("itemList",itemList);
		model.addAttribute("itemCategory",itemCategory);
		return "item/userItemList";
	}
	@RequestMapping("/shop.do")
	public String shopssss(Model model){
		ArrayList<Category> list = svc.categoryList();
		model.addAttribute("categoryFirst", list);		
		return "shop";
	}

	
	
}
