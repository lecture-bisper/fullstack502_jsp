package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//세션 영역에 저장된 로그인 관련 속성을 지워 준다
		//속성을 지우는 방법은 두가지
		//1. 회원인증 정보 속성 삭제
		HttpSession session=req.getSession();
		session.removeAttribute("UserId");
		session.removeAttribute("UserName");
		//2. 모든 속성 한꺼번에 삭제
		session.invalidate();
		resp.sendRedirect("06Session/LoginForm.jsp");
	}

}








