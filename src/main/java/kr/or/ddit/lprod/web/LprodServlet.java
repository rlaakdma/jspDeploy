package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;

/**
 * Servlet implementation class LprodServlet
 */
@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);		
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		// 상품 페이지 리스트, 전체 건수조회
		LprodServiceInf lprodService = new LprodService();
		
		Map<String, Object> resultMap = lprodService.getLpordPageList(map);
		
		// 상품 페이지 리스트
		List<LprodVo> lprodList = (List<LprodVo>)resultMap.get("pageList");
		HttpSession session = request.getSession();
		session.setAttribute("lprodList", lprodList);
		
		// 페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}