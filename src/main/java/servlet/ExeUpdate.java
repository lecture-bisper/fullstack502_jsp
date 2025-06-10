package servlet;

import java.io.IOException;

import common.JDBCCP;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//쿼리문으로 회원 추가
@WebServlet("/eu")
public class ExeUpdate extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DB에 연결
		ServletContext sc=this.getServletContext();
		JDBCCP jdbc=new JDBCCP(
				sc.getInitParameter("OracleDriver"), 
				sc.getInitParameter("OracleUrl"), 
				sc.getInitParameter("OracleId"), 
				sc.getInitParameter("OraclePwd"));
		//테스트용으로 회원 추가할 입력값 준비
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String name=req.getParameter("name");
		jdbc.exeUpdate(id, pass, name);
		jdbc.close();
	}
	
}





