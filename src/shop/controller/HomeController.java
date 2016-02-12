package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.category.svc.CategoryService;
import shop.dto.Category;

@Controller
public class HomeController {

	@Autowired
	private CategoryService svc;

	
	@RequestMapping("/index.do")
	public String index(Model model){
		ArrayList<Category> list = svc.categoryList();
		model.addAttribute("categoryFirst", list);

		return "index";
	}
	

	
	
}
