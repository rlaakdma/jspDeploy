package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Test;

public class LprodDaoTest {

	@Test
	public void selectAllLprod() {
		/***Given***/
		LprodDaoInf lprodDao = new LprodDao();

		/***When***/
		List<LprodVo> lprodList = lprodDao.selectAllLprod();
		
		for(LprodVo vo : lprodList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(9, lprodList.size());
	}
}