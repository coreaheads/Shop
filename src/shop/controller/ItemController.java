package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dto.Item;
import shop.item.svc.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService svc;

	
	@RequestMapping("/itemUpdateForm.do")
	public String itemUpdateForm(){
		return "itemUpdateForm";
	}
	
	@RequestMapping("/itemDelete.do")
	public String itemDelete(@RequestParam String idx){
		svc.itemDelete(idx);
		return "itemList";
	}
	
	
	@RequestMapping("/itemList.do")
	public String ItemList(Model model) {
		ArrayList<Item> list = svc.itemList();
		model.addAttribute("itemList", list);
		return "item/itemList";
	}
	
	@RequestMapping("/itemDetail.do")
	public ModelAndView ItemDetail(@RequestParam String idx,ModelAndView mav) {
		Item item = svc.itemDetail(idx);
		mav.addObject("item",item);
		mav.setViewName("item/itemDetail");
		return mav;
	}
	
}
