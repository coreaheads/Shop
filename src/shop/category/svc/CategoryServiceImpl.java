package shop.category.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.category.dao.CategoryDAO;
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

	@Override
	public void topCategoryInsert(String categoryName, String division){
		
		dao.topCategoryInsert(categoryName, division);
		
	}

	@Override
	public Category selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subCategoryInsert(int rootIdx, String categoryName, String division) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void categoryDelete(int idx) {
		// TODO Auto-generated method stub
		
	}
	
}
