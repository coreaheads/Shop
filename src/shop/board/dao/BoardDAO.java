package shop.board.dao;

import java.util.ArrayList;

import shop.dto.Board;

public interface BoardDAO {

	ArrayList<Board> list();

	Board getDto(int idx);

	void insert(Board board);

	void update(Board board);
	
}
