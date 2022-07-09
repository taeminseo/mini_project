package reg;

public class RegDTO {
	// 멤버넘버 추가함
	private int memeber_number;
	private String name;
	private String id;
	private String pw;
	private String phonNum;
	private String carNum;
	private String carType;
	
	// 멤버 게터/세터추가함
	public int getMemeber_number() {
		return memeber_number;
	}
	public void setMemeber_number(int memeber_number) {
		this.memeber_number = memeber_number;
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
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	
	
	
}
