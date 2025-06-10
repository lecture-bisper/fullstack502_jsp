<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- src/webapp/index.jsp -->
</head>
<body>
	<h1>MustHaveJSP index.jsp 페이지입니다.</h1>
	<h2>web.xml에서 매핑 후 jsp에서 출력하기</h2>
	<div>
		<a href="./h">HelloServlet으로 요청 보내기</a>
	</div>
	<div>
		<p>${message}</p>
		<p><%=request.getAttribute("message") %></p>
	</div>
	
</body>
</html>







