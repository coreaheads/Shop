package shop.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.dto.Board;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSessionFactory factory;

	@Override
	public ArrayList<Board> list(ParamVO paramVO) {
		SqlSession sqlSession =factory.openSession();
		List<Board> list =sqlSession.selectList("board.list",paramVO); 
		sqlSession.close();
		return (ArrayList<Board>) list;
	}

	@Override
	public Board getDto(int idx) {
		SqlSession sqlSession =factory.openSession();
		Board dto = (Board) sqlSession.selectOne("board.view",idx);
		sqlSession.close();
		return dto;
	}

	@Override
	public void insert(Board board) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("board.insert", board);
		sqlSession.close();
		
		
	}

	@Override
	public void update(Board board) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("board.update", board);
		sqlSession.close();
		
	}

	@Override
	public void reply(Board board) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("board.reply", board);
		sqlSession.close();
		
	}

	@Override
	public int curidx() {
		SqlSession sqlSession =factory.openSession();
		int curidx = sqlSession.selectOne("board.curidx");
		sqlSession.close();
		return curidx;
	}

	@Override
	public void stepUp(Board board) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.update("board.stepup",board);
		sqlSession.close();
		
	}

	@Override
	public int totalCnt() {
		SqlSession sqlSession =factory.openSession();
		int cnt = sqlSession.selectOne("board.totalcnt");
		sqlSession.close();
		return cnt;
	}

	@Override
	public BoardConfig getConfig(String board_code) {
		SqlSession sqlSession =factory.openSession();
		BoardConfig dto = (BoardConfig) sqlSession.selectOne("board.config",board_code);
		sqlSession.close();
		return dto;
	}

}
