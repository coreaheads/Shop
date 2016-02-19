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

	@Override
	public ArrayList<Category> categoryRootNumSearch(int rootNum) {
		// TODO Auto-generated method stub
		ArrayList<Category> list = 	dao.categoryRootNumSearch(rootNum);
		
		return list;
	}


	@Override
	public void topCategoryUp(int rootNum) {
		// TODO Auto-generated method stub
		
		ArrayList<Category> list = dao.topCategoryRootNumSearch();
		
		if (list.get(0).getRootNum() == rootNum) {
			System.out.println("최상위 카테고리 입니다.");
			return;
		} else {
			int indexNum = 0;
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).getRootNum() == rootNum) {			
					indexNum = i; // 현재 카테고리의 인덱스 넘버 받기
					break;
				}
			}
			int changeRootNum = list.get(indexNum-1).getRootNum();
			// 한단계 위의 카테고리의 루트 넘버
			dao.setTemp(rootNum); // rootNum인 카테고리들을 전부 -1로 변환
			dao.setChangeToRootNum(rootNum, changeRootNum); // 상위카테고리를 현재카테고리로
			dao.setRootNumToChange(changeRootNum); // 현재 카테고리를 상위 카테고리로 (현재 -1)
			
		}
		
	}

	@Override
	public void topCategoryDown(int rootNum) {
		// TODO Auto-generated method stub
		
		ArrayList<Category> list = dao.topCategoryRootNumSearch();
		
		if (list.get(list.size()-1).getRootNum() == rootNum) {
			System.out.println("최하위 카테고리 입니다.");
			return;
		} else {
			int indexNum = 0;
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).getRootNum() == rootNum) {			
					indexNum = i; // 현재 카테고리의 인덱스 넘버 받기
					break;
				}
			}
			int changeRootNum = list.get(indexNum+1).getRootNum();
			// 한단계 위의 카테고리의 루트 넘버
			dao.setTemp(rootNum); // rootNum인 카테고리들을 전부 -1로 변환
			dao.setChangeToRootNum(rootNum, changeRootNum); // 하위카테고리를 현재카테고리로
			dao.setRootNumToChange(changeRootNum); // 현재 카테고리를 상위 카테고리로 (현재 -1)
			
		}

		
	}

	@Override
	public void subCategoryUp(int idx) {
		// TODO Auto-generated method stub
		Category category = dao.selectByIdx(idx);
		int rootNum = category.getRootNum();
		int step = category.getStep();
		ArrayList<Category> list = dao.getEqualClass(rootNum, step);
		
		if (list.get(0).getIdx() == idx) {
			System.out.println("최상위 카테고리 입니다.");
			return;
		} else {
			int indexNum = 0;
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).getIdx() == idx) {			
					indexNum = i; // 현재 카테고리의 인덱스 넘버 받기
					break;
				}
			}
			int changeRootNum = list.get(indexNum-1).getRootNum();
			// 한단계 위의 카테고리의 루트 넘버
			dao.setTemp(rootNum); // rootNum인 카테고리들을 전부 -1로 변환
			dao.setChangeToRootNum(rootNum, changeRootNum); // 상위카테고리를 현재카테고리로
			dao.setRootNumToChange(changeRootNum); // 현재 카테고리를 상위 카테고리로 (현재 -1)
			
		}

		
	}
	
}
