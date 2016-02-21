package shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.board.svc.BoardService;
import shop.boardconfig.svc.BoardConfigService;
import shop.category.svc.CategoryService;
import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.Category;
import shop.dto.Item;
import shop.dto.ParamVO;
import shop.item.svc.ItemService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService catesvc;
	@Autowired
	private ItemService itemSvc;
	@Autowired
	private BoardService bbsSvc;
	@Autowired
	private BoardConfigService bbsconfigsvc;
	@RequestMapping("/index.do")
	public String index(Model model) {
		ArrayList<Category> list = catesvc.categoryList();
		ArrayList<Item> bestlist = itemSvc.itemBestList(1, 3);
		ArrayList<Item> bestlist2 = itemSvc.itemBestList(4, 6);
		ArrayList<Item> newlist = itemSvc.itemNewList(1, 3);
		ArrayList<Item> newlist2 = itemSvc.itemNewList(4, 6);
		model.addAttribute("categoryFirst", list);
		model.addAttribute("itemBestList", bestlist);
		model.addAttribute("itemBestList2", bestlist2);
		model.addAttribute("itemNewList", newlist);
		model.addAttribute("itemNewList2", newlist2);

		return "index";
	}

	@RequestMapping("/Shop.do")
	public String shop(Model model, @RequestParam Map<String, Object> map) {
		String mode = "";
		ArrayList<Category> list = catesvc.categoryList();
		model.addAttribute("categoryFirst", list);

		if (map.get("mode") != null) {
			mode = (String) map.get("mode");
		}

		switch (mode) {

		case "best":
			ArrayList<Item> bestlist = itemSvc.itemBestList(1, 9);
			model.addAttribute("itemList", bestlist);
			model.addAttribute("category", "인기 아이템");
			break;

		case "new":
			ArrayList<Item> newlist = itemSvc.itemNewList(1,9);
			model.addAttribute("itemList", newlist);
			model.addAttribute("category", "New 아이템");
			break;
		}

		

		return "shop";
	}

	@RequestMapping("/ItemMain.do")
	public String userItemList(Model model, @RequestParam Map<String, Object> map,
			@RequestParam(required = false, defaultValue = "1") int itemCategory, ParamVO paramVO) {
		ArrayList<Category> calist = catesvc.categoryList();
		ArrayList<Category> firstList = new ArrayList<Category>();
		ArrayList<Item> itemlist = new ArrayList<>();
		Item item = new Item();
		String mode;
		if (paramVO.getMode() != null) {
			mode = paramVO.getMode();
		} else {
			mode = "";
		}
		int idx = 0;

		int totalcnt = itemSvc.totalCnt();
		int limit = paramVO.getLimit();
		int block = paramVO.getBlock();
		String search_txt = (String) map.get("search_txt");
		String search_sel = (String) map.get("search_sel");

		if (map.get("mode") == null) {
			mode = "list";
		} else {
			mode = (String) map.get("mode");
		}
		// String mode = (String) map.get("mode");

		int page = paramVO.getPage();
		if (map.get("page") != null) {
			page = Integer.parseInt((String) map.get("page"));
		}

		int startrow = (page * limit) - (limit - 1);
		int endrow = (page * limit);
		// 16 ~20 block = 10
		// int blockLimit=2;
		// (4-1)/*10
		// int startNum=(page-1)/blockLimit*blockLimit+1;
		// int endNum = startNum+blockLimit-1;
		int allpage = (int) Math.ceil(totalcnt / (double) paramVO.getLimit());
		System.out.println("올페이지" + allpage);
		int startpage = ((page - 1) / block * block) + 1;
		int endpage = ((page - 1) / block * block) + block;

		if (endpage > allpage) {
			endpage = allpage;
		}

		int pagenum = 0;
		int board_code = 0;
		String url = "";

		switch (mode) {

		case "detail":
			url = "ItemDetail.jsp";
			idx = Integer.parseInt((String) map.get("idx"));
			item = itemSvc.itemDetail(idx);
			System.out.println("item: " + item);
			ArrayList<Category> list = catesvc.categoryList();
			double sale = item.getSale();
			sale = (100 - sale) * 0.01;
			sale = item.getItemPrice() * sale;
			item.setSale((int) sale);
			if (item.getItemCount() > 999) {
				item.setItemCount(999);
			}

			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			System.out.println(paramVO);

			model.addAttribute("categoryFirst", list);
			model.addAttribute("item", item);
			model.addAttribute("paramvo", paramVO);
			model.addAttribute("url", "itemDetail.jsp");
			break;
		case "list":

			itemlist = itemSvc.itemListSel(itemCategory);
			System.out.println(itemlist);
			if (itemlist.isEmpty()) {
				url = "../common/error.jsp";
			} else {
				url = "ItemList.jsp";
			}
			System.out.println(url);

			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			System.out.println(paramVO);

			// model.addAttribute("categoryFirst", list);
			
			model.addAttribute("itemList", itemlist);
			Category category = catesvc.selectByIdx(itemCategory);
			model.addAttribute("category", category);
			ArrayList<Category> categoryFirst = catesvc.categoryList();
			model.addAttribute("categoryFirst", categoryFirst);
			model.addAttribute("itemCategory", itemCategory);
			System.out.println(itemCategory);
			model.addAttribute("paramvo", paramVO);
			break;
		default:
			itemlist = itemSvc.itemListSel(itemCategory);
			System.out.println(itemlist);
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			System.out.println(paramVO);
			// model.addAttribute("categoryFirst", list);
			model.addAttribute("itemList", itemlist);
			model.addAttribute("itemCategory", itemCategory);
			model.addAttribute("paramvo", paramVO);
			break;
		}

		return "item/item_body";

	}
	
	
	
	
	
	
	@RequestMapping("/Board.do")
	public String Board(Model model, @RequestParam Map<String, Object> map,
			@RequestParam(required = false, defaultValue = "1") int itemCategory, ParamVO paramVO) {
		
		int board_code = 0;
		String search_txt = null;
		String search_sel = null;
		String mode;
		int idx=0;
		int page = 0;
		if (map.get("idx")==null) {
			idx=0;
		}else{
			idx=Integer.parseInt((String) map.get("idx"));
		}
		
		if (map.get("page")==null) {
			page=1;
		}else{
			page=Integer.parseInt((String) map.get("page"));
		}
		if (map.get("board_code")==null) {
			board_code=0;
		}else{
			board_code=Integer.parseInt((String) map.get("board_code"));
		}
		if (map.get("search_txt")==null) {
			search_txt="";
		}else{
			search_txt=(String) map.get("search_txt");
		}
		if (map.get("search_sel")==null) {
			search_sel="";
		}else{
			search_sel=(String) map.get("search_sel");
		}
		if (paramVO.getMode() != null) {
			mode = paramVO.getMode();
		} else {
			mode = "";
		}
		int totalcnt = bbsSvc.totalCnt();
		int limit= paramVO.getLimit();
		int block = paramVO.getBlock();
		int startrow = (page*limit) - (limit-1);
		int endrow = (page*limit);
		int allpage = (int)Math.ceil(totalcnt/(double)paramVO.getLimit());
		int startpage = ((page-1)/block*block)+1;
		int endpage = ((page-1)/block*block)+block;
	
		if(endpage > allpage) { 
			endpage = allpage;
		}
		int pagenum=0;
		String url="";
		
		ArrayList<Board> bbslist = bbsSvc.list(paramVO);
		Category category = catesvc.selectByIdx(itemCategory);
		model.addAttribute("category", category);
		ArrayList<Category> categoryFirst = catesvc.categoryList();
		model.addAttribute("categoryFirst", categoryFirst);
		BoardConfig boardConfig = bbsconfigsvc.getConfig(board_code);
		model.addAttribute("BoardConfig", boardConfig);

		switch (mode) {

		case "detail":
			
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			paramVO.setUrl("boardView.jsp");
			Board BaordDto = bbsSvc.getDto(idx);
			model.addAttribute("BoardDto", BaordDto);
			System.out.println(paramVO);
			model.addAttribute("paramvo", paramVO);
			break;
		case "list":
			
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code, search_txt, search_sel,url,mode);
			paramVO.setUrl("boardList.jsp");
			
			bbslist = bbsSvc.list(paramVO);
			model.addAttribute("BoardList", bbslist);
			model.addAttribute("paramvo", paramVO);
			break;
		case "write":
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code, search_txt, search_sel,url,mode);
			paramVO.setUrl("boardWriteForm.jsp");
			System.out.println(paramVO);
			model.addAttribute("paramvo", paramVO);
			break;
		case "update":
			BaordDto = bbsSvc.getDto(idx);
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			paramVO.setUrl("boardUpdateForm.jsp");
			model.addAttribute("BoardDto", BaordDto);
			System.out.println(paramVO);
			model.addAttribute("paramvo", paramVO);
			
			break;
		case "reply":
			BaordDto = bbsSvc.getDto(idx);
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow,
					board_code, search_txt, search_sel, url, mode);
			paramVO.setUrl("boardReplyForm.jsp");
			model.addAttribute("BoardDto", BaordDto);
			System.out.println(paramVO);
			model.addAttribute("paramvo", paramVO);
			
			break;
		default:
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code, search_txt, search_sel,url,mode);
			paramVO.setUrl("boardList.jsp");
			System.out.println(paramVO);
			 bbslist = bbsSvc.list(paramVO);
			model.addAttribute("BoardList", bbslist);
			model.addAttribute("paramvo", paramVO);
		}

		return "board/board_body";

	}
	
	
	

	@RequestMapping("/shop.do")
	public String shop(Model model) {
		ArrayList<Category> list = catesvc.categoryList();
		model.addAttribute("categoryFirst", list);
		return "shop_bk";
	}

}
