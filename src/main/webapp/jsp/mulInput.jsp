<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/mulCalculation" method="post">
			<h2>입력 창</h2>
			
			<label>start</label>
			<input type="text" id="start" name="start" placeholder="start" required autofocus>
			
			<label>end</label>
			<input type="text" id="end" name="end" placeholder="end" required>
			
			<button type="submit">계산 결과</button><br>		
		</form>
	</div>
</body>
</html>