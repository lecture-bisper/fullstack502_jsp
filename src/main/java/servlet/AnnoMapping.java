package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/am")
public class AnnoMapping extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		System.out.println("am 주소 요청");
		String str="@WebServlet으로 매핑";
		req.setAttribute("message", str);
		req.getRequestDispatcher("12Servlet/AnnoMapping.jsp")
			.forward(req, resp);
	}
       

}




