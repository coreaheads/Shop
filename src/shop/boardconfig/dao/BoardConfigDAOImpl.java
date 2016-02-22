package shop.boardconfig.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.boardconfig.svc.BoardConfigService;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

@Repository
public class BoardConfigDAOImpl implements BoardConfigDAO {

	@Autowired
	SqlSessionFactory factory;
	
	@Override
	public int totalCnt() {
		SqlSession sqlSession =factory.openSession();
		int cnt = sqlSession.selectOne("boardconfig.totalcnt");
		sqlSession.close();
		return cnt;
	}

	@Override
	public BoardConfig getConfig(int board_code) {
		SqlSession sqlSession =factory.openSession();
		BoardConfig dto = (BoardConfig) sqlSession.selectOne("boardconfig.config",board_code);
		sqlSession.close();
		System.out.println(dto);
		return dto;
	}

	@Override
	public ArrayList<BoardConfig> configList(ParamVO paramVO) {
		SqlSession sqlSession =factory.openSession();
		List<BoardConfig> list =sqlSession.selectList("boardconfig.list",paramVO); 
		sqlSession.close();
		return (ArrayList<BoardConfig>) list;
	}

	@Override
	public void insert(BoardConfig boardConfig) {
		SqlSession sqlSession =factory.openSession();
		sqlSession.insert("boardconfig.insert",boardConfig); 
		sqlSession.close();
	}

}
