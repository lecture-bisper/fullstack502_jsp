<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC2 게시판</title>

<script>
	function validateForm(form) {
		if (form.pass.value == "") {
			alert("비밀번호를 입력하세요");
			form.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>

	<h2>MVC2 게시판 - 비밀번호 검증</h2>
	
	<form name="writeFrm" action="../mvcboard/pass.do" method="post" onsubmit="return validateForm(this);">
	
	<!-- input 태그의 타입을 hidden 으로 사용하여 데이터는 저장하고 화면에서는 숨김 -->
	<!-- 게시물 번호, mode 값을 저장 -->
		<input type="hidden" name="idx" value="${ param.idx }" />
		<input type="hidden" name="mode" value="${ param.mode }"/>
		
		<table border="1" width="90%">
			<tr>
				<td>비밀번호</td>
				<td>
				<!-- 사용자가 입력한 비밀번호를 저장하는 input 태그 -->
					<input type="password" name="pass" style="width: 100px;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">검증하기</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='../mvcboard/list.do';">목록으로</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









