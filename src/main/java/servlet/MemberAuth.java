package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//http://localhost:8080/MustHaveJSP/ma
@WebServlet("/ma")
public class MemberAuth extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		//데이터 베이스에 회원 정보 저장
		req.setAttribute("id", id);
		req.getRequestDispatcher("/12Servlet/SighUpCom.jsp")
			.forward(req, resp);
		
	}
	

}








