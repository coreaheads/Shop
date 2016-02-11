package shop.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void closeSession(SqlSession session){
		session.close();
	}
	
	@Override
	public int registMember(Member member) {
		SqlSession session = getSession();
		int result = session.insert("member.regist", member);
		closeSession(session);
		return result;
	}

	@Override
	public List<Member> listMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(int Member_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
