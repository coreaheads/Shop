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

import shop.dto.MemberStatus;
import shop.memberStatus.svc.MemberStatusService;

@Controller
public class MemberStatusController {
	private static final String FOLDER = "admin/member";

	@Autowired
	private MemberStatusService service;

	@RequestMapping("/memberStatusList.do")
	public ModelAndView memberStatusList(ModelAndView mav) {
		List<MemberStatus> list = service.listMemberStatus();
		mav.addObject("list",list);
		mav.setViewName(FOLDER + "/memberStatusList");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/registMemberStatus.do", method = RequestMethod.POST)
	public HashMap<String, Object> registMemberLevel(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int result = service.registMemberStatus(String.valueOf(param.get("member_status_name")));
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}

	@ResponseBody
	@RequestMapping(value = "/modifyMemberStatus.do", method = RequestMethod.POST)
	public HashMap<String, Object> modifyMemberStatus(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int member_Status_no = Integer.parseInt(String.valueOf(param.get("member_status_no")));
		String member_Status_name = String.valueOf(param.get("member_status_name"));
		int result = service.modifyMemberStatus(member_Status_no,member_Status_name);
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteMemberStatus.do", method = RequestMethod.POST)
	public HashMap<String, Object> deleteMemberStatus(@RequestParam HashMap<String, Object> param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int member_Status_no = Integer.parseInt(String.valueOf(param.get("member_status_no")));
		System.out.println("되나:"+member_Status_no);
		int result = service.deleteMemberStatus(member_Status_no);
		if (result > 0) {
			hashmap.put("result", "yes");
		} else {
			hashmap.put("result", "no");
		}
		return hashmap;
	}	
}
