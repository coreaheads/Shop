package shop.category.svc;

import java.util.ArrayList;

import shop.dto.Category;

public interface CategoryService {

	ArrayList<Category> categoryList();

	Category selectByIdx(int idx);
	
	void topCategoryInsert(String categoryName, String division);

	void subCategoryInsert(int rootIdx, String categoryName, String division);

	void categoryDelete(int idx);

	void categoryUpdate(Category category);

	
}
