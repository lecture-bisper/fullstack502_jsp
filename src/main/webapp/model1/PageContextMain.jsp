<%@ page import="common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page 영역-->
<% 
	pageContext.setAttribute(
			"pagePerson", new Person("한석봉",99));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageContextMain</title>
</head>
<body>
	<h2>page 영역의 속성값 읽기</h2>
	<%
		Person p=
		(Person)(pageContext.getAttribute("pagePerson"));
	%>
	<h3>사람 정보 1</h3>
	<ul>
		<li>이름: <%=p.getName()%></li>
		<li>나이: <%=p.getAge()%></li>
	</ul>
</body>
</html>



