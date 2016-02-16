package shop.board.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.board.dao.BoardDAO;
import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;

	@Override
	public ArrayList<Board> list(ParamVO paramVO) {
		ArrayList<Board> list =dao.list(paramVO);
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

	@Override
	public void reply(Board board) {
		dao.reply(board);
		
	}

	@Override
	public int curidx() {
		return dao.curidx();
	}

	@Override
	public void stepUp(Board board) {
		dao.stepUp(board);
		
	}

	@Override
	public int totalCnt() {
		int cnt= dao.totalCnt();
		return cnt;
	}

	@Override
	public BoardConfig getConfig(String board_code) {
		BoardConfig dto = dao.getConfig(board_code);
		return dto;
	}
}
