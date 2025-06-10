package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnect {
//	내용 수정, Connection, Statement, PreparedStatement, ResultSet 추가
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public Connection getCon() {
		return con;
	}
	
	public JDBConnect() {
		try {
			//JDBC 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//DB주소 아이디 비번
			String url="jdbc:oracle:thin:@localhost:1522/xe";
			String id="musthave";
			String pwd="1234";
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
//			리소스 삭제 시 데이터베이스 접속의 반대 순서로 삭제, ResultSet -> Statement -> PreparedStatement -> Connection 
//			데이터베이스 정보 조회 시 데이터를 저장하는 클래스인 ResultSet 타입의 객체가 있는지 확인 후 객체가 존재하면 삭제
			if (rs != null) { rs.close(); }
//			데이터베이스 쿼리를 실행하는 Statement 타입의 객체가 있는지 확인 후 삭제
			if (stmt != null) { stmt.close(); }
//			데이터베이스 쿼리를 실행하는 PreparedStatement 타입의 객체가 있는지 확인 후 삭제
			if (pstmt != null) { pstmt.close(); }
//			데이터베이스와 연결하는 Connection 객체가 있는지 확인 후 삭제
			if (con != null) { con.close(); }
			System.out.println("DB 연결 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
