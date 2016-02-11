package shop.member.dao;

import java.util.List;

import shop.dto.Member;

public interface MemberDAO {

	public int registMember(Member member);
	
	public List<Member> listMember();
	
	public int modifyMember(Member member);
	
	public int deleteMember(int Member_no);
}
