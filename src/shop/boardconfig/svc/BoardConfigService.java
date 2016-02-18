package shop.boardconfig.svc;

import java.util.ArrayList;

import shop.dto.BoardConfig;
import shop.dto.ParamVO;

public interface BoardConfigService {

	
	int totalCnt();
	BoardConfig  getConfig (String board_code);
	ArrayList<BoardConfig> configList(ParamVO paramVO);

}