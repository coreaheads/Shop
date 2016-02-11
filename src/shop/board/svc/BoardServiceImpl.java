package shop.board.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.board.dao.BoardDAO;
import shop.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;

	@Override
	public ArrayList<Board> list() {
		ArrayList<Board> list =dao.list();
		return list;
	}

	@Override
	public void insert(Board board) {
		dao.insert(board);
		
	}

	

	@Override
	public Board getDto(int idx) {
		Board dto = dao.getDto(idx);
		return dto;
	}

	@Override
	public void update(Board board) {
		dao.update(board);
		
	}
}
