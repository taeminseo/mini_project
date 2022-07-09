package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CheckDTO;
import DTO.ReservationDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.LoginDTO;

public class CheckDAO {

	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public CheckDAO() {
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
	
	// 고객이 확인하는 점검내용보여주기
	public ObservableList<CheckDTO> showchecks(LoginDTO login) {
		// 지점명을 가져오기위해서
		// 점검테이블과 샵테이블을 조인해서
		// 점검일자, 점검내용, 점검비용, 정비소이름을 가져옴
		String sql = "select r.reservationDate, r.sit, r.cost, s.name FROM reservation r, shop s WHERE mNum = ? and r.sNum  = s.snum";
		ObservableList<CheckDTO> checkList= FXCollections.observableArrayList();
		try {
			ps = con.prepareStatement(sql);
			// setInt이부분도 나중에 로그인세션 유지해서
			// 회원num로 가져오기
			ps.setInt(1, login.getMember_num());
			System.out.println("여기서 출력되는 mnum값"+login.getMember_num());
			rs = ps.executeQuery();
			while(rs.next()) {
				CheckDTO dto = new CheckDTO();
				dto.setCheck_day(rs.getString("reservationDate"));
				dto.setCar_sit(rs.getString("sit"));
				dto.setCheck_cost(rs.getString("cost"));
				dto.setShop_name(rs.getString("name"));
				checkList.add(dto);
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
		return checkList;
	}
	
}
