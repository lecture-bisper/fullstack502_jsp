<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setAttribute("scopeValue", "리퀘스트 영역"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
jsp파일들은 model1폴더로 이동 
현재 파일 : webapp/EL/ImplicitObjMain.jsp
-->
<title>Insert title here</title>
</head>
<body>
<!-- 표현 언어(EL:Explression Language) -->
<!-- 
기본 사용법
${속성}
 -->
<h2>ImplicitObjMain 페이지</h2>
<h3>영역 클래스에 저장된 속성 읽기</h3>
<p>${requestScope.scopeValue}</p>

</body>
</html>

