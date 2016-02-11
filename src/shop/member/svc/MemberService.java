package shop.member.svc;

import java.util.List;

import shop.dto.Member;

public interface MemberService {

	public int registMember(Member member);
	
	public List<Member> listMember();
	
	public int modifyMember(Member member);
	
	public int deleteMember(int Member_no);
}
