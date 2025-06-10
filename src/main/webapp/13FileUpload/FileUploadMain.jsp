<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- webapp/13FileUpload/FileUploadMain.jsp -->
<!-- 파일 업로드용 작성폼의 필수 사항
	method속성은 post로 지정
	enctype속성은 multipart/form-data로 지정
 -->
<style>
	.eMsg{
		color:red;
		font-size: 0.7em;
	}
</style>
</head>
<body>
	<h2>파일 업로드</h2>
	<form action="UploadProcess.do"
		method="post" enctype="multipart/form-data"
		id="fileForm"
	>
	
		<div>
			제목:
			<input type="text" name="title"/>
		</div>
		<div>
			카테고리(선택사항):
			<input type="radio" name="cate" 
				value="사진" checked />사진
			<input type="radio" name="cate" 
				value="파일" />파일
			<input type="radio" name="cate" 
				value="동영상" />동영상
			<input type="radio" name="cate" 
				value="음원" />음원
		</div>
		<div>
			첨부파일:<input type="file" name="ofile"/>
		</div>
		<div>
			<input type="submit" value="전송하기"/>
			<span class="eMsg"></span>
		</div>
	</form>
	<script type="text/javascript">
		const fileForm=document.querySelector("#fileForm")
		const eMsg=document.querySelector(".eMsg")
		fileForm.addEventListener("submit",e=>{
			if(fileForm.title.value.trim()==""
				|| fileForm.ofile.value==""){
				e.preventDefault()
				eMsg.innerHTML="제목과 파일은 필수입니다.";
			}
		})
	</script>
</body>
</html>














