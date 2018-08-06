package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println(request.getMethod());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		// 파라미터를 받아서 sysout으로 console 창에 출력
		String userId = request.getParameter("userId");
		String Password = request.getParameter("Password");
		pw.write("userId : " + userId + "\n");
		
		// 로그인 프로세스
		// 가짜(fake) service, dao객체를 생성
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.getUser(userId);
		
		if(userVo.vaildateUser(userId, Password)){
			
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response); // RequestDispatcher 2안. <-- 기존 값. ("jsp/main.jsp")
			
		}else{	
			//response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}

		System.out.println("userId : " + userId);
		System.out.println("Password : " + Password);
		
		pw.close();
	}
}