package admin.shopRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopRegDAO {
	private Connection con;
	public ShopRegDAO() {
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
	
	public int index() {
		String sql = "SELECT max(snum) FROM shop";
		PreparedStatement ps;
		ResultSet rs;
		
		int snum = 0;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				snum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("인덱스값은 : "+snum);
		return snum;
	}
	
	public ShopRegDTO SelectId(String id) {
		String sql = "SELECT * FROM shop WHERE id=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				ShopRegDTO shopRegDto = new ShopRegDTO();
				
				shopRegDto.setSNum(rs.getInt("sNum"));
				shopRegDto.setName(rs.getString("name"));
				shopRegDto.setId(rs.getString("id"));
				shopRegDto.setPw(rs.getString("pw"));
				shopRegDto.setPhonNum(rs.getString("phonNum"));
				shopRegDto.setLocation(rs.getString("location"));
				shopRegDto.setCeoName(rs.getString("ceoName"));
				return shopRegDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(ShopRegDTO shopRegDto) {
		String sql = "INSERT INTO shop VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shopRegDto.getSNum());
			ps.setString(2, shopRegDto.getName());
			ps.setString(3, shopRegDto.getId());
			ps.setString(4, shopRegDto.getPw());
			ps.setString(5, shopRegDto.getPhonNum());
			ps.setString(6, shopRegDto.getLocation());
			ps.setString(7, shopRegDto.getCeoName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("insert함수 실행하면서 인덱스값"+(index()+1));
		
		return result;
	}
}
