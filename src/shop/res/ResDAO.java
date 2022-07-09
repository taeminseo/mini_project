package shop.res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResDAO {
	Connection conn = null;
	
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
	
	public static ObservableList<shopRes> getdata(int snum){
		Connection conn = ConnetDb();
		ObservableList<shopRes> list = FXCollections.observableArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement("select * from reservation r, member m where r.mnum = m.mnum and r.snum= ?");
			System.out.println("----shopdao----");
			System.out.println("sunm : "+snum);
			ps.setInt(1, snum);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				shopRes dto = new shopRes(rs.getInt("resNum"),
						rs.getString("reservationDate"),
						rs.getString("contents"),
						rs.getString("carNum"));
				
				System.out.println("----dto값 저장하기전 ----");
				System.out.println("예약번호 : " + dto.getResNum());
				System.out.println("예약번호 : " + dto.getReservationDate());
				System.out.println("예약번호 : " + dto.getContents());
				System.out.println("예약번호 : " + dto.getCarNum());
				list.add(dto);
			System.out.println(rs.getInt("resNum"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
		
}

