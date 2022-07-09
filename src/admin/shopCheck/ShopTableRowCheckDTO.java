package admin.shopCheck;

import javafx.beans.property.StringProperty;

public class ShopTableRowCheckDTO {
	String name;
	String id;
	String pw;
	String phonNum;
	String location;
	String ceoName;
	
	public ShopTableRowCheckDTO(String name, String id, String pw, String phonNum, String location, String ceoName) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phonNum = phonNum;
		this.location = location;
		this.ceoName = ceoName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhonNum() {
		return phonNum;
	}

	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
 
	
	
  

}
