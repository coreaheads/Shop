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

	ArrayList<Category> categoryNameSearch(String searchWord);

	ArrayList<Category> categoryRootNumSearch(int rootNum);

	void topCategoryUp(int rootNum);

	void topCategoryDown(int rootNum);

	void subCategoryUp(int idx);

	
}
