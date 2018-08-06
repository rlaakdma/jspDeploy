package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mulCalculation
 */
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // 없으면 라틴계열이라 한글이 깨짐.
		
		PrintWriter pw = response.getWriter();
		
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int startNum = Integer.parseInt(start);
		int endNum = Integer.parseInt(end);				
		
		pw.write(startNum + "과(와) " + endNum + "의 곱셈의 결과 값은 " +startNum*endNum + " 입니다");		
	}
}
