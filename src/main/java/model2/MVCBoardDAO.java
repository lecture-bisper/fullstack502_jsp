package model2;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import common.JDBConnect;

// MVC2 게시판용 데이터베이스 조작용 DAO 클래스
public class MVCBoardDAO extends JDBConnect {
	
	
	public MVCBoardDAO() {
		super();
	}
	
//	메소드 close(), getCon() 상속받음
	
	
//	게시물 수 반환
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
//		전체 게시물 수 조회 쿼리문 생성
		String sql = "SELECT COUNT(*) as cnt FROM mvcboard ";
		
//		검색어가 있을 경우 where 절 추가
		if (map.get("searchWord") != null) {
			sql += "WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%' ";
		}
		
		try {
//			Statement 를 사용하여 데이터베이스에 쿼리문 전달
			stmt = con.createStatement();
//			실제로 데이터베이스 쿼리문 실행, 조회된 데이터 가져오기
			rs = stmt.executeQuery(sql);
			
//			while (rs.next()) {
//				totalCount = rs.getInt("cnt");
//			}
//			ResultSet 에 저장된 내용을 하나 가져옴
			rs.next();
//			getInt() 메소드를 사용하여 데이터 가져오기
			totalCount = rs.getInt("cnt");
		}
		catch(Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
		
//		가져온 총 게시물 수를 반환
		return totalCount;
	}
	
//	게시물 목록
	public List<MVCBoardDTO> selectListPage(Map<String, Object> map) {
//		반환할 게시물 목록 리스트 객체 생성, 빈 리스트
		List<MVCBoardDTO> boardList = new Vector<MVCBoardDTO>();
		
//		조회할 쿼리문 생성
		String sql = "SELECT * FROM ";
		sql += "(SELECT Tb.*, ROWNUM rNum FROM ( ";
		sql += "SELECT * FROM mvcboard ";
		
//		검색어 여부 확인
		if (map.get("searchWord") != null) {
//			검색어가 있으면 where 절 추가
			sql += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
		}
		
//		나머지 쿼리문 추가
		sql += "ORDER BY idx DESC ";
		sql += ") Tb ";
		sql += " ) ";
		sql += "WHERE rNum BETWEEN ? AND ? ";
		
		try {
//			PreparedStatement 객체 생성, 조회 쿼리문 등록
			pstmt = con.prepareStatement(sql);
//			? 기호에 데이터 추가
			pstmt.setString(1, map.get("start").toString());
			pstmt.setString(2, map.get("end").toString());
//			완성된 쿼리문을 데이터베이스에 질의 후 데이터 가져오기
			rs = pstmt.executeQuery();
			
//			ResultSet에 저장된 데이터를 next() 를 사용하여 하나씩 가져옴
			while (rs.next()) {
//				ResultSet에서 가져온 데이터를 저장할 MVCBoardDTO 타입의 객체 생성
				MVCBoardDTO board = new MVCBoardDTO();
				
//				MVCBoardDTO 타입의 객체에 데이터 저장
				board.setIdx(rs.getString("idx"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPostdate(rs.getDate("postdate"));
				board.setOfile(rs.getString("ofile"));
				board.setSfile(rs.getString("sfile"));
				board.setDowncount(rs.getInt("downcount"));
				board.setPass(rs.getString("pass"));
				board.setVisitcount(rs.getInt("visitcount"));
				
//				MVCBoardDTO 타입으로 생성한 List에 데이터 저장
				boardList.add(board);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
//		가져온 게시물 목록을 반환
		return boardList;
	}
	
//	게시물 등록
	public int insertWrite(MVCBoardDTO dto) {
		int result = 0;
		
		try {
//			데이터베이스 insert 쿼리문 생성
			String sql = "INSERT INTO mvcboard ";
			sql += "(idx, name, title, content, ofile, sfile, pass) ";
			sql += "VALUES (seq_mvcboard_num.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
			
//			prepareStatement 객체 생성
			pstmt = con.prepareStatement(sql);
//			? 기호에 맞는 데이터 입력
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getOfile());
			pstmt.setString(5, dto.getSfile());
			pstmt.setString(6, dto.getPass());
			
//			prepareStatement 를 사용하여 실제 데이터베이스에 쿼리 전달 및 실행
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 등록 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
//		데이터베이스 실행 결과값 반환
		return result;
	}
	
//	게시물 상세보기, 매개변수로 게시물 번호를 받아서 사용
	public MVCBoardDTO selectView(String idx) {
//		데이터베이스에서 가져온 게시물 정보를 저장할 DTO 객체 생성
		MVCBoardDTO board = new MVCBoardDTO();
		
//		SQL 쿼리문 생성
		String sql = "SELECT * FROM mvcboard WHERE idx = ? ";
		
		try {
//			prepareStatement 객체 생성
			pstmt = con.prepareStatement(sql);
//			게시물 번호 설정
			pstmt.setString(1, idx);
//			데이터베이스에 쿼리문 전달 및 실행, 결과값 가져옴
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
//				가져온 데이터를 DTO 타입의 객체에 저장
				board.setIdx(rs.getString("idx"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPostdate(rs.getDate("postdate"));
				board.setOfile(rs.getString("ofile"));
				board.setSfile(rs.getString("sfile"));
				board.setDowncount(rs.getInt("downcount"));
				board.setPass(rs.getString("pass"));
				board.setVisitcount(rs.getInt("visitcount"));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세 보기 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
//		가져온 데이터를 반환
		return board;
	}
	
//	게시물 수정
	
//	게시물 삭제
	
//	게시물 뷰 카운트 증가
	
//	다운로드 수 카운트 증가
	
//	비밀번호 확인

}







