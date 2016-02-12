package shop.memberLevel.svc;

import java.util.List;

import shop.dto.MemberLevel;

public interface MemberLevelService {

	public int registMemberLevel(String member_level_name);
	
	public List<MemberLevel> listMemberLevel();
	
	public int modifyMemberLevel(int member_level_no,String member_level_name);
	
	public int deleteMemberLevel(int member_level_no);
}
