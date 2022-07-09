package DTO;

public class CheckDTO {
	private int member_num;
	private int shop_num;
	private String check_day;
	private String car_sit;
	private String check_cost;
	private String shop_name;	//조인시 지점이름을 가져오기위해 사용
	
	
	public CheckDTO() {
		super();
	}
	// checkview를 위한 생성자
	public CheckDTO(String check_day, String car_sit, String check_cost, String shop_name) {
		super();
		this.check_day = check_day;
		this.car_sit = car_sit;
		this.check_cost = check_cost;
		this.shop_name = shop_name;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getCheck_day() {
		return check_day;
	}
	public void setCheck_day(String check_day) {
		this.check_day = check_day;
	}
	public String getCar_sit() {
		return car_sit;
	}
	public void setCar_sit(String car_sit) {
		this.car_sit = car_sit;
	}
	public String getCheck_cost() {
		return check_cost;
	}
	public void setCheck_cost(String check_cost) {
		this.check_cost = check_cost;
	}
	
	
}
