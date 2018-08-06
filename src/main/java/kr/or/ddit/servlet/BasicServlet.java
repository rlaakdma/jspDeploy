package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BasicServlet.java
 *
 * @author PC18
 * @since 2018. 7. 2.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 2. PC18 최초 생성
 *
 * </pre>
 */
public class BasicServlet extends HttpServlet{	
	
	/**
	 * Method : destroy
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : PC18
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Override
	public void destroy() {
		System.out.println("destroy    ");
	}

	/**
	 * Method : init
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param config
	 * @throws ServletException
	 * Method 설명 :
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init   ");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		Date dt = new Date();
				
		pw.write("hello servlet world\n");		
		pw.write("current time : " + dt);
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
