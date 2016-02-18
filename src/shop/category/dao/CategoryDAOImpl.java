package shop.category.dao;

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
	public Category selectByIdx(int idx) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		Category category = session.selectOne("category.selectByIdx", idx);
		session.close();
		
		return category;
	}

	@Override
	public void topCategoryInsert(String categoryName, String division) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		Category category = new Category(0, categoryName, 0, 0, division, 0, 'N');
		
		session.insert("category.topCategoryInsert", category );
		
		session.close();
	}

	@Override
	public void subCategoryInsert(int rootIdx, String categoryName, String division) {
		
		Category rootCategory = selectByIdx(rootIdx);
		// 하위 카테고리의 rootNum은 root 카테고리의 rootNum과 같다.
		// 하위 카테고리의 step은 root 카테고리의 step +1
		// 하위 카테고리의 seq는 상위 카테고리의 seq+1
		
		int rootNum = rootCategory.getRootNum();
		int step = rootCategory.getStep()+1;
		int seq = rootCategory.getSeq()+1;
		
		SqlSession session = getSession();
		
		Category category = new Category(0, categoryName, rootNum, step, division, seq, 'N');
		
		// seq가 자신보다 같거나 큰 레코드들의 seq를 1씩 먼저 증가 시킨 후에 삽입한다.
		session.update("category.subCategorySeqIncrease",category);
		session.insert("category.subCategoryInsert", category);
		session.close();
		
	}

	@Override
	public void categoryDelete(int idx) {
		
		SqlSession session = getSession();
		
		// delete는 복원 가능하도록 isDel을 Y로 update한다.
		session.update("category.categoryDelete", idx);
		
		session.close();
		
	}

	@Override
	public void categoryUpdate(Category category) {
		
		SqlSession session = getSession();
		
		session.update("category.categoryUpdate", category);
		
		session.close();
		
	}

	@Override
	public ArrayList<Category> categoryNameSearch(String searchWord) {
		// TODO Auto-generated method stub
		
		SqlSession session = getSession();
		
		List<Category> list = session.selectList("category.categoryNameSearch", searchWord);
		
		session.close();
		
		return (ArrayList<Category>) list;
	}

	@Override
	public ArrayList<Category> categoryRootNumSearch(int rootNum) {
		// TODO Auto-generated method stub
		SqlSession session = getSession();
		
		List<Category> list = session.selectList("category.categoryRootNumSearch", rootNum);
		
		session.close();
		
		return (ArrayList<Category>) list;
	}

	

	

	

	
}
