<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 각 영역에 설정된 속성을 출력 -->
page : <%=pageContext.getAttribute("pageScope") %> <br> <!-- jsp 페이지 내에서만 공유되는 영역 -->
request : <%=request.getAttribute("requestScope") %> <br> <!-- 클라이언트의 요청정보가 유지되는 동안 공유되는 영역 -->
session : <%=session.getAttribute("sessionScope") %> <br> <!-- 클라이언트의 정보가 유지되는 동안 공유되는 영역, 서버가 내려가거나 그 전에는 공유가 됨 -->
														  <!-- 크롬을 쓰다가 익스플로러로 바꾸면 저장된 내용이 사라짐 -->
application : <%=application.getAttribute("applicationScope") %> <br> <!-- 웹 어플리케이션 내에서 공유되는 객체의 영역 -->

</body>
</html>

<%--

	시나리오1	
	1. localhost:8180/jsp/scope/scopeInput.jsp 접속
	2. 각 영역에 설정할 값을(이미 입력되어있음)을 전송 --> scopeSetAttr.jsp
	3. scopeArrt.jsp에서는 각 영역에 속성을 설정
	4. dispatcher를 이용하여 scopeReslt.jsp 화면 출력 기능을 위임
	5. 브라우저의 화면 결과를 뜻한다.
	
	시나리오2
	1. 같은 브라우저의 신규 tab을 열어서 결과 화면으로 직접 이동한다.
		(scopeAttr.jsp를 거치지 않는다.)
		localhost:8180/jsp/scope/scopeResult.jsp 접속
		
	시나리오 3	
	1. 새로운 브라우저(인터넷 익스플로러)를 실행하여 결과 화면으로 직접 이동한다
		localhost:8180/jsp/scope/scopeResult.jsp 접속

--%>