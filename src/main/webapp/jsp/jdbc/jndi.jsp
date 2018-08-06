<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Context context = new InitialContext();
	
		DataSource datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB"); // object라 형변환
		
		// 컨넥션을 100번 얻어오고 해제한다.
		Connection conn = null;
		int i = 0;

		try{
			long startTime = System.currentTimeMillis();
			//커넥션을 15번 얻어오고 해제
			for (i = 0; i < 15; i++) {
				conn = datasource.getConnection();
				out.write("Schema : "+conn.getSchema()+"<hr>");
				conn.close();
			}
			long endTime = System.currentTimeMillis();
			
			out.write("during : "+(endTime-startTime)+"ms");
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("i : " + i);
		}finally{
			if(conn!=null)try{conn.close();}catch(SQLException e2){e2.printStackTrace();}
		}
		
		// localhost:8180/jsp/jdbc/jndi.jsp
	%>
</body>
</html>