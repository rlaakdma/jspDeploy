<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Jsp</title>
<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<style>
	th, td { text-align:center; }
</style>
</head>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">상품</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>번호</th>
									<th>상품코드</th>
									<th>상품명</th>
								</tr>
								<%
									List<LprodVo> lprodList = (List<LprodVo>) session.getAttribute("lprodList");
									for (LprodVo vo : lprodList) {
										out.write("<tr><th>" + vo.getLprod_id() + "</th>" + "<th>"
												+ vo.getLprod_gu() + "</th>" + "<th>" + vo.getLprod_nm()
												+ "</th></tr>");
									}
								%>
							</table>
							
							<h2 class="sub-header">EL</h2>
							<table class="table table-striped">
								<tr>
									<th>id</th>
									<th>code</th>
									<th>name</th>
								</tr>
								<c:forEach items="${lprodList}" var="vo">
									<tr>
										<th>${vo.lprod_id}</th>
										<th>${vo.lprod_gu}</th>
										<th>${vo.lprod_nm}</th>
									</tr>
								</c:forEach>
							</table>
						</div>
						<a class="btn btn-default pull-right">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>