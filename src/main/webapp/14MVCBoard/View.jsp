<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC2 게시판</title>
</head>
<body>

	<h2>MVC2 게시판 - 상세보기 페이지</h2>
	
	<table border="1" width="90%">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="*" />
		</colgroup>
		
		<!-- ViewController 에서 request 객체에 저장한 board, isImage 데이터를 사용 -->
		<tr>
			<td>번호</td>
			<td>${board.idx}</td>
			<td>작성자</td>
			<td>${board.name}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${board.postdate}</td>
			<td>조회수</td>
			<td>${ board.visitcount }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${ board.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3" hight="100">${ board.content }
			<!-- el 언어의 if 문을 사용하여 ofile 이 있는지 확인 및 isImage의 값이 true 인지 확인 -->
				<c:if test="${ not empty board.ofile and isImage eq true }">
					<br><img src="../Upload/${ board.sfile }" style="max-width: 100%;"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<c:if test="${ not empty board.ofile }">${ board.ofile }
					<a href="../mvcboard/download.do?ofile=${ board.ofile }&sfile=${ board.sfile }&idx=${ board.idx }">[다운로드]</a>
				</c:if>
			</td>
			<td>다운로드 수</td>
			<td>${ board.downcount }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<!-- param : jstl 에서 사용하는 파라미터 객체를 의미 -->
			<!-- 클릭 이벤트 시 /mvcboard/pass.do 로 이동, 파라미터로 mode, idx 를 전달 -->
				<button type="button" onclick="location.href='../mvcboard/pass.do?moode=edit&idx=${ param.idx }';">수정하기</button>
				<button type="button" onclick="location.href='../mvcboard/pass.do?mode=delete&idx=${ param.idx }';">삭제하기</button>
				<button type="button" onclick="location.href='../mvcboard/list.do';">목록으로</button>
			</td>
		</tr>
	</table>
</body>
</html>









