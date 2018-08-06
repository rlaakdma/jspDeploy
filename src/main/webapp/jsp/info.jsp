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
	application.setAttribute("userId", request.getParameter("userId"));
	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
	rd.forward(request, response);
	%>
	
	
</body>
</html>