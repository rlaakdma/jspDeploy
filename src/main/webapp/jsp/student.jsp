<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

td {
	border : 1px solid pink; text-align:center;
}

</style>
</head>
<body>
<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
	<table>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null; // 쿼리문이 'select'일 경우 필요

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java";
		String pass = "java";
		conn = DriverManager.getConnection(url, id, pass);

		stmt = conn.createStatement();

		String sql = "select*from student";
		rs = stmt.executeQuery(sql);
		out.write("<tr><td>" + "번호</td>" + "<td>" + "이름</td>" + "<td>"
				+ "국어</td>" + "<td>" + "영어</td>" + "<td>"
				+ "수학</td></tr>");
		while (rs.next()) {
			out.write("<tr><td>" + rs.getInt("STD_NUM") + "</td>"
					+ "<td>" + rs.getString("STD_NAME") + "</td>"
					+ "<td>" + rs.getInt("STD_KOR") + "점</td>" + "<td>"
					+ rs.getInt("STD_ENG") + "점</td>" + "<td>"
					+ rs.getInt("STD_MAT") + "점</td></tr>");
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		if (rs != null)
			try {rs.close();} catch (SQLException e2) {}
		if (stmt != null)
			try {stmt.close();} catch (SQLException e2) {}
		if (conn != null)
			try {conn.close();} catch (SQLException e2) {}
	}
%>
	</table>
</body>
</html>