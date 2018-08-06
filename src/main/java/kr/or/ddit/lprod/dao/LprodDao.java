package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class LprodDao implements LprodDaoInf {
	
	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 상품 전체 정보를 출력한다.
	 */
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.selectAllLprod");
		session.close();
		
		return lprodList;
	}
	
	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public List<LprodVo> getLpordPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.getLprodPageList",map);
		session.close();
		return lprodList;
	}

	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	@Override
	public int getLprodTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("lprod.getLprodTotCnt");
		session.close();
		return cnt;
	}
}