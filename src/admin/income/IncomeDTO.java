package admin.income;

public class IncomeDTO {
	private int shop_num;
	private String shop_name;
	private int income;
	private int count;
	private int lee_ik;
	
	public int getLee_ik() {
		return lee_ik;
	}
	public void setLee_ik(int lee_ik) {
		this.lee_ik = lee_ik;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

	
}
