package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.board.svc.BoardService;
import shop.category.svc.CategoryService;
import shop.dto.Board;
import shop.dto.Category;
import shop.dto.Item;
import shop.dto.ParamVO;
import shop.item.svc.ItemService;

@Controller
public class AdminHomeController {
	
	@Autowired
	private CategoryService catesvc;
	@Autowired
	private ItemService itemsvc;
	@Autowired
	private BoardService bbssvc;

	private static final String FOLDER = "admin";
	
	@RequestMapping("/admin.do")
	public String admin(){
		System.out.println("1");
		return FOLDER +"/index";
	}
	
	@RequestMapping("/categoryList.do")
	public String categoryList(Model model) {

		ArrayList<Category> list = catesvc.categoryList();

		model.addAttribute("categoryList", list);

		return "admin/category/categoryList";
	}
	
	@RequestMapping("/itemList.do")
	public String itemList(Model model) {

		ArrayList<Item> list = itemsvc.itemList();

		model.addAttribute("itemList", list);

		return "admin/item/itemList";
	}
	
	
	@RequestMapping("/boardList.do")
	public String baordList(Model model,ParamVO paramVO) {

		ArrayList<Board> list = bbssvc.list(paramVO);

		model.addAttribute("baordList", list);

		return "admin/board/boardList";
	}
	
	
	
	@RequestMapping("/itemInsertAjax.do")

	public @ResponseBody ArrayList<?> jsonSample(@RequestParam int idx) {
	
		ArrayList<Category> list = catesvc.categoryList();
		
		ArrayList<Category> secondList = new ArrayList<Category>();
		for (Category x : list) {
			if (x.getStep() == 1) {
				if (x.getRootNum()==idx) {
					secondList.add(x);
				}
			}
		}
		return secondList;

	}
	@RequestMapping("/category.do")
	public String category(Model model) {

		ArrayList<Category> list = catesvc.categoryList();
		ArrayList<Category> firstList = new ArrayList<Category>();
		ArrayList<Category> secondList = new ArrayList<Category>();
		for (Category x : list) {
			if (x.getStep() == 0) {
				firstList.add(x);
			}
			if (x.getStep() == 1) {
				secondList.add(x);
			}
			
		}
		model.addAttribute("categoryList", firstList);
		model.addAttribute("categoryList", firstList);
		return "../NewFile";

	}
	
	
	
}
