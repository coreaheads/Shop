package shop.board.svc;

import java.util.ArrayList;

import shop.dto.Board;

public interface BoardService {

	ArrayList<Board> list();

	void insert(Board board);

	void update(Board board);

	Board getDto(int idx);

}
