package shop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dto.Member;
import shop.member.svc.MemberService;

@Controller
public class MemberController {

	private static final String FOLDER = "member";
	private static final String ADMINFOLDER = "admin/member";
	
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
	
	@RequestMapping("/modifyPwForm.do")
	public String modifyPwForm(){
		return FOLDER + "/modifyPwForm";
	}
	
	@RequestMapping("/modifyPw.do")
	public String modifyPw(@RequestParam String oldPassword,String newPassword,int member_no,HttpSession session){
		
		int result = service.modifyPw(oldPassword, newPassword,member_no,session);
		if(result>0){
			return "redirect:/index.do";			
		}else{
			return FOLDER + "/modifyPwForm";
		}
		
	}
	
	@RequestMapping("/memberList.do")
	public ModelAndView memberList(ModelAndView mav){
		
		mav.setViewName(ADMINFOLDER+"/memberList");
		return mav;
		
	}
}
