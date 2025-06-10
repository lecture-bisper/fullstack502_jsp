<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- webapp/JSTL/Choose.jsp -->
</head>
<body>
<%/*
<c:choose> 태그 다중 조건 
<c:choose>
	<c:when test="조건1">조건 1을 만족하는 경우</c:when>
	<c:when test="조건2">조건 2을 만족하는 경우</c:when>
	<c:otherwise>아무 조건도 만족하지 않는 경우</c:otherwise>
</c:choose>
</
*/%>
<!-- 변수 선언 -->
<c:set var="number" value="100" />

<h4>choose 태그로 홀짝 판단하기</h4>
<c:choose>
	<c:when test="${number%2==0 }">
		${number }는 짝수입니다.
	</c:when>
	<c:otherwise>
		${number }는 홀수입니다.
	</c:otherwise>
</c:choose>
<h4>입력 폼에서 입력 확인</h4>
<form>
	<div>
		<label>국어:</label>
		<input type="text" name="kor" />
	</div>
	<div>
		<input type="submit" value="전송" />
	</div>
</form>

<!-- 입력폼에 입력이 됐는지 확인 -->
<c:if test="${param.kor.trim().length()>0 }">
	<p>점수 입력이 되었습니다. 국어: ${param.kor}</p>
</c:if>
</body>
</html>









