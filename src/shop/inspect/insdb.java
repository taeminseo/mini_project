package shop.inspect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class insdb {
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
	
	public static ObservableList<inspect> getdata(){
		Connection conn = ConnetDb();
		ObservableList<inspect> list = FXCollections.observableArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement("\r\n"
					+ "select r.Mnum,\r\n"
					+ "r.resNum,\r\n"
					+ "r.reservationDate,\r\n"
					+ "r.contents,\r\n"
					+ "r.sit,\r\n"
					+ "r.cost,\r\n"
					+ "r.note,\r\n"
					+ "r.sNum,\r\n"
					+ "m.carNum \r\n"
					+ "from reservation r, member m \r\n"
					+ "where r.mNum = m.mNum");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new inspect(rs.getInt("mNum"), rs.getInt("resNum"), rs.getString("reservationDate"), rs.getString("contents"), rs.getString("sit"), rs.getInt("cost"), rs.getString("note"), rs.getInt("sNum"), rs.getString("carNum")));
				//(new inspect(rs.getString("reservationDate"),rs.getInt("resNum"), rs.getString("contents"), rs.getString("carNum"), rs.getString("sit"), rs.getInt("cost"), rs.getString("note")));
			System.out.println(rs.getString("carNum"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
		
}

