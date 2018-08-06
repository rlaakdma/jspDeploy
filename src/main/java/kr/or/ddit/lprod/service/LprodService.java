package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodService implements LprodServiceInf {

	/**
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 상품 정보를 조회한다.
	 */
	@Override
	public List<LprodVo> selectAllLprod() {
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.selectAllLprod();
	}
	
	/**
	 * Method : getLpordPageList
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 상품 페이지 리스트 조회
	 */
	@Override
	public Map<String, Object> getLpordPageList(Map<String, Integer> map) {
		LprodDaoInf lprodDao = new LprodDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 상품 페이지 리스트 조회
		List<LprodVo> pageList = lprodDao.getLpordPageList(map);
		resultMap.put("pageList", pageList);
		
		// 상품 전체 건수 조회
		int totCnt = lprodDao.getLprodTotCnt();
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지
		
		if(mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/lprodList?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			///lprodList?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/lprodList?page=" + i +
								"&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/lprodList?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();	
	}
}