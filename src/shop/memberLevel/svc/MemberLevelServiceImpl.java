package shop.memberLevel.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dto.MemberLevel;
import shop.memberLevel.dao.MemberLevelDAO;

@Service
@Transactional
public class MemberLevelServiceImpl implements MemberLevelService {
	
	@Autowired
	private MemberLevelDAO dao;
	
	@Override
	public int registMemberLevel(String member_level_name) {
		return dao.registMemberLevel(member_level_name);
	}

	@Override
	public List<MemberLevel> listMemberLevel() {
		return dao.listMemberLevel();
	}

	@Override
	public int modifyMemberLevel(int member_level_no,String member_level_name) {
		return dao.modifyMemberLevel(member_level_no, member_level_name);
	}

	@Override
	public int deleteMemberLevel(int member_level_no) {
		return dao.deleteMemberLevel(member_level_no);
	}

}
