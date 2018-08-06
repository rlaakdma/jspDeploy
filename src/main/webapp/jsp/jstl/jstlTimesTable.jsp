<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td {
	border: 1px solid blue;
}
</style>
</head>
<body>
	<!-- jstl, el 만 사용 구구단! 스클립틀릿, 표현식 사용금지 -->
	<table>
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td>${j }*${i }=${j*i}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>