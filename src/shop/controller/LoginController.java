package shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.dto.Member;
import shop.login.svc.LoginService;

@Controller
public class LoginController {
	
	private static final String FOLDER = "member";
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return  FOLDER + "/loginForm";
	}
	
	@RequestMapping("/login.do")
	public String login(@RequestParam String member_id,String member_pw,HttpSession session){
		Member member = service.login(member_id, member_pw);
		session.setAttribute("myInfo", member);
		return "redirect:/index.do";
	}
	
	@RequestMapping("/logOut.do")
	public String logOut(HttpSession session){
		service.logOut(session);
		return "redirect:/index.do";
	}
}
