package shop.category.dao;

import java.util.ArrayList;

import shop.dto.Category;

public interface CategoryDAO {

	ArrayList<Category> categoryList();

	void topCategoryInsert(String categoryName, String division);

	
	
}
