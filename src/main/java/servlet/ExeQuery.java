package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import common.JDBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eq")
public class ExeQuery extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터베이스에서 회원 목록 가져 오기
		//DB에 연결
		JDBConnect jdbc=new JDBConnect();
		//정적 쿼리문 생성
		String sql="Select * from member";
		
		try {
			Statement s=jdbc.getCon().createStatement();
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString(1);
				String pw=rs.getString(2);
				String name=rs.getString("name");
				Date regidate=rs.getDate("regidate");
				System.out.println(
					id + pw + name +regidate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
