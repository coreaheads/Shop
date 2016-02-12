package shop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import shop.board.svc.BoardService;
import shop.dto.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService svcf;

	@RequestMapping("/BoardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = svc.list();
		model.addAttribute("BoardList", list);
		return "board/boardList";
	}

	@RequestMapping("/BoardView.do")
	public String view(Model model, @RequestParam int idx) {
		Board BaordDto = svc.getDto(idx);
		System.out.println(BaordDto);
		model.addAttribute("BoardDto", BaordDto);
		return "board/boardView";
	}

	@RequestMapping("/BoardWriteForm.do")
	public String write(Model model) {
		return "board/boardWriteForm";
	}

	@RequestMapping("/BoardInsert.do")
	public String boardInsert(Model model, HttpServletRequest request, Board board, PrintWriter out) {

		String upload = "/upload/board";
		String realFolder = request.getRealPath(upload);
		MultipartFile mf = board.getImgFile();
		if (mf != null) {
			String fileName = mf.getOriginalFilename();
			File uploadFile = new File(realFolder + File.separator + fileName);
			try {
				mf.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.setUrl(fileName);
		}
		if (board.getIs_notice()==null) {
			board.setIs_notice("N");
		}
		board.setRemote_addr(request.getRemoteAddr());
		System.out.println(board);
		svc.insert(board);
		
		model.addAttribute("board", board);
		// out.println("<script>window.opener.location.href=BoardList.do';</script>");
		// out.println("<script>window.close();</script>");
		return "redirect:/BoardList.do?";
	}

	

	@RequestMapping("/BoardUpdate.do")
	public String boardUpdate(Model model, HttpServletRequest request, Board board, PrintWriter out) {
		String upload = "/upload/board";
		String realFolder = request.getRealPath(upload);
		MultipartFile mf = board.getImgFile();
		if (mf != null) {
			String fileName = mf.getOriginalFilename();
			File uploadFile = new File(realFolder + File.separator + fileName);
			try {
				mf.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.setUrl(fileName);
		}
		if (board.getIs_notice()==null) {
			board.setIs_notice("N");
		}
		board.setRemote_addr(request.getRemoteAddr());
		System.out.println(board);
		svc.update(board);
		
		model.addAttribute("board", board);
		// out.println("<script>window.opener.location.href=BoardList.do';</script>");
		// out.println("<script>window.close();</script>");
	
		return "redirect:/BoardView.do?idx="+board.getIdx();

	}

	@RequestMapping("/BoardUpdateForm.do")
	public String boardUpdateForm(Model model,@RequestParam int idx) {
		Board BaordDto = svc.getDto(idx);
		model.addAttribute("BoardDto", BaordDto);
		return "board/boardUpdateForm";
	}
}
