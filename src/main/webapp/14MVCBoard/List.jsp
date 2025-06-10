<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
	a { text-decoration: none;}
</style>
</head>
<body>
	<h2>MVC2 게시판 - 목록 보기</h2>
	
	<!-- ListController 서블릿에서 전달받은 게시물 목록과 페이지 정보를 가져와서 사용 -->
	<form method="get">
		<table border="1" width="90">
			<tr>
				<th align="center">
					<select name="searchField">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchWord">
					<input type="submit" value="검색하기">
				</th>
			</tr>
		</table>
	</form>
	
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
			<th width="8%">첨부</th>
		</tr>
		<c:choose>
		<!-- 가져온 게시물 목록이 비었는지 확인 -->
			<c:when test="${ empty boardList }">
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
			<!-- EL 언어의 forEach 를 사용하여 게시물 목록 수 만큼 반복 실행 -->
			<!-- 반복 실행 시 boardList 에서 데이터 하나를 가져와서 item 이라는 변수에 저장 -->
				<c:forEach items="${ boardList }" var="item" varStatus="loop">
					<tr align="center">
					<!-- 변수 map 은 ListController 에서 전달받은 페이지 정보 -->
						<td>${ map.totalCount - (((map.pageNum - 1) * map.pageSize) + loop.index) }</td>
						<td align="left">
							<a href="/mvcboard/view.do?idx=${item.idx}">${item.title}</a>
						</td>
						<td>${item.name}</td>
						<td>${item.visitcount}</td>
						<td>${item.postdate}</td>
						<td>
							<c:if test="${ not empty item.ofile }">
								<a href="/mvcboard/download.do?ofile=${item.ofile}&sfile=${item.sfile}&idx=${item.idx}">[Down]</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<table border="1" width="90%">
		<tr align="center">
		<!-- 네비게이션 바 내용 출력 -->
			<td>${map.pagingImg}</td>
			<td width="100">
				<button type="button" onclick="location.href='/mvcboard/write.do';">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>








