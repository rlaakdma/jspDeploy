<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td { border:1px solid blue; text-align:center;}
</style>
</head>
<body>
<%--
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>call_cnt</td>						
		</tr>
		<c:forEach items="${studentList}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.call_cnt}</td>
		</tr>			
		</c:forEach>
	</table> --%>
	
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>call_cnt</td>						
		</tr>
		<c:forEach items="${studentList}" var="vo" begin="2" end="5" step="2" varStatus="status"> <!-- 특정 부분을 제어할 수 있다. -->
		<tr>
			<td>${vo.id} / ${status.index }</td>
			<td>${vo.name}</td>
			<td>${vo.call_cnt}</td>
		</tr>			
		</c:forEach>
	</table>
	
	<h3>foreach map</h3>
	<%-- map있는 값들을 전부 조회해서 출력 map.get("name"), map.et("alias")--%>
	<c:forEach items="${map }" var="entry">
		${entry.key } / ${entry.value } <br>
	</c:forEach>
	
	<h3>forTokens</h3>
	<c:forTokens items="${lineRangers }" delims="," var="ranger">
		${ranger } <br>
	</c:forTokens>
</body>
</html>