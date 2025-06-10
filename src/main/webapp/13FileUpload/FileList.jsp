<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 13FileUpload/FileList.jsp -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<style type="text/css">
	.card-text{
		font-size: 0.7em;
		margin: 0px;
	}
</style>
</head>
<body>
<div class="container text-center">
  <div class="row">
    <div class="col">
		<c:forEach	items="${mfdtos }" var="mfdto">
			<div class="card" style="width: 18rem;">
				<img src="../Uploads/${mfdto.sfile }" class="card-img-top" alt="...">
				<div class="card-body">
				  <h5 class="card-title">${mfdto.title }</h5>
				  <p class="card-text">카테고리:${mfdto.cate }</p>
				  <p class="card-text">원본 파일명:${mfdto.ofile }</p>
				  <p class="card-text">저장된 파일명:${mfdto.sfile }</p>
				  <p class="card-text">작성일:${mfdto.postdate }</p>
				</div>
			</div>
		</c:forEach>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>