package shop.board.svc;

import java.util.ArrayList;

import shop.dto.Board;

public interface BoardService {

	ArrayList<Board> list();

	void insert();

	void update();

}
