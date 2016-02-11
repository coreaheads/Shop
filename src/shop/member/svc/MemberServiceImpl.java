package shop.member.svc;

import java.util.List;

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
		return null;
	}

	@Override
	public int modifyMember(Member member) {
		return 0;
	}

	@Override
	public int deleteMember(int Member_no) {
		return 0;
	}

}
