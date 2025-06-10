<!-- 지시어 -->
<!-- 
	page 지시어 - jsp페이지에 대한 정보를 설정합니다
	include 지시어 - 외부 파일을 현재 jsp페이지에 포함시킵니다
	taglib 지시어 - 표현 언어에서 사용할 자바 클래스나 JSTL을 선언합니다.
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 스크립트 요소(선언부) -->
<!-- 스크립트 요소는 JSP에서 자바 코드를 직접 작성할 수 있게 해줍니다. -->
<!-- 선언부
	선언부에서는 스크립틀릿이나 표현식에서 사용할 멤버 변수나 메서드를 선언
	합니다.
	 <%-- <%! 변수나 메서드 선언 %> --%>
 -->
<%!
	String str1="JSP";
	String str2="안녕하세요";
%>
<html>
<head>
<meta charset="UTF-8">
<title>HelloJSP</title>
</head>
<body>
	<!-- 스크립트 요소(표현식) -->
	<!-- 프로그래밍 언어에서 표현식은 실행 결과로 하나의 값이 남는 문장
		메서드의 리턴값이나 변수의 값을 웹 브라우저 화면에 출력할 때
		사용합니다.
	 -->
	<h2>처음 만들어 보는 <%=str1 %></h2>
	<p>
	<!-- 스크립트 요소(스크립틀릿) -->
	<!-- 자바 코드를 작성하는 영역
		<%-- <% %> --%>
		스크립틀릿에 메서드를 선언하면 에러가 발생합니다.
	 -->
		<%
			out.println(str2+" "+str1+"입니다.");
		%>
	</p>
	
	<p>JSP - 서버사이드 렌더링</p>
	<p>SPA(single page application)</p>
	
	<p id="p1"><p>
	<script type="text/javascript">
		document.querySelector("#p1").innerHTML=
			"JSP - java server page "+
			"(html + css + javascript + java)"
		
	</script>
</body>
</html>







