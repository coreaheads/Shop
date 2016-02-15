package shop.member.dao;

import java.util.List;

import shop.dto.Member;

public interface MemberDAO {

	public int registMember(Member member);
	
	public List<Member> listMember();
	
	public Member getMember(int member_no);
	
	public int modifyMember(Member member);
	
	public int modifyPw(String oldPassword,String newPassword,int member_no);
	
	public int deleteMember(int member_no);
}
