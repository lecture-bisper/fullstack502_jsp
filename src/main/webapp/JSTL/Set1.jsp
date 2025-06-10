<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- webapp/JSTL/Set1.jsp -->
</head>
<body>
<!-- JSTL 
JSTL은 JSP에서 빈번하게 사용되는 조건문, 반복문 등을 처리해주는 태그를
모아 표준으로 만들어 놓은 라이브러리입니다. JSTL을 사용하면 스크립틀릿 없이
태그만으로 작성할 수 있기 때문에 코드가 간결해지고 읽기 편해집니다.
-->
<!-- jsp로 구구단 만들기 -->
<table border="1">
<% for(int i=2; i<=9; i++){ %>
<tr>
	<%for(int j=1;j<=9;j++){ %>
	<td>
		<%=i %>*<%=j %>=<%=i*j %>
	</td>
	<%} %>
</tr>
<%} %>
</table>
<!-- JSTL로 구현한 구구단 -->
<table border="1">
	<c:forEach begin="2" end="9" var="i">
		<tr>
			<c:forEach begin="1" end="9" var="j">
				<td>
					${i }*${j }=${i*j }
				</td>
			</c:forEach>
		</tr>	
	</c:forEach>
</table>
<%/* 
<c:set> 태그 
기본 사용법
<c:set var="변수명" value="값" scope="영역">
또는
<c:set var="변수명" scope="영역">
	value 속성에 들어갈 값
</c:set>
*/ %>
<!-- 변수 선언 -->
<c:set var="directVar" value="100" />
<h4>EL을 이용해 변수 출력</h4>
<p>directVar : ${pageScope.directVar }</p>
<p>directVar : ${directVar }</p>
</body>
</html>











