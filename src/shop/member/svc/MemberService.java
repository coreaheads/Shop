package shop.member.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import shop.dto.Member;
import shop.dto.ParamVO;

public interface MemberService {

	public int registMember(Member member);
	
	public List<Member> listMember(ParamVO paramVO);
	
	public Member getMember(int member_no);
	
	public int modifyMember(Member member);
	
	public int modifyPw(String oldPassword,String newPassword,int member_no,HttpSession session);
	
	public int deleteMember(int member_no);

	public int totalCnt();
}
