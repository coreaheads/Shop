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

	ArrayList<Category> categoryNameSearch(String searchWord);

	ArrayList<Category> categoryRootNumSearch(int rootNum);

	boolean topCategoryUpCheck(int rootNum);

	ArrayList<Category> topCategoryRootNumSearch();

	void setTemp(int rootNum);

	void setChangeToRootNum(int rootNum, int changeRootNum);

	void setRootNumToChange(int changeRootNum);

	ArrayList<Category> getEqualClass(int rootNum, int step);



	

	
	
}
