package shop.controller;

import java.util.List;

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
import shop.dto.MemberLevel;
import shop.dto.ParamVO;
import shop.member.svc.MemberService;
import shop.memberLevel.svc.MemberLevelService;

@Controller
public class MemberController {

	private static final String FOLDER = "member";
	private static final String ADMINFOLDER = "admin/member";

	@Autowired
	private MemberService service;
	@Autowired
	private MemberLevelService memberService;

	@RequestMapping("/registForm.do")
	public String registForm(Model model) {
		model.addAttribute("member", new Member());
		return FOLDER + "/registForm";
	}

	@RequestMapping("/registOk.do")
	public String registOk(@Valid Member member, BindingResult result) {
		if (result.hasErrors()) {
			return FOLDER + "/registForm";
		}
		member.setMember_level_no(4);
		int registResult = service.registMember(member);
		if (registResult > 0) {
			return "redirect:/index.do";
		} else {
			return FOLDER + "/registForm";
		}
	}

	@RequestMapping("/modifyPwForm.do")
	public String modifyPwForm() {
		return FOLDER + "/modifyPwForm";
	}

	@RequestMapping("/modifyPw.do")
	public String modifyPw(@RequestParam String oldPassword, String newPassword, int member_no, HttpSession session) {

		int result = service.modifyPw(oldPassword, newPassword, member_no, session);
		if (result > 0) {
			return "redirect:/index.do";
		} else {
			return FOLDER + "/modifyPwForm";
		}

	}

	@RequestMapping("/memberList.do")
	public ModelAndView memberList(ModelAndView mav, ParamVO paramVO,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false,defaultValue="1") int board_code,
			@RequestParam(required = false, defaultValue = "") String search_sel,
			@RequestParam(required = false, defaultValue = "") String search_txt) {

		int totalcnt = service.totalCnt();
		int limit = paramVO.getLimit();
		int block = paramVO.getBlock();
		int startrow = (page * limit) - (limit - 1);
		int endrow = (page * limit);

		int allpage = (int) Math.ceil(totalcnt / (double) paramVO.getLimit());
		int startpage = ((page - 1) / block * block) + 1;
		int endpage = ((page - 1) / block * block) + block;

		if (endpage > allpage) {
			endpage = allpage;
		}
		int pagenum = 0;
		String url="";
		String mode="";
		paramVO = new ParamVO(page, startpage, endpage, block, limit, pagenum, totalcnt, startrow, endrow, board_code,
				search_txt, search_sel,url,mode);
		System.out.println(paramVO);
		List<Member> memberList = service.listMember(paramVO);
		mav.addObject("memberList", memberList);
		mav.addObject("paramvo", paramVO);
		mav.setViewName(ADMINFOLDER + "/memberList");
		return mav;

	}

	@RequestMapping("/memberRegistForm.do")
	public String memberRegistForm(Model model) {
		List<MemberLevel> memberLevel = memberService.listMemberLevel();
		model.addAttribute("memberLevel", memberLevel);
		model.addAttribute("member", new Member());
		return ADMINFOLDER + "/memberRegistForm";
	}

	@RequestMapping("/memberRegistOK.do")
	public String memberRegistOK(@Valid Member member, BindingResult result, Model model) {
		List<MemberLevel> memberLevel = memberService.listMemberLevel();
		model.addAttribute("memberLevel", memberLevel);
		if (result.hasErrors()) {
			return ADMINFOLDER + "/memberRegistForm";
		}
		int registResult = service.registMember(member);
		if (registResult > 0) {
			return "redirect:/memberList.do";
		} else {
			return ADMINFOLDER + "/memberRegistForm";
		}
	}

	@RequestMapping("/modifyForm.do")
	public String modifyForm(@RequestParam int member_no, Model model) {

		Member member = service.getMember(member_no);
		model.addAttribute("member", member);
		return FOLDER + "/modifyForm";
	}

	@RequestMapping("/modifyOK.do")
	public String modifyOK(@Valid Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return FOLDER + "/modifyForm";
		}
		int registResult = service.modifyMember(member);
		if (registResult > 0) {
			return "redirect:/index.do";
		} else {
			return FOLDER + "/modifyForm";
		}
	}

	@RequestMapping("/delete.do")
	public String delete(int member_no, HttpSession session) {
		int result = service.deleteMember(member_no);
		if (result > 0) {
			session.invalidate();
		}
		return "redirect:/index.do";
	}

	@RequestMapping("/memberModifyForm.do")
	public String memberModifyForm(@RequestParam int member_no, Model model) {
		List<MemberLevel> memberLevel = memberService.listMemberLevel();
		Member member = service.getMember(member_no);
		model.addAttribute("memberLevel", memberLevel);

		model.addAttribute("member", member);
		return ADMINFOLDER + "/memberModifyForm";
	}

	@RequestMapping("/memberModifyOK.do")
	public String memberModifyOK(@Valid Member member, BindingResult result, Model model) {
		List<MemberLevel> memberLevel = memberService.listMemberLevel();
		model.addAttribute("memberLevel", memberLevel);
		if (result.hasErrors()) {
			return ADMINFOLDER + "/memberModifyForm";
		}
		int registResult = service.modifyMember(member);
		if (registResult > 0) {
			return "redirect:/memberList.do";
		} else {
			return ADMINFOLDER + "/memberModifyForm";
		}
	}

	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam int member_no) {
		service.deleteMember(member_no);
		return "redirect:/memberList.do";

	}

}
