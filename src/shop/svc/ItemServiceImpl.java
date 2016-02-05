package shop.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	ItemDAO dao;
}
