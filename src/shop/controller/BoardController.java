package shop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import shop.board.svc.BoardService;
import shop.dto.Board;

@Controller
public class BoardController {
	@Autowired
	BoardService svc;
	
	@RequestMapping("/BoardList.do")
	public String boardList(Model model){
		ArrayList<Board> list = svc.list();
		model.addAttribute("BoardList", list);
		return "board/boardlist";
	}
	@RequestMapping("/BoardView.do")
	public String view(Model model){
		ArrayList<Board> list = svc.list();
		model.addAttribute("view", list);
		return "board/view";
	}
	@RequestMapping("/BoardWrite.do")
	public String write(Model model){
		ArrayList<Board> list = svc.list();
		model.addAttribute("view", list);
		return "board/write";
	}
	@RequestMapping("/BoardInsert.do")
	public String boardInsert(Model model){
		svc.insert();
		return "board/write";
	}
	@RequestMapping("/BoardInsertForm.do")
	public String boardInsertForm(Model model){
		return "board/boardInsertForm";
	}
	@RequestMapping("/BoardUpdate.do")
	public String boardUpdate(Model model){
		svc.update();
		return "redirect:/View.do?";
		
	}
	@RequestMapping("/BoardUpdateForm.do")
	public String boardUpdateForm(Model model){
		return "board/boardUpdateForm";
	}
}
