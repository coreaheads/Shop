package shop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import shop.dto.MemberLevel;
import shop.memberLevel.svc.MemberLevelService;

@Controller
public class MemberLevelController {

	private static final String FOLDER = "admin/member";

	@Autowired
	private MemberLevelService service;

	@RequestMapping("/memberLevelList.do")
	public ModelAndView memberLevelList(ModelAndView mav) {
		List<MemberLevel> list = service.listMemberLevel();
		mav.addObject("list",list);
		mav.setViewName(FOLDER + "/memberLevelList");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/registMemberLevel.do", method = RequestMethod.POST)
	public HashMap<String, Object> registMemberLevel(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int result = service.registMemberLevel(String.valueOf(param.get("member_level_name")));
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}

	@ResponseBody
	@RequestMapping(value = "/modifyMemberLevel.do", method = RequestMethod.POST)
	public HashMap<String, Object> modifyMemberLevel(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int member_level_no = Integer.parseInt(String.valueOf(param.get("member_level_no")));
		String member_level_name = String.valueOf(param.get("member_level_name"));
		int result = service.modifyMemberLevel(member_level_no,member_level_name);
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteMemberLevel.do", method = RequestMethod.POST)
	public HashMap<String, Object> deleteMemberLevel(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int member_level_no = Integer.parseInt(String.valueOf(param.get("member_level_no")));
		int result = service.deleteMemberLevel(member_level_no);
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}	

}
