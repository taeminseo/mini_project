package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
	
	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public AdminDAO() {
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
	
	
}
