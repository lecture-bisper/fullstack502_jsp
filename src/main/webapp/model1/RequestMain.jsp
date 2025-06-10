<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
<!-- request 객체 
클라이언트(주로 웹 브라우저)가 전송한 요청 정보를 담고 있는 객체입니다.
주요 기능
- 클라이언트와 서버에 대한 정보 읽기
- 클라이언트가 전송한 요청 매개변수에 대한 정보 읽기
- 요청 헤더 및 쿠키 정보 읽기
-->
</head>
<body>
	<h1>내장 객체 - request</h1>
	<h2>1. 클라이언트와 서버의 환경 정보 읽기</h2>
	<!-- 
		요청은 get방식, post방식
		get 방식 - 주소에 데이터가 노출
		post 방식 - 주소에 데이터가 숨겨짐 
	 -->
	<form action="RequestWebInfo.jsp" method="post">
		<input type="text" name="eng" value="Bye"/>
		<br/>
		<input type="text" name="han" value="잘가"/>
		<br/>
		<input type="text" name="id" 
			placeholder="아이디를 입력하세요"/>
		<br/>
		<input type="submit"/>
		
		<h2>앵커 태그로 요청</h2>
		<!-- 상대 주소
			. -> 현재 폴더
			.. -> 상위 폴더
		 -->
		<a href="./RequestWebInfo.jsp?page=2">
			a 태그로 RequestWebInfo.jsp로 요청
		</a>
	</form>
</body>
</html>




