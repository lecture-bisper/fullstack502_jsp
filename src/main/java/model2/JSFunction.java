package model2;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

// 자바 스크립트의 소스를 자바의 클래스 형태로 만든 유틸 클래스
public class JSFunction {

//	JspWriter : jsp 파일에 내장 객체로 등록되어 있던 html 출력 클래스
//	PrintWriter : JspWriter 와 동일한 기능을 하는 클래스
	
//	자바스크립트로 메시지 알람창을 띄운 후 지정한 URL로 이동
	public static void alertLocation(String msg, String url, JspWriter out) {
		
		try {
//			자바스크립트 코드를 자바에서 사용할 수 있도록 문자열로 입력
			String script = "<script>";
			script += "alert('" + msg + "');";
//			지정한 url 로 화면 이동
			script += "location.href = '" + url + "';";
			script += "</script>";
//			html 화면에 출력
			out.print(script);
		}
		catch (Exception e) {}
	}
	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			
			String script = "<script>";
			script += "alert('" + msg + "');";
			script += "location.href = '" + url + "';";
			script += "</script>";
			
			writer.print(script);
		}
		catch (Exception e) {}
	}
	
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>";
			script += "alert('" + msg + "');";
//			웹 브라우저의 뒤로 가기 버튼과 동일한 기능
			script += "history.back();";
			script += "</script>";
			
			out.print(script);
		}
		catch (Exception e) {}
	}
	
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			
			String script = "<script>";
			script += "alert('" + msg + "');";
			script += "history.back();";
			script += "</script>";
			
			writer.print(script);
		}
		catch (Exception e) {}
	}
}






