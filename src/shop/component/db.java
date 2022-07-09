package shop.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class db {
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
	
	public static ObservableList<component> getdata(){
		Connection conn = ConnetDb();
		ObservableList<component> list = FXCollections.observableArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement("select * from component");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new component(rs.getInt("cNum"), rs.getString("name"), rs.getString("count"), rs.getString("cost"), rs.getInt("sNum")));
			System.out.println(rs.getString("cNum"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
		
}

