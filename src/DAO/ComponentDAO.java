package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ComponentDTO;
import DTO.ReservationDTO;

public class ComponentDAO {

	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public ComponentDAO() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "oracle";
		String pass = "oracle";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 부품조회에서 사용
	public ArrayList<ComponentDTO> showreservations() {
		ArrayList<ComponentDTO> components = new ArrayList<>();
		// 지점명을 가져오기위해서
		// 부붐테이블과 샵테이블을 조인해서
		// 부품번호, 부품이름, 부품갯수, 부품가격,정비소이름을 가져옴
		//String sql = "select reservationDate , Contents , name FROM reservation, shop WHERE num = ? and check.shop = shop.snum";
		String sql = "select c.cNum , c.name  , c.count  , c.cost   , s.name FROM component c, shop s WHERE c.shop = s.snum";

		try {
			ps = con.prepareStatement(sql);
			// 테스트용코드
			// 나중에 로그인dto를 유지해서
			// 로그인dto의 회원번호를 받아와서 출력하도록
			ps.setInt(1,1);
			rs = ps.executeQuery();
			while(rs.next()) {
				ComponentDTO dto = new ComponentDTO();
				dto.setComponent_num(rs.getInt("cNum"));
				dto.setComponent_name(rs.getString("name"));
				dto.setComponent_count(rs.getString("count"));
				dto.setComponent_cost(rs.getString("cost"));
				dto.setShop_name(rs.getString("name"));
				components.add(dto);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null) 
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return components;
	}
	
}
