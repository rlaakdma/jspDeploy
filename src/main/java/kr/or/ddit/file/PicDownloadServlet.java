package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/pic")
public class PicDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// <img src="/pic?id=2/>
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 물리파일명을 이용하여 사진 다운로드부터 진행
		
		// 사용자 정보 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(id);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + studentVo.getPic() + "\"");
		response.setContentType("application/octet-stream");
		
		// FileUtil.fileUploadPath : rabit.png
		// 파라미터로 파일로 제공
		// http://localhost:8180/fileDownload?fileName=james.png // 다운경로로 다운받아짐.
		String fileName = request.getParameter("fileName");
		
		// D:\A_TeachingMaterial\7.JspSpring\fileUpload.james.png <--- 여기 안에 james.png이 있어야 함.
		String file = studentVo.getPicpath() + File.separator + studentVo.getPicname();
		
		// file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while((len = fis.read(b)) != -1){
			sos.write(b, 0, len);
		}		
		sos.close();
		fis.close();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}