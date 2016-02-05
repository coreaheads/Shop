package shop.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.BoardDAO;
import shop.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO dao;

	@Override
	public ArrayList<Board> list() {
		ArrayList<Board> list =dao.list();
		return list;
	}
}
