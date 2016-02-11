package shop.login.dao;

import javax.servlet.http.HttpSession;

import shop.dto.Member;

public interface LoginDAO {

	public Member login(String member_id,String member_pw);
	
	public void logOut(HttpSession session);
}
