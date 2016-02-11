package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.dto.Category;
import shop.svc.CategoryService;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryService svc;
	
	
	@RequestMapping("/categoryList.do")
	public String categoryList(Model model){
		
		ArrayList<Category> list = svc.categoryList();
		
		model.addAttribute("categoryList", list);
		
		return "category/categoryList";
	}
	
	
	@RequestMapping("/topCategoryInsert.do")
	public String topCategoryInsert(@RequestParam String categoryName, @RequestParam String division){
		
		if (categoryName == null || categoryName == "") {
			return "redirect:/categoryList.do";
		} else {
			svc.topCategoryInsert(categoryName, division);
			return "redirect:/categoryList.do";	
		}
			
	}
	
	@RequestMapping("/subCategoryInsertForm.do")
	public String subCategoryInsertForm(@RequestParam String idx, Model model){
		
		model.addAttribute("idx", idx);
		
		return "category/subCategoryInsertForm";
	}
	
	
	@RequestMapping("/subCategoryInsert.do")
	public String subCategoryInsert(@RequestParam int rootIdx, @RequestParam String categoryName, @RequestParam String division){
		
		svc.subCategoryInsert(rootIdx, categoryName, division);
		
		return "redirect:/categoryList.do";
	}
	
	@RequestMapping("/categoryDelete.do")
	public String categoryDelete(@RequestParam int idx){
		
		svc.categoryDelete(idx);
		
		return "redirect:/categoryList.do";
	}
	
	@RequestMapping("/categoryUpdateForm.do")
	public String categoryUpdate(@RequestParam int idx, Model model){
		
		Category category = svc.selectByIdx(idx);
		
		model.addAttribute("category", category);
		
		System.out.println(category.getIdx());
		
		return "category/updateForm";
	}
	
}
