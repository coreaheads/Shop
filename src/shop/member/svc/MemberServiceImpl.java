package shop.member.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dto.Member;
import shop.member.dao.MemberDAO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public int registMember(Member member) {
		return dao.registMember(member);
	}

	@Override
	public List<Member> listMember() {
		return dao.listMember();
	}

	@Override
	public int modifyMember(Member member) {
		return dao.modifyMember(member);
	}

	@Override
	public int deleteMember(int member_no) {
		return dao.deleteMember(member_no);
	}

	@Override
	public int modifyPw(String oldPassword, String newPassword,int member_no,HttpSession session) {
		int result = dao.modifyPw(oldPassword, newPassword,member_no);
		if(result>0){
			session.invalidate();
		}
		return result;
	}

	@Override
	public Member getMember(int member_no) {
		return dao.getMember(member_no);
	}

}
