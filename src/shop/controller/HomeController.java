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
		model.addAttribute("categoryFirst", list);
		return "index";
	}
	@RequestMapping("/userItemList.do")
	public String userItemList(Model model,@RequestParam String itemCategory){
		ArrayList<Category> list = svc.categoryList();
		ArrayList<Item> itemList = itemSvc.itemList();
		model.addAttribute("categoryFirst", list);
		model.addAttribute("itemList",itemList);
		model.addAttribute("itemCategory",itemCategory);
		return "item/userItemList";
	}

	
	
}
