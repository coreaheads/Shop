package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.dto.Item;
import shop.svc.ItemService;

@Controller
public class ItemController {

@Autowired
ItemService svc;
	

@RequestMapping("/itemList.do")
public String ItemList(Model model){
	ArrayList<Item> list = svc.itemList();
	model.addAttribute("itemList",list);
	return "list";
}
}
