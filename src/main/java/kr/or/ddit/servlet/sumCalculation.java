package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sumCalculationServlet
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // 없으면 라틴계열이라 한글이 깨짐.
		
//		PrintWriter pw = response.getWriter();
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int startNum = Integer.parseInt(start);
		int endNum = Integer.parseInt(end);
		int sum = 0;
		
		if(startNum > endNum){ // 조건과 맞지 않을시 자동 새로고침
			response.sendRedirect("/jsp/sumInput.jsp");
		}else{
			for(int i = startNum+1; i < endNum; i++){
				sum += i;
			}
//			pw.write(startNum + "과(와) " + endNum + "의 사이 값들의 합은 " +sum + " 입니다");
		}
		
		request.setAttribute("sumResult", sum);
		
		// session에 sumResult를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(request, response);
		
	}
}