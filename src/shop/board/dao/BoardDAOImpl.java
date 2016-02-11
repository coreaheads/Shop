package shop.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSessionFactory factory;

	@Override
	public ArrayList<Board> list() {
		SqlSession sqlSession =factory.openSession();
		
		List<Board> list =sqlSession.selectList("board.list"); 
		sqlSession.close();
		return (ArrayList<Board>) list;
	}

}
