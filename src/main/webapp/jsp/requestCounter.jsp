<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- application : requestCounter : Map<String, Integer>
	el, jstl --%>
	requestCounter.jsp<br>
	
	uri : count
	
	<h3>foreach map</h3>
	<%-- map있는 값들을 전부 조회해서 출력 map.get("name"), map.et("alias")--%>
	<c:forEach items="${requestCounter }" var="uri">
		${uri }<br>
	</c:forEach>
	
</body>
</html>