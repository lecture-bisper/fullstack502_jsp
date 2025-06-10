<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- webapp/04Cookie/CookieMain.jsp -->
</head>
<body>
<!-- 04 쿠키(Cookie)
쿠키란?
클라이언트(주로 브라우저)에 키(key)와 값(value)형태로 저장했다가
다음 요청시 쿠키로부터 필요한 데이터를 읽어올 수 있습니다.
쓰이는 예)
팝업창 오늘 하루동안 열지 않기 체크
비밀번호 변경을 미루기 체크

키와 값 형태로 저장
request.setAttribute("키",값)

특징
쿠키가 처음 만들어진 시점에는 서버가 쿠키를 읽을 수 없습니다.
다음번 요청 때부터 클라이언트가 전송해준다.

쿠키의 생성자
new Cookie(String name, String value)
쿠키의 메서드
String getName()
쿠키의 이름을 반환합니다.
String getValue()
쿠키의 값을 반환합니다.
String getDomain()
쿠키가 적용되는 도메인을 반환합니다.
String getPath()
쿠키의 적용 경로를 반환합니다.setPath()로 설정한 적이 없다면 null을 반환
int getMaxAge()
쿠키의 유지 기간을 반환합니다.setMaxAge()로 설정한 적이 없다면 -1을 반환
 -->
<h2>1. 쿠키의 설정</h2>
<%
//쿠키 객체 생성
Cookie cookie=new Cookie("myCookie","쿠키맛나요");
//쿠키 사용 경로를 컨텍스트 루트로 설정
cookie.setPath(request.getContextPath());
//request.getContextPath() -> MustHaveJSP
//유지 기간을 1시간으로 설정
cookie.setMaxAge(3600);
//응답 헤더에 쿠키 추가
response.addCookie(cookie);
%>
<h2>2. 쿠키 설정 직후 쿠키값 확인하기</h2>
<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		String cookieName=c.getName();
		String cookieValue=c.getValue();
		out.println(cookieName+" : "+ cookieValue+"<br/>");
	}
}
%>
<h2>3. 페이지 이동 후 쿠키값 확인하기</h2>
<a href="CookieResult.jsp">
	다음 페이지에서 쿠키값 확인하기
</a>
</body>
</html>









