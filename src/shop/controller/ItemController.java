package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.category.svc.CategoryService;
import shop.dto.Category;
import shop.dto.Item;
import shop.item.svc.ItemService;

@Controller
public class ItemController {
	@Autowired
	private CategoryService categorySvc;
	@Autowired
	private ItemService svc;

	@RequestMapping("/shopDetail.do")
	public ModelAndView itemUpdate(@RequestParam String idx, ModelAndView mav) {
		Item item = svc.itemDetail(idx);
		ArrayList<Category> list = categorySvc.categoryList();
		double sale = item.getSale();
		sale = (100 - sale) * 0.01;
		sale = item.getItemPrice() * sale;
		item.setSale((int) sale);
		if (item.getItemCount() > 999) {
			item.setItemCount(999);
		}
		mav.addObject("categoryFirst", list);
		mav.addObject("item", item);
		mav.setViewName("item/shopDetail");
		return mav;
	}

	@RequestMapping("/itemUpdate.do")
	public String itemUpdate(@RequestParam Item item) {
		svc.itemUpdate(item);
		return "redirect:/itemList.do";
	}

	@RequestMapping("/itemUpdateForm.do")
	public String itemUpdateForm() {
		return "itemUpdateForm";
	}

	@RequestMapping("/itemDelete.do")
	public String itemDelete(@RequestParam String idx) {
		Item item = svc.itemDetail(idx);
		svc.itemDelete(idx);
		return "itemList?itemCategory=" + item.getItemCategory();
	}

	@RequestMapping("/itemDetail.do")
	public ModelAndView ItemDetail(@RequestParam String idx, ModelAndView mav) {
		Item item = svc.itemDetail(idx);
		mav.addObject("item", item);
		mav.setViewName("admin/item/itemDetail");
		return mav;
	}

	@RequestMapping("/itemInsertForm.do")
	public String itemInsertForm() {
		return "admin/item/itemInsertForm";
	}

	@RequestMapping("/itemInsert.do")
	public String itemInsert(Model model, Item item, HttpSession session) {

		String upload = "/item_upload_img";
		String realFolder = session.getServletContext().getRealPath(upload);
		MultipartFile mf = item.getImgFile();
		String fileName = mf.getOriginalFilename();
		File uploadFile = new File(realFolder + File.separator + fileName);
		try {
			mf.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		item.setUrl(fileName);
		svc.insert(item);
		model.addAttribute("item", item);
		return "redirect:/itemList.do?itemCategory=" + item.getItemCategory();

	}
}
