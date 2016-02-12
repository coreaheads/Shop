package shop.memberStatus.dao;

import java.util.List;

import shop.dto.MemberStatus;

public interface MemberStatusDAO {
	
	public int registMemberStatus(String member_status_name);
	
	public List<MemberStatus> listMemberStatus();
	
	public int modifyMemberStatus(int member_status_no,String member_status_name);
	
	public int deleteMemberStatus(int member_status_no);
}
