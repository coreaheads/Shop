package shop.svc;

import java.util.ArrayList;

import shop.dto.Category;

public interface CategoryService {

	ArrayList<Category> categoryList();

	void topCategoryInsert(String categoryName, String division);

	void subCategoryInsert(int rootIdx, String categoryName, String division);

	void categoryDelete(int idx);

	Category selectByIdx(int idx);

	
}
