package shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SqlSessionFactory factory;
	
	private SqlSession getSession(){
		return factory.openSession();
	}
	
	private void close(SqlSession ss){
		ss.close();
	}
	
	@Override
	public ArrayList<Category> categoryList() {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		List<Category> categoryList = session.selectList("category.categoryList");
		
		close(session);
		
		return (ArrayList<Category>) categoryList;
	}

	

	@Override
	public void topCategoryInsert(String categoryName, String division) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		Category category = new Category(0, categoryName, 0, 0, division, 0, 'N');
		
		session.insert("category.topCategoryInsert", category );
		
		session.close();
	}

	public Category selectByIdx(int idx){
		SqlSession session = getSession();
		Category category = session.selectOne("category.selectByIdx", idx);
		session.close();
		return category;
	}
	
	@Override
	public void subCategoryInsert(int rootIdx, String categoryName, String division) {
	
		// 상위 카테고리 가져오기
		Category rootCategory = selectByIdx(rootIdx);
		
		// 하위 카테고리는 상위 카테고리의 idx를 rootNum에 넣는다.
		// 하위 카테고리는 상위 카테고리의 step에 1을 더한 값을 넣어준다.
		
		// 삽입할 항목은 categoryName, division, rootNum, step
		
		int rootNum = rootCategory.getRootNum();
		int step = rootCategory.getStep()+1;
		
		Category category = new Category(0, categoryName, rootNum, step, division, 0, 'N');
		SqlSession session = getSession();
		session.insert("category.subCategoryInsert",category);
		session.close();
		
	}

	@Override
	public void categoryDelete(int idx) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		// delete는 사실상 삭제하지 않고 isDel만 Y로 업데이트 한다.
		session.update("category.delete", idx);
		session.close();
	}

	

	

	
}
