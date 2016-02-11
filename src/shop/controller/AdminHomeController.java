package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {

	private static final String FOLDER = "admin";
	
	@RequestMapping("/admin.do")
	public String admin(){
		System.out.println("1");
		return FOLDER +"/index";
	}
}
