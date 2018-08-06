package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public interface LprodDaoInf {
	
	/**
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 상품 전체 정보를 출력한다.
	 */
	List<LprodVo> selectAllLprod();

	/**
	 * Method : getLpordPageList
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : lpord 상품 페이지 리스트 조회
	 */
	List<LprodVo> getLpordPageList(Map<String, Integer> map);
	
	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	int getLprodTotCnt();
}