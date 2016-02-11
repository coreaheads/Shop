package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.dto.Member;
import shop.member.svc.MemberService;

@Controller
public class MemberController {

	private static final String FOLDER = "member";
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/registForm.do")
	public String regisForm(Model model){
		model.addAttribute("member",new Member());
		return  FOLDER + "/registForm";
	}
	
	@RequestMapping("/registOk.do")
	public String registOk(@Valid Member member,BindingResult result){
		if(result.hasErrors()){
			return FOLDER + "/registForm";
		}
		int registResult = service.registMember(member);
		if(registResult >0){
			return "redirect:/index.do";
		}else{			
			return FOLDER + "/registForm";			
		}
	}
}
