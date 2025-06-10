package fileupload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnect;

public class MyFileDAO {
	
	//새로운 파일등록을 디비에 입력
	public int insertFile(MyFileDTO mfdto){
		String query="insert into myfile("
				+ "idx,title,cate,ofile,sfile) "
				+ "values(seq_board_num.nextval,?,?,?,?)";
		JDBConnect jdbc=new JDBConnect();
		int applyResult=0;
		try {
			PreparedStatement ps = jdbc.getCon().prepareStatement(query);
			ps.setString(1, mfdto.getTitle());
			ps.setString(2, mfdto.getCate());
			ps.setString(3, mfdto.getOfile());
			ps.setString(4, mfdto.getSfile());
			applyResult=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return applyResult;
	}
	
	//데이터 베이스 행 목록을 반환
	public List<MyFileDTO> getMyFiles() {
		List<MyFileDTO> mfdtos=new ArrayList<>();
		JDBConnect jdbc=new JDBConnect();
		//전체 목록 조회 쿼리(select 한정)
		String query=
			"select * from myfile order by idx desc";
		try {
			Statement sm=jdbc.getCon().createStatement();
			ResultSet rs=sm.executeQuery(query);
			while(rs.next()) {
				MyFileDTO mfdto=new MyFileDTO();
				mfdto.setIdx(rs.getString(1));
				mfdto.setTitle(rs.getString(2));
				mfdto.setCate(rs.getString(3));
				mfdto.setOfile(rs.getString(4));
				mfdto.setSfile(rs.getString(5));
				mfdto.setPostdate(rs.getDate(6));
				mfdtos.add(mfdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		
		return mfdtos;
	}

}











