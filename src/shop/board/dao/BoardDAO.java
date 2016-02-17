package shop.board.dao;

import java.util.ArrayList;

import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

public interface BoardDAO {

	ArrayList<Board> list(ParamVO paramVO);

	Board getDto(int idx);

	void insert(Board board);

	void update(Board board);
	
	void reply(Board board);
	
	int curidx();
	
	void stepUp(Board board);

	int totalCnt();
	
	

	
}
