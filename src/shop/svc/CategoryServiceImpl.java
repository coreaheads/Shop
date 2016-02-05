package shop.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.dao.CategoryDAO;
import shop.dto.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO dao;
	
	@Override
	public ArrayList<Category> categoryList() {
		// TODO Auto-generated method stub
		return dao.categoryList();
	}

	
	
}
