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
		if (form.name.value == "") {
			alert("작성자 이름을 입력하세요");
			form.name.focus();
			return false;
		}
		
		if (form.title.value == "") {
			alert("제목을 입력하세요");
			form.title.focus();
			return false;
		}
		
		if (form.content.value == "") {
			alert("내용을 입력하세요");
			form.content.focus();
			return false;
		}
	}
</script>
</head>
<body>

	<h2>MVC2 게시판 - 게시물 수정</h2>
	
	<form name="writeFrm" action="../mvcboard/edit.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm(this);">
		<input type="hidden" name="idx" value="${ board.idx }" />
		<input type="hidden" name="prevOfile" value="${ board.ofile }" />
		<input type="hidden" name="prevSfile" value="${ board.sfile }" />
	
		<table border="1" width="90%">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="name" style="width: 150px;" value="${ board.name }" />
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" style="width: 90%"; value="${ board.title }" />
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width: 90%; height: 100px;">${ board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="ofile" />
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">작성완료</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='../mvcboard/lidt.do';">목록으로</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>











