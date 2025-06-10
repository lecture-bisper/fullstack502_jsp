package servlet;

import java.io.IOException;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class MemberServlet extends HttpServlet {
	MemberDAO mdao=new MemberDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDTO mdto=mdao.getMembers(
				req.getParameter("userId"),
				req.getParameter("userPw"));
		//로그인 성공 여부에 따른 처리
		if(mdto.getId()!=null) {
			//로그인 성공
			HttpSession session=req.getSession();
			session.setAttribute("UserId", mdto.getId());
			session.setAttribute("UserName", mdto.getName());
		}else {
			//로그인 실패
			req.setAttribute("LoginErrMsg", "로그인 오류입니다.");
		}
		req.getRequestDispatcher("./06Session/LoginForm.jsp")
			.forward(req, resp);
	}
	
}





