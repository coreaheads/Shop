package shop.memberStatus.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dto.MemberStatus;
import shop.memberStatus.dao.MemberStatusDAO;

@Service
@Transactional
public class MemberStatusServiceImpl implements MemberStatusService {

	@Autowired
	private MemberStatusDAO dao;
	
	@Override
	public int registMemberStatus(String member_status_name) {
		return dao.registMemberStatus(member_status_name);
	}

	@Override
	public List<MemberStatus> listMemberStatus() {
		return dao.listMemberStatus();
	}

	@Override
	public int modifyMemberStatus(int member_status_no, String member_status_name) {
		return dao.modifyMemberStatus(member_status_no, member_status_name);
	}

	@Override
	public int deleteMemberStatus(int member_status_no) {
		return dao.deleteMemberStatus(member_status_no);
	}

}
