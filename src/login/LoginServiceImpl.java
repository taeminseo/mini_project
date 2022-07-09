package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import common.CommonService;
import main.Controller;
import reg.RegDTO;

public class LoginServiceImpl implements LoginService {

	// 로그인 버튼 클릭 시 호출
	public LoginDTO loginProc(Parent root) {
		TextField idText = (TextField) root.lookup("#idText");
		PasswordField pwText = (PasswordField) root.lookup("#pwText");
		System.out.println("아이디 : " + idText.getText());
		System.out.println("비밀번호 : " + pwText.getText());
		
		// 데이터베이스에 조회를 하여 정보를 검증함.
		LoginDAO loginDao = new LoginDAO();
		LoginDTO loginDto = loginDao.SelectId(idText.getText());
		// db가 가져오는 값 확인
		System.out.println("id : "+loginDto.getId());
		System.out.println("pw : "+loginDto.getPw());
		
		if(loginDto.getPw().equals(pwText.getText())) {
			// 로그인 성공
			return loginDto;
		}else {
			// 로그인 실패
			CommonService.Msg("로그인 실패");
			return null;
		}
		// 이거 해주는이유는 아마도 로그인정보를 받기위해서
	}

	// 취소 버튼 클릭 시 호출
	public void cancelProc(Parent root) {
		TextField idText = (TextField) root.lookup("#idText");
		PasswordField pwText = (PasswordField) root.lookup("#pwText");
		idText.clear();
		pwText.clear();
		idText.requestFocus();
	}




}
