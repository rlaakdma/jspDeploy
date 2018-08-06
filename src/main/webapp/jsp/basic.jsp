<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 스클립틀릿 -->
<!-- 표현식 -->

	<%
		// 이 부분은 자바 코드 작성 방법이 적용된다.
		Date dt = new Date();
	
		// yyyy-mm-dd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	
	hello servlet world <br>
	current time : <%=sdf.format(dt)%>
</body>
</html>
<!-- localhostL8180/jsp/basic.jsp -->