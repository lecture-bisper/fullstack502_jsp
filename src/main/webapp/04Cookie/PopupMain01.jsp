<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- PopupMain01.jsp -->
<!-- 팝업창 제어 
[오늘 하루 열지 않기]를 체크한 후 닫는다면 하루 동안은 
다시 방문해도 팝업 공지가 나타나지 않습니다.
-->
</head>
<style>
#popup{
	position:absolute;
	top:100px;
	left:100px;
	color:white;
	width:270px;
	height:100px;
	background-color: grey;
	text-align:center;
}
#popup>div{
	position:relative;
	color:black;
	background-color: white;
	top:0px;
	border:1px solid gray;
	padding:10px;
	text-align:right;
}
</style>
<body>
<!-- 쿠키 없이 기본 기능 구현하기 -->
<% 
//팝업창 띄울지 여부
String popupMode="on";

%>
<h2>팝업 메인 페이지(ver 0.1)</h2>
<%
out.print("현재 팝업창은 "+popupMode+" 상태입니다.");
%>
<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
<%
if(popupMode.equals("on")){
%>
<!-- 공지사항 팝업 화면 -->
<div id="popup">
	<h2>공지사항 팝업입니다.</h2>
	<div>
		<form name="popFrm">
			<input type="checkbox" id="inactiveToday"
				value="1"/>
			하루동안 열지 않음
			<input type="button" value="닫기" 
			id="closeBtn"/>
		</form>
	</div>
</div>
<%} %>
<script type="text/javascript">
	const closeBtn=document.querySelector("#closeBtn")
	const popup=document.querySelector("#popup")
	closeBtn.addEventListener("click",()=>{
		popup.style.display="none";
	})
</script>
</body>
</html>












