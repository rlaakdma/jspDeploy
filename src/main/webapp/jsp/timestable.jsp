<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	border: 2px solid lime;
}

td {
	border: 1px solid lime;
	text-align: center;
}
</style>
<body>
	<table>
		<%for (int i = 2; i < 10; i++) {%>
		<tr>
			<%for (int j = 1; j < 10; j++) {%>
			<td>
				<%=i + "*" + j + "=" + i * j + "\t"%>
			</td>
			<%}%>
		</tr>
		<%}%>
	</table>
</body>
</html>