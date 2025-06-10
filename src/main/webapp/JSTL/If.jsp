<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL/If.jsp -->
<%/* 
<c:if> 태그
<c:if test="조건" var="변수명" scope="영역">
	조건이 true일 때 출력할 문장
</c:if>
*/ %>
<!-- 변수 선언 -->
<c:set var="number" value="100" />
<h4>JSTL의 if 태그로 짝수 /홀수 판단하기</h4>
<c:if test="${number%2==0 }" var="result">
	${number }는 짝수입니다.<br/>
</c:if>
result: ${result }</br>
</body>
</html>



