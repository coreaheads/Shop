package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.dto.Category;
import shop.svc.CategoryService;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryService svc;
	
	
	@RequestMapping("/categoryList.do")
	public String categoryList(Model model){
		
		ArrayList<Category> list = svc.categoryList();
		
		model.addAttribute("list", list);
		
		return "categoryList";
	}
	
	
	
}
