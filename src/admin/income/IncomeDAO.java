package admin.income;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IncomeDAO {
	
	// DB연결과 결과출력에 필요한 변수들
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 선언과 동시에 생성자를 이용해서 디비에 연결
	public IncomeDAO() {
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
	
	public ObservableList<IncomeDTO> showIncome() {
		System.out.println("---income접근 --- ");
		ObservableList<IncomeDTO> list = FXCollections.observableArrayList();
		String sql = "select s.snum, s.name, count(*) as count, sum(cost) as income from reservation r, shop s where r.snum = s.snum group by s.snum,s.name order by snum, name";
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				IncomeDTO dto = new IncomeDTO();
				dto.setShop_name(rs.getString("name"));
				dto.setCount(rs.getInt("count"));
				dto.setIncome(rs.getInt("income"));
				dto.setLee_ik((int)(rs.getInt("income")*0.1));
				list.add(dto);
				
				System.out.println("------반환되는값은----");
				System.out.println("지점번호 : "+dto.getShop_num());
				System.out.println("총 수 : "+dto.getCount());
				System.out.println("총 수입 : "+dto.getIncome());
				System.out.println("총 수입 : "+dto.getLee_ik());
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
}
