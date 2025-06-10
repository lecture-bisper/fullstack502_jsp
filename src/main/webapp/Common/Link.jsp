<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//webapp/Common/Link.jsp%>
<style>
	nav ul{
		width:100%;
		list-style-type:none;
		margin:0;
		padding:0;
		background-color: gray;
	}
	nav ul li{
		display:inline-block;
	}
	nav ul li a{
		text-decoration: none;
		color:white;
		padding:10px;
	}
	nav ul li a:hover{
		color:rgb(214, 214, 214);
	}
</style>
<nav>
	<ul>
		<!-- 로그인 여부에 따른 메뉴 변화 -->
		<%if(session.getAttribute("UserId")==null){ %>
			<li><a href="">로그인</a></li>
		<%}else{ %>		
			<li><a href="">로그아웃</a></li>
		<%} %>
		<li><a href="">게시판(페이지X)</a></li>
		<li><a href="">게시판(페이지O)</a></li>
	</ul>
</nav>







