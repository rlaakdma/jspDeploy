<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
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
		//db 설정에 대한 값 설정
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "java";
		String pass = "java";
		int poolSize = 10;
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(userName);
		bds.setPassword(pass);
		bds.setInitialSize(poolSize);
		
		// 컨넥션을 
		Connection conn = null;
		int i = 0;

		try{
			long startTime = System.currentTimeMillis();
			//커넥션을 100번 얻어오고 해제
			for (i = 0; i < 50; i++) {
				conn = bds.getConnection();
				out.write("Schema : "+conn.getSchema()+"<hr>");			
			}
			long endTime = System.currentTimeMillis();
			
			out.write("during : "+(endTime-startTime)+"ms");
			bds.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("i : " + i);
		}finally{
			if(conn!=null)try{conn.close();}catch(SQLException e2){e2.printStackTrace();}
		}
	%>
</body>
</html>