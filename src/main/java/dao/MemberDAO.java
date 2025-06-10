package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBConnect;
import dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO getMembers(String uid,String upass) {
		JDBConnect jdbc=new JDBConnect();
		MemberDTO md=new MemberDTO();
		String query="select * from member "
			+ "where id=? and pass=?";
		try {
			PreparedStatement ps=
				jdbc.getCon().prepareStatement(query);
			ps.setString(1, uid);
			ps.setString(2, upass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				md.setId(rs.getString("id"));
				md.setPass(rs.getString("pass"));
				md.setName(rs.getString(3));
				md.setRegdate(rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return md;
	}

}





