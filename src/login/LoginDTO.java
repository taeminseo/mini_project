package login;
/*
 * CREATE TABLE member (
mNum number PRIMARY KEY,
name varchar2(20),
id varchar2(20),
pw varchar2(20),
phonNum varchar2(20),
carNum varchar2(20),
carType varchar2(20)
);
 */
public class LoginDTO {
	private int member_num;
	private String id;
	private String pw;
	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
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
	
	
	
}
