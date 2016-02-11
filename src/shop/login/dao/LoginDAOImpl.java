package shop.login.dao;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Member;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void closeSession(SqlSession session){
		session.close();
	}
	
	@Override
	public Member login(String member_id, String member_pw) {
		SqlSession session = getSession();
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("member_id", member_id);
		hashMap.put("member_pw", member_pw);
		Member member = session.selectOne("member.login",hashMap);
		closeSession(session);
		return member;
	}

	@Override
	public void logOut(HttpSession session) {
		session.invalidate();

	}

}
