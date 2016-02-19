package shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.category.svc.CategoryService;
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

	
	@RequestMapping("/index.do")
	public String index(Model model){
		ArrayList<Category> list = catesvc.categoryList();
		ArrayList<Item> bestlist = itemSvc.itemBestList(1,3);
		ArrayList<Item> bestlist2 = itemSvc.itemBestList(4,6);
		ArrayList<Item> newlist = itemSvc.itemNewList(1,3);
		ArrayList<Item> newlist2 = itemSvc.itemNewList(4,6);
		model.addAttribute("categoryFirst", list);
		model.addAttribute("itemBestList", bestlist);
		model.addAttribute("itemBestList2", bestlist2);
		model.addAttribute("itemNewList", newlist);
		model.addAttribute("itemNewList2", newlist2);
		
		return "index";
	}
	@RequestMapping("/ItemMain.do")
	public String userItemList(Model model, @RequestParam Map<String, Object> map, @RequestParam(required=false, defaultValue="1") int itemCategory,ParamVO paramVO){
		ArrayList<Category> calist = catesvc.categoryList();
		ArrayList<Category> firstList = new ArrayList<Category>();
		ArrayList<Item> itemlist = new ArrayList<>();
		Item item = new Item();
		String mode ;
		if (paramVO.getMode()!=null) {
			mode= paramVO.getMode();
		}else{
			mode = "";
		}
		int idx=0;

		
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
		//String mode = (String) map.get("mode");
		
		int page=paramVO.getPage();
		if (map.get("page")!=null) {
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
		String board_code = "";
		String url = "";
		
		
		switch (mode) {
	
		case "detail":
			url="ItemDetail.jsp";
			idx= Integer.parseInt((String) map.get("idx"));
			item = itemSvc.itemDetail(idx);
			System.out.println("item: "+item);
			ArrayList<Category> list = catesvc.categoryList();
			double sale = item.getSale();
			sale = (100 - sale) * 0.01;
			sale = item.getItemPrice() * sale;
			item.setSale((int) sale);
			if (item.getItemCount() > 999) {
				item.setItemCount(999);
			}
			
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
					search_txt, search_sel, url, mode);
			System.out.println(paramVO);
			
			
			model.addAttribute("categoryFirst", list);
			model.addAttribute("item", item);
			model.addAttribute("paramvo", paramVO);		
			model.addAttribute("url", "itemDetail.jsp");
		break;
		case "list":
			url="ItemList.jsp";
			itemlist = itemSvc.itemListSel(itemCategory);
			System.out.println(itemlist);
			
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
					search_txt, search_sel, url, mode);
			System.out.println(paramVO);
			
			//model.addAttribute("categoryFirst", list);
			model.addAttribute("itemList",itemlist);
			model.addAttribute("itemCategory",itemCategory);
			model.addAttribute("paramvo", paramVO);			
		break;
		default:
			itemlist = itemSvc.itemListSel(itemCategory);
			System.out.println(itemlist);
			paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
					search_txt, search_sel, url, mode);
			System.out.println(paramVO);
			//model.addAttribute("categoryFirst", list);
			model.addAttribute("itemList",itemlist);
			model.addAttribute("itemCategory",itemCategory);
			model.addAttribute("paramvo", paramVO);
		break;
		}

		return "item/item_body";
		
		
		
	}
	@RequestMapping("/shop.do")
	public String shopssss(Model model){
		ArrayList<Category> list = catesvc.categoryList();
		model.addAttribute("categoryFirst", list);		
		return "shop";
	}

	
	
}
