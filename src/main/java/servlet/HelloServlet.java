package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿이란?
//서블릿은 서버 단에서 클라이언트의 요청을 받아 처리한 후 응답하는 역활을 합니다.
//MVC(model - 데이터와 관련된 부분 - 데이터 베이스와 관련된 부분
//v - view - 사용자가 GUI로 보여지는 부분 - JSP
//control -	 모델과 뷰를 컨트롤 하는 부분 - 서블릿
//서블릿 작성
//클라이언트의 요청을 전달할 요청명을 결정해야 합니다.
//요청명과 서블릿을 연결해주는 작업을 매핑이라고 하며
//두가지 방식이 있습니다.
//1. web.xml에 기술하는 방법
//2. @WebServlet 애너테이션을 사용하여 코드에 직접 명시하는 방법
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		System.out.println("HelloSerblet doGet 메소드 호출됨");
		req.setAttribute("message", "Hello Servlet...!!");
		req.getRequestDispatcher("/")
			.forward(req, resp);
	}
	
}













