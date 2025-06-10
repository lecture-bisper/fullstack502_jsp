<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- root 뿌리/root 폴더 - 기본 폴더 -->
<!-- webapp/12Servlet/MemberAuth.jsp -->
</head>
<body>
	<h2>MVC 패턴으로 회원 가입 하기</h2>
	<!-- /ma http://localhost:8080/ma -->
	<!-- ./ 현재 폴더 -> http://localhost:8080/MustHaveJSP/12Servlet/ma -->
	<!-- ../ ->상위폴더 -->
	<form action="../ma" method="post">
		<div>
		<label>
		아이디:
				<input type="text" name="id">
		</label>
		</div>
		<div>
		<label>
		비밀번호:
				<input type="password" name="pass">
		</label>
		</div>
		<div>
			<input type="submit" value="가입">
		</div>
	</form>

</body>
</html>







