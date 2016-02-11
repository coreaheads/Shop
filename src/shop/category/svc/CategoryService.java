package shop.category.svc;

import java.util.ArrayList;

import shop.dto.Category;

public interface CategoryService {

	ArrayList<Category> categoryList();

	void topCategoryInsert(String categoryName, String division);

	
}
