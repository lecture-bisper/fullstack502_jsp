<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
//날짜 표시 형식
SimpleDateFormat dateFormat=
	new SimpleDateFormat("HH:mm:ss");
//최초 요청(세션 생성) 시각
long creationTime=session.getCreationTime();
String creationTimeStr=
	dateFormat.format(new Date(creationTime));
//마지막 요청 시각
long lastTime= session.getLastAccessedTime();
String lastTimeStr=dateFormat.format(new Date(lastTime));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 06Session/SessionMain.jsp -->
<%/* 
세션 유지 시간 설정
	1. web.xml
	<session-config>
		<session-timeout>20</session-timeout>
	</session-config>
	유지 시간을 분 단위로 설정합니다. 위의 코드는 20분을 설정합니다.
	2. jsp파일
	session.setMaxInactiveInterval(1200);
	메서드의 유지 시간 단위는 초입니다. 1200초 즉 20분으로 설정합니다.
*/ %>
</head>
<body>
	<h2>Session 설정 확인</h2>
	<ul>
		<li>
			세션 유지 시간:
			<%=session.getMaxInactiveInterval() %>
		</li>
		<li>
			세션 아이디:
			<%=session.getId() %>
		</li>
		<li>
			최초 요청 시각:
			<%=creationTimeStr %>
		</li>
		<li>
			마지막 요청 시각:
			<%=lastTimeStr %>
		</li>
	</ul>
</body>
</html>











