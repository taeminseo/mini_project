package mypage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import DTO.MemberDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.LoginDTO;

public class MypageController implements Initializable{
	private Parent myForm;
	private MypageService mySvc;
	private LoginDTO login;
	
	@FXML TextField nameText;
	@FXML PasswordField pwText;
	@FXML PasswordField confirmText;
	@FXML TextField phoneNum;
	@FXML TextField carType;
	@FXML TextField carNum;
	
	public LoginDTO getLogin() {
		return login;
	}


	public void setLogin(LoginDTO login) {
		this.login = login;
	}


	public void setmyForm(Parent myForm) {
		this.myForm = myForm;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mySvc = new MypageService();
//		showInfo();
	}
	
	public void modifyProc() {
		mySvc.modifyProc(myForm,login);
	}
	public void deleteProc() {
		mySvc.deleteProc();
	}
	
//	void showInfo() {
//		MemberDAO dao = new MemberDAO();
//		MemberDTO dto = dao.selectMember(login.getMember_num());
//		
//		nameText.setText(dto.getMember_name());
//		phoneNum.setText(dto.getMember_phone());
//		carType.setText(dto.getMember_car());
//		carNum.setText(dto.getMember_carNum());
//		
//	}
}
