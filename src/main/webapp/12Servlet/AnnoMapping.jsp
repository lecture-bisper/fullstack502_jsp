<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 12Servlet/AnnoMapping.jsp
http://localhost:8080/MustHaveJSP/12Servlet/AnnoMapping.jsp
 -->
<style type="text/css">
.message{
	color:green;
	font-size: 30px;
	font-weight: bold;
}
</style>
</head>
<body>
<!-- @WebServlet 애너테이션 매핑  
	요청명을 통한 링크가 있는 JSP
-->
	<h2>애너테이션으로 매핑하기</h2>
	<p>현재 주소 정보 출력</p>
	<p><%=request.getContextPath() %></p>
	<p>
		<!-- 절대 주소 
			<a herf="/MustHaveJSP/am">
		-->
		<a href="<%=request.getContextPath() %>/am">
			서블릿 요청 주소 링크
		</a>
	</p>
	<p>
		<!-- 상대 주소 -->
		<a href="../am">서블릿 요청 주소 링크</a>
	</p>
	<p class="message">${message }</p>
</body>
</html>











