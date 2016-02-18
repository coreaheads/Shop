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
		
		Category category = dao.selectByIdx(idx);
		
		return category;
	}

	@Override
	public void subCategoryInsert(int rootIdx, String categoryName, String division) {
		
		dao.subCategoryInsert(rootIdx, categoryName, division);
		
		
	}

	@Override
	public void categoryDelete(int idx) {
 
		dao.categoryDelete(idx);
		
	}

	@Override
	public void categoryUpdate(Category category) {
		
		dao.categoryUpdate(category);
	}

	@Override
	public ArrayList<Category> categoryNameSearch(String searchWord) {
		// TODO Auto-generated method stub
		ArrayList<Category> list = 	dao.categoryNameSearch(searchWord);
		
		return list;
	}
	
}
