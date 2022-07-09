package admin.memberCheck;

public class MemberTableRowDataModel {
		private String name;
		private String id;
		private String pw;
		private String phoneNum;
	    private String carNum;
	    private String car;
	 
	    public MemberTableRowDataModel(String name, String id, String pw,String phoneNum,String carNum,String car) {
	    	super();
	    	this.name=name;
	    	this.id=id;
	    	this.pw=pw;
	    	this.phoneNum=phoneNum;
	    	this.carNum=carNum;
	    	this.car=car;
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

		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}

		public String getCarNum() {
			return carNum;
		}

		public void setCarNum(String carNum) {
			this.carNum = carNum;
		}

		public String getCar() {
			return car;
		}

		public void setCar(String car) {
			this.car = car;
		}
	    
	   
	   
	}

