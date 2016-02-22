package shop.boardconfig.svc;

import java.util.ArrayList;

import shop.dto.BoardConfig;
import shop.dto.ParamVO;

public interface BoardConfigService {
	
	int totalCnt();
	BoardConfig  getConfig (int board_code);
	ArrayList<BoardConfig> configList(ParamVO paramVO);
	void insert(BoardConfig boardConfig);

}
