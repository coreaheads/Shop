package shop.login.svc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dto.Member;
import shop.login.dao.LoginDAO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	@Override
	public Member login(String member_id, String member_pw) {
		
		return dao.login(member_id, member_pw);
	}

	@Override
	public void logOut(HttpSession session) {
		dao.logOut(session);

	}

}
