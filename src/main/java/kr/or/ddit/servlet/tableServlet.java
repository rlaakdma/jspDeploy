package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tableServlet
 */
@WebServlet("/tableServlet")
public class tableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8"); // 없으면 라틴계열이라 한글이 깨짐.

		PrintWriter pw = response.getWriter();

		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<meta charset=\"UTF-8\">");
		pw.write("<title>Insert title here</title>");
		pw.write("</head>");
		pw.write("<style>");
		pw.write("table { border: 1px solid blue; }");
		pw.write("td { border: 1px solid blue; text-align: center; }");
		pw.write("</style>");
		pw.write("<body>");
		pw.write("<table>");
		for (int i = 2; i < 10; i++) {
			pw.write("<tr>");
			for (int j = 1; j < 10; j++) {
				pw.write("<td>" + i + "*" + j + "=" + i * j + "\t</td>");
			}
			pw.write("</tr>");
		}
		pw.write("</table>");
		pw.write("</body>");
		pw.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
