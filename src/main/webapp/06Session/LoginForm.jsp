<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- LoginForm.jsp -->
<style type="text/css">
	.errmsg{
		color:red;
		font-size: 0.8em;
	}
</style>
</head>
<body>
	<%/*
	액션 태그 <jsp:include>
	page 속성 값으로 추가할 페이지의 주소
	*/%>
	<jsp:include page="../Common/Link.jsp"></jsp:include>
	<h2>로그인 페이지</h2>
	<p class="errmsg">
		<%=request.getAttribute("LoginErrMsg")==null?
				"":request.getAttribute("LoginErrMsg") %>
	</p>
	<%
		if(session.getAttribute("UserId")==null){
	%>
	<form action="../login" method="post">
		<div>
			아이디:<input type="text" name="userId" 
			id="userId" />
		</div>
		<div>
			비밀번호:<input type="password" name="userPw"
			id="userPw" />
		</div>
		<div>
			<input type="submit" value="로그인" id="sumBtn"/>
		</div>
	</form>
	<%}else{ %>
		<p><%=session.getAttribute("UserName") %> 
		회원님 로그인하셨습니다.</p>
		<div>
			<a href="./logout">로그아웃</a>
		</div>
	<%} %>
	<script type="text/javascript">
		const sumBtn=document.querySelector("#sumBtn");
		const userId=document.querySelector("#userId");
		const userPw=document.querySelector("#userPw");
		sumBtn.addEventListener("click",(e)=>{
			if(!userId.value){
				alert("아이디를 입력하세요.")
				e.preventDefault()
			}
			if(!userPw.value){
				alert("비밀번호를 입력하세요.")
				e.preventDefault()
			}
		});
	</script>
</body>
</html>






