package shop.controller;

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

}
