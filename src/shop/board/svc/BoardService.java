package shop.board.svc;

import java.util.ArrayList;

import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

public interface BoardService {

	ArrayList<Board> list(ParamVO paramVO);
	void insert(Board board);
	void reply(Board board);
	void update(Board board);
	Board getDto(int idx);
	int curidx();
	void stepUp(Board board);
	int totalCnt();
	

}
