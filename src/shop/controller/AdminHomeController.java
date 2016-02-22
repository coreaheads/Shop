package shop.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.board.svc.BoardService;
import shop.boardconfig.svc.BoardConfigService;
import shop.category.svc.CategoryService;
import shop.dto.BoardConfig;
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
	@Autowired
	private BoardConfigService bbsconfigsvc;

	private static final String FOLDER = "admin";

	@RequestMapping("/admin.do")
	public String admin() {
		System.out.println("1");
		return FOLDER + "/index";
	}

	@RequestMapping("/categoryList.do")
	public String categoryList(Model model) {

		ArrayList<Category> list = catesvc.categoryList();

		model.addAttribute("categoryList", list);

		return "admin/category/categoryList";
	}

	@RequestMapping("/item.do")
	public String itemList(Model model, @RequestParam(required = false, defaultValue = "list") String mode,
			@RequestParam(required = false, defaultValue = "1") int idx,ParamVO paramVO,@RequestParam Map<String, Object> map) {
		ArrayList<Category> upcalist = catesvc.categoryList();
		ArrayList<Category> firstList = new ArrayList<Category>();
		
		
		int totalcnt = itemsvc.totalCnt();
		int limit = paramVO.getLimit();
		int block = paramVO.getBlock();
		String search_txt = (String) map.get("search_txt");
		String search_sel = (String) map.get("search_sel");
		int page;
		if (map.get("mode") == null) {
			mode = "list";
		} else {
			mode = (String) map.get("mode");
		}
		//String mode = (String) map.get("mode");
		if (map.get("page") == null) {
			page =1;
		} else {
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
		String url = "item";
		paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
				search_txt, search_sel, url, mode);
		System.out.println(paramVO);
		

		switch (mode) {
		case "insert":
			System.out.println(upcalist);
			for (Category x : upcalist) {
				if (x.getStep() == 0) {
					firstList.add(x);
				}
			}
			model.addAttribute("firstList", firstList);
			model.addAttribute("url", "itemInsertForm.jsp");
			paramVO.setUrl("itemInsertForm.jsp");
			model.addAttribute("paramvo",paramVO);
			break;
		case "update":
			Item upitem = itemsvc.itemDetail(idx);
			for (Category x : upcalist) {
				if (x.getStep() == 0) {
					firstList.add(x);
				}
			}
			model.addAttribute("firstList", firstList);
			model.addAttribute("categoryFirst", upcalist);
			model.addAttribute("item", upitem);
			model.addAttribute("url", "itemUpdateForm.jsp");
			paramVO.setUrl("itemUpdateForm.jsp");
			model.addAttribute("paramvo",paramVO);
			break;
		case "detail":
			Item item = itemsvc.itemDetail(idx);
			ArrayList<Category> list = catesvc.categoryList();
			double sale = item.getSale();
			sale = (100 - sale) * 0.01;
			sale = item.getItemPrice() * sale;
			item.setSale((int) sale);
			if (item.getItemCount() > 999) {
				item.setItemCount(999);
			}
			model.addAttribute("categoryFirst", list);
			model.addAttribute("item", item);
			paramVO.setUrl("itemDetail.jsp");
			model.addAttribute("paramvo",paramVO);
			model.addAttribute("url", "itemDetail.jsp");
			break;

		default:
			ArrayList<Item> itemlist = itemsvc.itemList(paramVO);
			model.addAttribute("itemList", itemlist);
			
			model.addAttribute("url", "itemList.jsp");
			paramVO.setUrl("itemList.jsp");
			model.addAttribute("paramvo",paramVO);
			break;
		}

		return "admin/item/item_body";
	}

	@RequestMapping("/BoardConfig.do")
	public String boardConfig(Model model, @RequestParam Map<String, Object> map, ParamVO paramVO) {
		int totalcnt = bbsconfigsvc.totalCnt();
		int limit = paramVO.getLimit();
		int block = paramVO.getBlock();
		String search_txt = (String) map.get("search_txt");
		String search_sel = (String) map.get("search_sel");
		String mode = paramVO.getMode();
		if (map.get("mode") == null) {
			mode = "list";
		} else {
			mode = (String) map.get("mode");
		}
		//String mode = (String) map.get("mode");

		int page = Integer.parseInt((String) map.get("page"));
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
		String url = "BoardConfig";
		paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
				search_txt, search_sel, url, mode);
		System.out.println(paramVO);

		switch (mode) {
		case "insert":
			model.addAttribute("paramvo", paramVO);
			model.addAttribute("url", "BoardConfigInsertForm.jsp");
		break;
		
		default:
			ArrayList<BoardConfig> list = bbsconfigsvc.configList(paramVO);
			model.addAttribute("List", list);
			System.out.println(paramVO);
			paramVO.setUrl("boardConfigList.jsp");
			model.addAttribute("paramvo", paramVO);
			model.addAttribute("url", "boardConfigList.jsp");
			break;
		}
		return "admin/board/board_body";
	}

	@RequestMapping("/itemInsertAjax.do")

	public @ResponseBody ArrayList<?> jsonSample(@RequestParam(required = false, defaultValue = "") int idx) {

		ArrayList<Category> list = catesvc.categoryList();

		ArrayList<Category> secondList = new ArrayList<Category>();
		for (Category x : list) {
			if (x.getStep() == 1) {
				if (x.getRootNum() == idx) {
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
