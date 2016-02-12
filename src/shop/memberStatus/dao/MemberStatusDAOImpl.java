package shop.memberStatus.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.MemberLevel;
import shop.dto.MemberStatus;

@Repository
public class MemberStatusDAOImpl implements MemberStatusDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void closeSession(SqlSession session){
		session.close();
	}
	
	@Override
	public int registMemberStatus(String member_status_name) {
		SqlSession session = getSession();
		int result = session.insert("memberStatus.insert", member_status_name);
		closeSession(session);
		return result;
	}

	@Override
	public List<MemberStatus> listMemberStatus() {
		SqlSession session = getSession();
		List<MemberStatus> list = session.selectList("memberStatus.list");
		closeSession(session);
		return list;
	}

	@Override
	public int modifyMemberStatus(int member_status_no, String member_status_name) {
		SqlSession session = getSession();
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("member_status_no", member_status_no);
		hashMap.put("member_status_name", member_status_name);
		int result = session.insert("memberStatus.modify", hashMap);
		closeSession(session);
		return result;
	}

	@Override
	public int deleteMemberStatus(int member_status_no) {
		SqlSession session = getSession();
		int result = session.delete("memberStatus.delete", member_status_no);
		closeSession(session);
		return result;
	}

}
