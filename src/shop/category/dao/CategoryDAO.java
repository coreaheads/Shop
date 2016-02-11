package shop.category.dao;

import java.util.ArrayList;

import shop.dto.Category;

public interface CategoryDAO {

	ArrayList<Category> categoryList();

	void topCategoryInsert(String categoryName, String division);

	Category selectByIdx(int idx);

	void subCategoryInsert(int rootIdx, String categoryName, String division);

	void categoryDelete(int idx);

	void categoryUpdate(Category category);

	
	
}
