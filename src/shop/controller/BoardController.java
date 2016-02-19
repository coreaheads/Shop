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

import shop.board.svc.BoardService;
import shop.boardconfig.svc.BoardConfigService;
import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService svc;
	@Autowired
	private BoardConfigService bbsconfigsvc;
	@RequestMapping("/BoardList.do")
	public String boardList(Model model,ParamVO paramVO,  @RequestParam(required = false, defaultValue = "1" )  int page, @RequestParam(required=false,defaultValue="") String board_code, @RequestParam(required=false, defaultValue="") String search_sel, @RequestParam(required = false, defaultValue ="") String search_txt) {
		int totalcnt = svc.totalCnt();
		int limit= paramVO.getLimit();
		int block = paramVO.getBlock();
		int startrow = (page*limit) - (limit-1);
		int endrow = (page*limit);
		// 16 ~20 block = 10 
//		int blockLimit=2;
		// (4-1)/*10
//		int startNum=(page-1)/blockLimit*blockLimit+1;
//		int endNum =  startNum+blockLimit-1;
		int allpage = (int)Math.ceil(totalcnt/(double)paramVO.getLimit());
		int startpage = ((page-1)/block*block)+1;
		int endpage = ((page-1)/block*block)+block;
	
		if(endpage > allpage) { 
			endpage = allpage;
		}
		String mode="";
		int pagenum=0;
		String url="";
		paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code, search_txt, search_sel,url,mode);
		System.out.println(paramVO);
		ArrayList<Board> list = svc.list(paramVO);
		model.addAttribute("BoardList", list);
		model.addAttribute("paramvo", paramVO);
		return "board/boardList";
	}

	@RequestMapping("/BoardView.do")
	public String view(Model model, @RequestParam int idx) {
		Board BaordDto = svc.getDto(idx);
		
		model.addAttribute("BoardDto", BaordDto);
		return "board/boardView";
	}

	@RequestMapping("/BoardWriteForm.do")
	public String write(Model model,@RequestParam(required=false,defaultValue="free") String board_code) {
		BoardConfig boardConfig = bbsconfigsvc.getConfig(board_code);
		model.addAttribute("BoardConfig", boardConfig);
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
	
	@RequestMapping("/BoardReplyForm.do")
	public String boardReplyForm(Model model,@RequestParam int idx) {
		Board BaordDto = svc.getDto(idx);
		model.addAttribute("BoardDto", BaordDto);
		return "board/boardReplyForm";
	}
	@RequestMapping("/BoardReply.do")
	public String boardReply(Model model, HttpServletRequest request, Board board, PrintWriter out) {
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
		svc.reply(board);
		svc.stepUp(board);
		model.addAttribute("BoardDto", board);
		int curidx= svc.curidx();
		// out.println("<script>window.opener.location.href=BoardList.do';</script>");
		// out.println("<script>wind00000000000000000000000000000000000000000000000ow.close();</script>");
		return "redirect:/BoardView.do?idx="+curidx;
	}
	
	
}
