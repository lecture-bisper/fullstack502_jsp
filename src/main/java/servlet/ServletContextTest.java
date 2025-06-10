package servlet;

import java.io.IOException;

import common.JDBCCP;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sct")
public class ServletContextTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc=this.getServletContext();
		JDBCCP jdbc=new JDBCCP(
				sc.getInitParameter("OracleDriver"), 
				sc.getInitParameter("OracleUrl"), 
				sc.getInitParameter("OracleId"), 
				sc.getInitParameter("OraclePwd"));
		jdbc.close();
		
	}
	
	

}
