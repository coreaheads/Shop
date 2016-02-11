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

import shop.dto.Item;
import shop.item.svc.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService svc;

	
	@RequestMapping("/itemUpdateForm.do")
	public String itemUpdateForm(){
		return "itemUpdateForm";
	}
	
	@RequestMapping("/itemDelete.do")
	public String itemDelete(@RequestParam String idx){
		svc.itemDelete(idx);
		return "itemList";
	}
	
	
	@RequestMapping("/itemList.do")
	public String ItemList(Model model) {
		ArrayList<Item> list = svc.itemList();
		model.addAttribute("itemList", list);
		return "admin/item/itemList";
	}
	
	@RequestMapping("/itemDetail.do")
	public ModelAndView ItemDetail(@RequestParam String idx,ModelAndView mav) {
		Item item = svc.itemDetail(idx);
		mav.addObject("item",item);
		mav.setViewName("admin/item/itemDetail");
		return mav;
	}
	@RequestMapping("/itemInsert.do")
	public String itemInsert(Model model,Item item,HttpSession session){
		
		String upload = "admin//item/img";
		String realFolder = session.getServletContext().getRealPath(upload);
		MultipartFile mf = item.getImgFile();
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
		item.setUrl(fileName);
		svc.insert(item);
		model.addAttribute("item", item);
		return "redirect:/itemList.do";
		
	}
}
