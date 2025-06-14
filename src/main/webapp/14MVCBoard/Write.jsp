<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>

<script>
	/* 미입력된 내용이 없는지 확인 */
	function validateForm(form) {
		// 지정한 input 태그의 value 값이 비었는지 확인
		if (form.name.value == "") {
			alert("작성자를 입력하세요");
			// 지정한 input 태그로 포커스 이동
			form.name.focus();
			// form 태그의 submit 이벤트 중지
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
		
		if (form.pass.value == "") {
			alert("비밀번호를 입력하세요");
			form.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	
	<!-- 사용자가 submit 버튼 클릭 시 /mvcboard/write.do 라는 주소로 이동, 통신방식은 post -->
	<!-- enctype 을 multipart/form-data 로 설정하여 파일을 전송할 수 있도록 설정 -->
	<form name="writeFrm" action="../mvcboard/write.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm(this)">
		<table border="1" width="90%">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="name" style="width: 150px;">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" style="width: 90%;">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width: 90%; height: 100px;"></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="ofile">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass" style="width: 100px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성 완료</button>
					<button type="reset">취소</button>
					<!-- 클릭 이벤트 발생 시 지정한 url로 이동 -->
					<button type="button" onclick="location.href='../mvcboard/list.do';">목록으로</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>











