package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardConfigController {
	@RequestMapping("/BoardConfigInsert.do")
	public String boardConfigInsert(){
		return "BoardConfigList.do";
	}
	@RequestMapping("/BoardConfigInsertForm.do")
	public String boardConfigInsertForm(){
		return "admin/board/BoardConfigInsertForm";
	}
	
}
