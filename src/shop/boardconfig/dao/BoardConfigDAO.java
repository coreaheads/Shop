package shop.boardconfig.dao;

import java.util.ArrayList;

import shop.dto.BoardConfig;
import shop.dto.ParamVO;

public interface BoardConfigDAO {
	
	int totalCnt();
	
	BoardConfig getConfig(String board_code);

	ArrayList<BoardConfig> configList(ParamVO paramVO);


	
}
