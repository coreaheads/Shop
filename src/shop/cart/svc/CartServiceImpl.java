package shop.cart.svc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.cart.dao.CartDAO;
import shop.dto.Cart;
import shop.dto.Item;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO dao;

	@Override
	public ArrayList<Cart> cartList() {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.cartList();

		return list;
	}

	@Override
	public ArrayList<Cart> cartSearch(String search, String word) {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.cartSearch(search, word);

		return list;
	}

	@Override
	public void cartDelete(int idx) {
		// TODO Auto-generated method stub
		dao.cartDelete(idx);
	}

	@Override
	public ArrayList<Cart> memberCartList(String memberId) {
		// TODO Auto-generated method stub
		ArrayList<Cart> list = new ArrayList<Cart>();
		list = dao.memberCartList(memberId);

		return list;
	}

	@Override
	public Item getItemByIdx(int itemId) {
		// TODO Auto-generated method stub

		Item item = dao.getItemByIdx(itemId);

		return item;
	}

	@Override
	public Cart cartIsSearch(int itemId, String memberId) {
		// TODO Auto-generated method stub

		Cart cart = dao.cartIsSearch(itemId, memberId);

		return cart;
	}

	@Override
	public void memberCartInsert(Cart cart) {
		// TODO Auto-generated method stub

		dao.memberCartInsert(cart);

	}

	@Override
	public void memberCartCountUpdate(Cart cart) {
		// TODO Auto-generated method stub

		dao.memberCartCountUpdate(cart);

	}
	
	public String getGuestId(Cookie[] cookies){
		// 쿠키의 value에는 sessionId가 들어간다.
		// oilNetGuestId 쿠키가 존재하는지 검사
		String name = null;
		String value = null; // 실제 guestId
		for (int i = 0; i < cookies.length; i++) {

			name = cookies[i].getName();
			if (name.equals("oilNetGuestId")) {
				value = cookies[i].getValue();
				break;
			}
		}
		
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void guestCartAdd(int idx, int itemCount, HttpSession session, HttpServletRequest request, HttpServletResponse response ) {
		// TODO Auto-generated method stub
		
		Cookie[] cookies = request.getCookies(); // 쿠키에서 세션 아이디가 있다면 받아온다.
		String guestId = getGuestId(cookies);

		if (guestId == null) { // 쿠키가 없으면 생성해라
			String sessionId = session.getId();
			// 시스템의 밀리초 구하기.(국제표준시각(UTC, GMT) 1970/1/1/0/0/0 으로부터 경과한 시각)
			long time = System.currentTimeMillis();
			String i = Long.toString(time);
			sessionId += i;
			Cookie cookie = new Cookie("oilNetGuestId", sessionId);
			cookie.setMaxAge(60 * 60 * 24 * 7); // 쿠키 유지 기간은 7일로 설정
			response.addCookie(cookie);
			guestId = sessionId;
		}

		Item item = getItemByIdx(idx);

		String ip = request.getRemoteAddr();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm.ss", Locale.KOREA);
		Date currentTime = new Date();
		String date = formatter.format(currentTime);

		Cart cart = new Cart(0, guestId, ip, item.getIdx(), itemCount, item.getItemPrice(), date, item.getUrl(), item.getItemName());
		
		
		ArrayList<Cart> list = (ArrayList<Cart>) session.getAttribute(guestId);

		if (list == null) { // 세션이 없다면 생성하라
			list = new ArrayList<Cart>();
			session.setAttribute(guestId, list);
			session.setMaxInactiveInterval(60*60*6); // 세션 유지시간은 최대 6시간
		}

		boolean isNew = true; // 카트에 이미 있는 아이템인지 검사
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemId() == cart.getItemId()) {
				int count = list.get(i).getItemCount() + itemCount;
				if (count > item.getItemCount()) {
					count = item.getItemCount();
				}
				
				list.get(i).setItemCount(count); // 카트에 이미 있다면 카운트 증가
				isNew = false;
			}
		}
		
		if (isNew) {
			list.add(cart);
		}
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setIdx(i); // idx에 고유값을 넣어준다
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Cart> guestCartList(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub

		Cookie[] cookies = request.getCookies(); // 쿠키에서 세션 아이디가 있다면 받아온다.
		String guestId = getGuestId(cookies);
		
		ArrayList<Cart> cartList = null;
		
		if (guestId != null) {
			cartList = (ArrayList<Cart>) session.getAttribute(guestId);	
		}
		
		return cartList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void guestCartDelete(String idx, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		
		Cookie[] cookies = request.getCookies(); // 쿠키에서 세션 아이디가 있다면 받아온다.
		String guestId = getGuestId(cookies);
		
		ArrayList<Cart> list = (ArrayList<Cart>) session.getAttribute(guestId);
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getIdx() == Integer.parseInt(idx)) {
				list.remove(i);
				break;
			}
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void guestCartItemCountUp(int itemId, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies(); // 쿠키에서 세션 아이디가 있다면 받아온다.
		String guestId = getGuestId(cookies);
		ArrayList<Cart> list = (ArrayList<Cart>) session.getAttribute(guestId);
		
		Item item = getItemByIdx(itemId);
		
		int id =itemId;
		int count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemId() == id) {
				count =list.get(i).getItemCount()+1;
				if (count > item.getItemCount()) {
					count = item.getItemCount();
				}
				list.get(i).setItemCount(count);
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void guestCartItemCountDown(String itemId, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies(); // 쿠키에서 세션 아이디가 있다면 받아온다.
		String guestId = getGuestId(cookies);
		ArrayList<Cart> list = (ArrayList<Cart>) session.getAttribute(guestId);
		
		int id = Integer.parseInt(itemId);
		int count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemId() == id) {
				count =list.get(i).getItemCount()-1;
				if (count <1 ) {
					count = 1;
				}
				list.get(i).setItemCount(count);
			}
		}
	}

}
