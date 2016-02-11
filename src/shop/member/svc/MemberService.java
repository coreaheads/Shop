package shop.member.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import shop.dto.Member;

public interface MemberService {

	public int registMember(Member member);
	
	public List<Member> listMember();
	
	public int modifyMember(Member member);
	
	public int modifyPw(String oldPassword,String newPassword,int member_no,HttpSession session);
	
	public int deleteMember(int Member_no);
}
