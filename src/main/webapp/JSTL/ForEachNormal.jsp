<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-collapse:collapse;
}
</style>
</head>
<body>
<!-- ForEachNormal.jsp -->
<%/* 
<c:froEach> 태그
반복을 위해 사용됩니다. 

일반 for문 형태
<c:ForEach var="변수명" begin="시작값" end="마지막값" step="증가값" />

향상된 for문 형태(foreach문)
<c:forEach var="변수명" items="컬렉션 혹은 배열" />

<c:forEach> 태그 속성
varStatus - 루프의 현재 상태를 알려주는 변수의 이름을 지정합니다.
varStatus 속성을 통해 얻을 수 있는 정보
속성명 | 일반 for문 | 향상된 for문
current | var에 지정한 현재 루프의 변숫값 반환 | 현재 루프의 실제 요소를 반환
index | var에 지정한 현재 루프의 변숫값 반환 | 현재 루프의 인덱스를 표시(0-마지막)
count | 실제 반복 횟수(1-마지막) | 일반 for문과 동일함
first | 루프의 처음일 때 true반환 | 일반 for문과 동일함
last | 루프의 마지막일 때 true 반환 | 일반 for문과 동일함
*/%>
<h4>일반 for문 형태의 forEach 태그</h4>
<c:forEach begin="1" end="3" step="1" var="i">
	<p>반복 ${i}입니다.</p>
</c:forEach>
<h4>varStatus 속성 살펴보기</h4>
<table border="1">
<c:forEach begin="3" end="5" var="i" varStatus="loop">
	<tr>
		<td>count:${loop.count }</td>
		<td>index:${loop.index }</td>
		<td>current:${loop.current }</td>
		<td>first:${loop.first }</td>
		<td>last:${loop.last }</td>
	</td>
</c:forEach>
</table>
<h4>향상된 for문 형태로 사용하기</h4>
<%
	String[] rgba={"Red","Green","Blue","Opacity"};
%>
<c:forEach	items="<%=rgba %>" var="s">
	<span style="color:${s };">${s }</span>
</c:forEach>
<!-- 402p -->
</body>
</html>











