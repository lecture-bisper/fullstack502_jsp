<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 클라이언트와 서버의 환경정보 읽기</h2>
	<ul>
		<li>전송된 값1 : <%=request.getParameter("eng") %></li>
		<li>전송된 값2 : <%=request.getParameter("han") %></li>
		<li>id : <%=request.getParameter("id") %></li>
		<li>데이터 전송 방식 : <%=request.getMethod() %></li>
		<!-- URL - 주소
			getRequestURL() - 요청 주소를 반환합니다.
			getRequestURI() - 요청 주소를 반환하는데 호스트(아이피,포트)
			를 제외한 주소를 반환합니다.
		 -->
		<li>URL <%=request.getRequestURL() %></li>
		<li>URI <%=request.getRequestURI() %></li>
		<li>클라이언트 IP 주소: <%=request.getRemoteAddr() %></li>
		<!-- 
			주소 이후에 ?로 시작하는 쿼리스트링
		 -->
		<li> 쿼리스트링:<%=request.getQueryString() %>
	</ul>
</body>
</html>




