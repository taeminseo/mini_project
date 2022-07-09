package reg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.MemberDTO;
import login.LoginDTO;

public class RegDAO {
	private Connection con;
	public RegDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//회원번호 따오는 메소드
	public int index() {
		String sql = "SELECT max(mnum) FROM member";
		PreparedStatement ps;
		ResultSet rs;
		
		int mnum = 0;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				mnum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mnum;
	}
	
	public RegDTO SelectId(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				RegDTO regDto = new RegDTO();
				
				regDto.setName(rs.getString("name"));
				regDto.setId(rs.getString("id"));
				regDto.setPw(rs.getString("pw"));
				regDto.setPhonNum(rs.getString("phonNum"));
				regDto.setCarNum(rs.getString("carNum"));
				regDto.setCarType(rs.getString("carType"));
				return regDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(RegDTO regDto) {
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, index() + 1);
			ps.setString(2, regDto.getName());
			ps.setString(3, regDto.getId());
			ps.setString(4, regDto.getPw());
			ps.setString(5, regDto.getPhonNum());
			ps.setString(6, regDto.getCarNum());
			ps.setString(7, regDto.getCarType());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
