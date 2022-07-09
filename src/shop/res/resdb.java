package shop.res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class resdb {
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
	
	public static ObservableList<shopRes> getdata(){
		Connection conn = ConnetDb();
		ObservableList<shopRes> list = FXCollections.observableArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement("select * from reservation");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new shopRes(rs.getInt("resNum"), rs.getString("reservationDate"), rs.getString("contents"), rs.getString("sNum")));
			System.out.println(rs.getInt("resNum"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
		
}

