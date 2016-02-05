package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import shop.dto.Board;
import shop.svc.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService svc;
	
	@RequestMapping("/boardList.do")
	public String boardList(Model model){
		ArrayList<Board> list = svc.list();
		System.out.println(list);
		model.addAttribute("boardList", list);
		return "board/boardlist";
	}
}
