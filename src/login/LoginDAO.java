package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	private Connection con;
	public LoginDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 실행되는지 확인용
		System.out.println("logindao실행");
	}
	
	
	public LoginDTO SelectId(String id) {
		
		// 실행되는지 확인용
		System.out.println("db쿼리문 실행");
		//회원테이블에서 검색

		LoginDTO loginDto = new LoginDTO();
		
		// member테이블에서 검색
		String sql1 = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {

				//LoginDTO loginDto = new LoginDTO();
				
				loginDto.setId(rs.getString("id"));
				loginDto.setPw(rs.getString("pw"));
				loginDto.setMember_num(rs.getInt("mnum"));
				
				//return loginDto;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		// shop테이블에서 검색
		String sql2 = "SELECT * FROM shop WHERE id=?";
		
		try {
			ps = con.prepareStatement(sql2);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {

				//LoginDTO loginDto = new LoginDTO();
				
				loginDto.setId(rs.getString("id"));
				loginDto.setPw(rs.getString("pw"));
				loginDto.setMember_num(rs.getInt("snum"));
				
				//return loginDto;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}		
		// admin테이블에서 검색
		String sql3 = "SELECT * FROM admin WHERE id=?";
		
		try {
			ps = con.prepareStatement(sql3);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {

				//LoginDTO loginDto = new LoginDTO();
				
				loginDto.setId(rs.getString("id"));
				loginDto.setPw(rs.getString("pw"));
				loginDto.setMember_num(rs.getInt("anum"));
				
				//return loginDto;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}	
		
		return loginDto;

	}
}

