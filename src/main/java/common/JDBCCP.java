package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCCP {
	private Connection con;

	public JDBCCP(String driver,String url,String id,
			String pwd) {
		try {
			//JDBC 드라이버 로드
			Class.forName(driver);
			//DB주소 아이디 비번
			con=DriverManager.getConnection(
					url,id,pwd);
			System.out.println("DB 연결 성공(기본 생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//연결 해제
	public void close() {
		try {
			if(con !=null) {
				con.close();
			}
			System.out.println("DB 연결 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private PreparedStatement ps;
	
	//회원 추가 동적 쿼리문
	public void exeUpdate(String id,String pass,
			String name) {
		String sql="insert into member(id, pass, name)"
				+ "values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			int inResult=ps.executeUpdate();
			System.out.println(inResult+"행이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
