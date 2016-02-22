package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.boardconfig.svc.BoardConfigService;
import shop.cart.svc.CartService;
import shop.dto.BoardConfig;

@Controller
public class BoardConfigController {
	@Autowired
	private BoardConfigService svc;
	@RequestMapping("/BoardConfigInsert.do")
	public String BoardConfigInsert(BoardConfig boardConfig){
		svc.insert(boardConfig);
		return "redirect:/BoardConfig.do?mode=list&page=1";
	}
	@RequestMapping("/BoardConfigInsertForm.do")
	public String boardConfigInsertForm(){
		return "admin/board/BoardConfigInsertForm";
	}
	
}
