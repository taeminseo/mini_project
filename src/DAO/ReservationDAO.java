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

public class ReservationDAO {

	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public ReservationDAO() {
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
	
	
	
	// Service에서 예약번호를 자동으로 1증가 시키는 메소드필요함!! (구현해야함)
	public int insert(ReservationDTO reservation) {
		int result = 0;
		String sql = "INSERT INTO reservation(mNum, resNum, reservationDate, Contents ,sNum) VALUES( ?, ?, ?, ?,(select snum from shop where name = ?))";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservation.getMember_num());
			ps.setInt(2, index());
			ps.setString(3, reservation.getReservation_day());
			ps.setString(4, reservation.getContents());
			ps.setString(5, reservation.getShop_name());
			
			System.out.println("===예약삽입실행======");
			System.out.println("예약번호 : " + reservation.getRes_num());
			System.out.println("회원번호 : " + reservation.getMember_num());
			System.out.println("정비소이름 : " + reservation.getShop_name());
			result = ps.executeUpdate(); 
			

			System.out.println("===예약삽입실행후======");
			System.out.println("예약번호 : " + reservation.getRes_num());
			System.out.println("회원번호 : " + reservation.getMember_num());
			System.out.println("샵번호번호 : " + reservation.getShop_num());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 예약정보 수정
	// 이쪽은 책보고 제대로 했는지 확인하기
	// 지점이름을 가지고 지점번호를 찾는 함수 구현해야함
	public int update(ReservationDTO reservation) {
		String sql = "update reservation set reservationDate=?, snum = ("
				+ "select snum from shop where name = ?), Contents=? where resnum = ?";
		
		int result=0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reservation.getReservation_day());
			ps.setString(2, reservation.getShop_name());
			ps.setString(3, reservation.getContents());
			ps.setInt(4, reservation.getRes_num());
			result = ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	//예약취소시 관련된 정보를 DB에서 삭제
	public int delete(int res_num) {
		String sql = "delete FROM reservation WHERE resNum=?";
		System.out.println("삭제할 예약번호 : "+res_num);
		int result = 0;
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, res_num);
			result = ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 예약화면에서 보여줄 예약내용
	// 일단은 확인하기위해 예약번호를 가져오는걸로 구현을해놓을거 나중에 수정
	// 예약조회
	public ObservableList<ReservationDTO> showreservations(LoginDTO reservation) {
		// 지점명을 가져오기위해서
		// 예약테이블과 샵테이블을 조인해서
		// 예약번호 예약일, 예약내용, 지점명을 가져옴
		String sql = "select r.reservationDate , r.Contents , s.name, r.resNum FROM reservation r, shop s WHERE mNum  = ? and r.sNum = s.snum";
		ObservableList<ReservationDTO> list = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			int mNum = reservation.getMember_num();
			ps.setInt(1,mNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationDTO dto = new ReservationDTO();
				dto.setReservation_day(rs.getString("reservationDate"));
				dto.setContents(rs.getString("Contents"));
				dto.setShop_name(rs.getString("name"));
				dto.setRes_num(rs.getInt("resNum"));
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
	
	//예약 따오는 메소드
	public int index() {
		String sql = "SELECT max(resNum) FROM reservation";
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
		mnum+=1;
		return mnum;
	}
	
}
