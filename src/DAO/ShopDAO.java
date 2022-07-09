package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.MemberDTO;
import DTO.ReservationDTO;
import DTO.ShopDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.LoginDTO;

public class ShopDAO {

	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public ShopDAO() {
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
	// 정비소의 이름목록 출력
		public ArrayList<String> showshoplist() {
			ArrayList<String> shopList = new ArrayList<>();
			String sql = "select name FROM shop";
			try {
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					String list = rs.getString("name");
					shopList.add(list);
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
			return shopList;
		}
		// 테이블에서 샵목록보여줄거
		public ObservableList<ShopDTO> shopShow() {
			// 지점명을 가져오기위해서
			// 예약테이블과 샵테이블을 조인해서
			// 예약번호 예약일, 예약내용, 지점명을 가져옴
			String sql = "select * from shop";
			ObservableList<ShopDTO> list = FXCollections.observableArrayList();
			
			try {
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					ShopDTO dto = new ShopDTO();
					dto.setShop_name(rs.getString("name"));
					dto.setShop_id(rs.getString("id"));
					dto.setShop_pw(rs.getString("pw"));
					dto.setPhone_num(rs.getString("phonNum"));
					dto.setShop_location(rs.getString("location"));
					dto.setCeo_name(rs.getString("ceoName"));
					list.add(dto);
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
			return list;
		}
	
		public void delete(String id) {
			String sql = "DELETE FROM shop WHERE id =?";
			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
	
}
