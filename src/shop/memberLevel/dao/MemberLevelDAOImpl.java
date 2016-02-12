package shop.memberLevel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.MemberLevel;

@Repository
public class MemberLevelDAOImpl implements MemberLevelDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void closeSession(SqlSession session){
		session.close();
	}
	
	@Override
	public int registMemberLevel(String member_level_name) {
		SqlSession session = getSession();
		int result = session.insert("memberLevel.insert", member_level_name);
		closeSession(session);
		return result;
	}

	@Override
	public List<MemberLevel> listMemberLevel() {
		SqlSession session = getSession();
		List<MemberLevel> list = session.selectList("memberLevel.list");
		closeSession(session);
		return list;
	}

	@Override
	public int modifyMemberLevel(int member_level_no,String member_level_name) {
		SqlSession session = getSession();
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("member_level_no", member_level_no);
		hashMap.put("member_level_name", member_level_name);
		int result = session.insert("memberLevel.modify", hashMap);
		closeSession(session);
		return result;
	}

	@Override
	public int deleteMemberLevel(int member_level_no) {
		SqlSession session = getSession();
		int result = session.delete("memberLevel.delete", member_level_no);
		closeSession(session);
		return result;
	}

}
