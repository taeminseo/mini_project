package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import common.CommonService;
import main.Controller;

public class LoginController implements Initializable{

	private Parent loginForm;
	private LoginServiceImpl loginSvc;
	private Controller controller;
	
	public void setloginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.loginSvc = new LoginServiceImpl();
	}

	//로그인 버튼 클릭 시 호출
	public void loginProc() {
		LoginDTO loginDto = loginSvc.loginProc(loginForm);
		if(loginDto != null) {
			// 다음 화면을 실행
			CommonService.WindowClose(loginForm);
			controller.open(loginDto.getId());
		}
	}
	
	//취소 버튼 클릭 시 호출
	public void cancelProc() {
		loginSvc.cancelProc(loginForm);
	}
	
	//회원가입 버튼 클릭 시 호출
	public void regOpenProc() throws Exception  {
		controller.open("Register");
	}

}
