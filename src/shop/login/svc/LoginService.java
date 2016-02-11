package shop.login.svc;

import javax.servlet.http.HttpSession;

import shop.dto.Member;

public interface LoginService {

	public Member login(String member_id,String member_pw);
	
	public void logOut(HttpSession session);
}
