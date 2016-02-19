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
public class CategoryController {

	@Autowired
	private CategoryService svc;

	@RequestMapping("/topCategoryInsert.do")
	public String topCategoryInsert(@RequestParam String categoryName, @RequestParam String division) {

		if (categoryName == null || categoryName == "") {
			return "redirect:/categoryList.do";
		} else {
			svc.topCategoryInsert(categoryName, division);
			return "redirect:/categoryList.do";
		}

	}

	@RequestMapping("/subCategoryInsertForm.do")
	public String subCategoryInsertForm(@RequestParam String idx, Model model) {

		model.addAttribute("idx", idx);

		return "category/subCategoryInsertForm";
	}

	@RequestMapping("/subCategoryInsert.do")
	public String subCategoryInsert(@RequestParam int rootIdx, @RequestParam String categoryName,
			@RequestParam String division) {

		svc.subCategoryInsert(rootIdx, categoryName, division);

		return "redirect:/categoryList.do";
	}

	@RequestMapping("/categoryDelete.do")
	public String categoryDelete(@RequestParam int idx) {

		svc.categoryDelete(idx);

		return "redirect:/categoryList.do";
	}

	@RequestMapping("/categoryUpdateForm.do")
	public String categoryUpdate(@RequestParam int idx, Model model) {

		Category category = svc.selectByIdx(idx);

		model.addAttribute("category", category);

		return "category/updateForm";
	}

	@RequestMapping("/categoryUpdate.do")
	public String categoryUpdate(Category category) {

		svc.categoryUpdate(category);

		return "redirect:/categoryList.do";
	}

	@RequestMapping("/categorySearch.do")
	public String categorySearch(@RequestParam String searchColumn, @RequestParam String searchWord, Model model) {
		ArrayList<Category> list = null;
		if (searchColumn.equals("categoryName")) { // 카테고리 이름으로 검색
			list = svc.categoryNameSearch(searchWord);
		} else if (searchColumn.equals("rootNum")) {
			int rootNum = Integer.parseInt(searchWord);
			list = svc.categoryRootNumSearch(rootNum);
		}

		model.addAttribute("categoryList", list);

		return "admin/category/categoryList";
	}

	@RequestMapping("/topCategoryUp.do")
	public String topCategoryUp(@RequestParam int rootNum) {

		svc.topCategoryUp(rootNum);

		return "redirect:/categoryList.do";
	}

	@RequestMapping("/topCategoryDown.do")
	public String topCategoryDown(@RequestParam int rootNum) {

		svc.topCategoryDown(rootNum);

		return "redirect:/categoryList.do";
	}
	
	@RequestMapping("/subCategoryUp.do")
	public String subCategoryUp(@RequestParam int idx) {

		svc.subCategoryUp(idx);
		
		return "redirect:/categoryList.do";
	}
}
