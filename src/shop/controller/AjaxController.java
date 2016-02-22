package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.board.svc.BoardService;
import shop.boardconfig.svc.BoardConfigService;
import shop.category.svc.CategoryService;
import shop.dto.Member;
import shop.item.svc.ItemService;

@Controller
public class AjaxController {
	@Autowired
	private CategoryService catesvc;
	@Autowired
	private ItemService itemsvc;
	@Autowired
	private BoardService bbssvc;
	@Autowired
	private BoardConfigService bbsconfigsvc;

	public AjaxController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/Memberchk.do")
	public String registForm(Model model) {
		model.addAttribute("member", new Member());
		return null;
	}
	
	

}
