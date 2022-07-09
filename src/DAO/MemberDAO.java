package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ComponentDTO;
import DTO.MemberDTO;
import DTO.ReservationDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.LoginDTO;
import DTO.ComponentDTO;
import DTO.MemberDTO;
import DTO.ReservationDTO;
import login.LoginDTO;

public class MemberDAO {

	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public MemberDAO() {
		System.out.println("멤버다오생성자호출");
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
	public MemberDTO selectMember(int mnum) {
		String sql = "select name,id,pw,phonnum,carnum,cartype FROM member WHERE mnum = ?";
		MemberDTO dto = new MemberDTO();
		try {
			ps = con.prepareStatement(sql);
			// 테스트용코드
			// 나중에 로그인dto를 유지해서
			// 로그인dto의 회원번호를 받아와서 출력하도록
			ps.setInt(1,mnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				// 회원번호는 로그인 dto에서 받아와서
				//dto.setMember_num(logintDTO.getMember_num);
				dto.setMember_name(rs.getString("name"));
				System.out.println(rs.getString("name"));
				dto.setMember_id(rs.getString("id"));
				dto.setMember_pw(rs.getString("pw"));
				dto.setMember_phone(rs.getString("phonnum"));
				dto.setMember_carNum(rs.getString("carnum"));
				dto.setMember_car(rs.getString("cartype"));
				
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
		
		return dto;
	}
	//회원 수정
	public int modify(MemberDTO dto, LoginDTO login) {
		
		String sql = "UPDATE member SET name=?,pw=?,phonNum=?,carnum=?,cartype=? WHERE mNum  =?";
		PreparedStatement ps;
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getMember_name());
			ps.setString(2, dto.getMember_pw());
			ps.setString(3, dto.getMember_phone());
			ps.setString(4, dto.getMember_carNum());
			ps.setString(5, dto.getMember_car());
			ps.setInt(6,login.getMember_num());
			result = ps.executeUpdate();
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 회원삭제
	public MemberDTO delete(MemberDTO dto) {
		String sql = "DELETE FROM member WHERE id =?";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMember_id());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 관리자에서 사용하는 회원삭제
		public void delete(String id) {
			String sql = "DELETE FROM member WHERE id =?";
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
	
	//관리자 -회원조회에서사용
	public ObservableList<MemberDTO> showreservations() {
		System.out.println("---memberdao접근 --- ");
		ObservableList<MemberDTO> members = FXCollections.observableArrayList();
		String sql = "select name,id,pw,phonnum,carnum,cartype FROM member";
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMember_name(rs.getString("name"));
				dto.setMember_id(rs.getString("id"));
				dto.setMember_pw(rs.getString("pw"));
				dto.setMember_phone(rs.getString("phonnum"));
				dto.setMember_carNum(rs.getString("carnum"));
				dto.setMember_car(rs.getString("cartype"));
				members.add(dto);
				
				System.out.println("------반환되는값은----");
				System.out.println("멤버이름 : "+dto.getMember_name());
				System.out.println("멤버id : "+dto.getMember_id());
				System.out.println("멤버pw : "+dto.getMember_pw());
				System.out.println("전화번호 : "+dto.getMember_phone());
				System.out.println("차번호 : "+dto.getMember_carNum());
				System.out.println("차종 : "+dto.getMember_car());
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
		return members;
	}
	
	public int index() {
		String sql = "SELECT max(mnum) FROM member";
		PreparedStatement ps;
		ResultSet rs;
		
		int num = 0;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		num+=1;
		return num;
	}
	public static Connection ConnetDb() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "oracle";
		String pass = "oracle";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
	
		}
	}
	//관리자페이지에서 관리자 테이블뷰에 보여줄 데이터 가져오는함수
	public ObservableList<MemberDTO> getMemberAll(){
		ObservableList<MemberDTO> list = FXCollections.observableArrayList();
		String sql = "select name,id,pw,phone,carnum,cartype FROM member";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMember_name(rs.getString("name"));
				dto.setMember_id(rs.getString("id"));
				dto.setMember_pw(rs.getString("pw"));
				dto.setMember_phone(rs.getString("phonnum"));
				dto.setMember_carNum(rs.getString("carnum"));
				dto.setMember_car(rs.getString("cartype"));;
				list.add(dto);
				
				System.out.println("---- 관리자페이지 멤버받아오는 함수호출 ----");
				System.out.println("이름: " +dto.getMember_name());
				System.out.println("id: " +dto.getMember_id());
				System.out.println("pw: " +dto.getMember_pw());
				System.out.println("전화번호: " +dto.getMember_phone());
				System.out.println("카넘버: " +dto.getMember_carNum());
				System.out.println("카종류: " +dto.getMember_car());
				System.out.println("----------ado합수 종료----------");
			}
				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	
	}
	
}
