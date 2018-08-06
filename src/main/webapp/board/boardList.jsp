<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>제목 :</th>
			<th>사용자 아이디</th>
			<th>별명</th>
			<th>등록일(yyyy-MM-dd)</th>
		</tr>
		<%
			List<BoardVo> boardList = (List<BoardVo>) session.getAttribute("boardList");
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		%>
		<%
			for (int i = 0; i < boardList.size(); i++) {
				String date = sdf.format(boardList.get(i).getRegDt());
				
		%>
		<tr>
			<th><%=boardList.get(i).getTitle()%></th>
			<th><%=boardList.get(i).getUserId()%></th>
			<th><%=boardList.get(i).getAlias()%></th>
			<th><%=date%></th>
			<%
				}
			%>
		</tr>
	</table>
</body>
</html>