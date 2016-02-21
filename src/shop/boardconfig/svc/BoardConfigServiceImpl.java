package shop.boardconfig.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.boardconfig.dao.BoardConfigDAO;
import shop.dto.BoardConfig;
import shop.dto.ParamVO;

@Service
public class BoardConfigServiceImpl implements BoardConfigService{
	@Autowired
	private BoardConfigDAO dao;

	
	@Override
	public int totalCnt() {
		int cnt= dao.totalCnt();
		return cnt;
	}

	@Override
	public BoardConfig getConfig(int board_code) {
		BoardConfig dto = dao.getConfig(board_code);
		return dto;
	}

	@Override
	public ArrayList<BoardConfig> configList(ParamVO paramVO) {
		ArrayList<BoardConfig> list =dao.configList(paramVO);
		return list;
	}
}
