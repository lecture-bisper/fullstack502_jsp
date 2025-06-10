package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.menu")
public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청한 주소 가져오기
		String uri=req.getRequestURI();
		//마지막 슬래쉬의 인덱스 값 찾기
		int lastSlash=uri.lastIndexOf("/");
		//인덱스 값으로 문자열 자르기
		String commandStr=uri.substring(lastSlash);
		if(commandStr.equals("/in.menu")) {
			req.setAttribute("resultValue", "소개");
		}else if(commandStr.equals("/blog.menu")) {
			req.setAttribute("resultValue", "블로그");
		}else if(commandStr.equals("/contact.menu")) {
			req.setAttribute("resultValue", "Contact Us");
		}
		req.getRequestDispatcher(
				"/12Servlet/FrontController.jsp")
			.forward(req, resp);
	}
	
	
	

}






