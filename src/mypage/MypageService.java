package mypage;

import java.io.IOException;

import DAO.MemberDAO;
import DTO.MemberDTO;
import common.CommonService;
import delete.DeleteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.LoginDTO;

public class MypageService {
	//private Parent myForm;
	
	
	public void modifyProc(Parent myForm,LoginDTO login) {
				
			TextField nameText = (TextField) myForm.lookup("#nameText");
			PasswordField pwText = (PasswordField) myForm.lookup("#pwText");
			PasswordField confirmText = (PasswordField) myForm.lookup("#confirmText");
			TextField phoneNum = (TextField) myForm.lookup("#phoneNum");
			TextField carType = (TextField) myForm.lookup("#carType");
			TextField carNum = (TextField) myForm.lookup("#carNum");
			
			String name = nameText.getText();
			String pw = pwText.getText();
			String confirm = confirmText.getText();
			String phone = phoneNum.getText();
			String type = carType.getText();
			String cnum = carNum.getText();
			
			//패스워드와 패스워드 확인을 회원 정보할때 필수로 넣음.
			if(pw.isEmpty() || confirm.isEmpty()) {
				CommonService.Msg("필수로 입력해야하는 요소입니다.");
				return;
			}

			if(pw.equals(confirm)) {
				MemberDTO dto = new MemberDTO();
	    		MemberDAO dao = new MemberDAO();
	    		dto.setMember_name(name);
				dto.setMember_pw(pw);
			    dto.setMember_phone(phone);
			    dto.setMember_car(type);
			    dto.setMember_carNum(cnum);
			    
			    int result = dao.modify(dto, login);
			    
			    if(result == 1)
			    	CommonService.Msg("수정완료");
			}
			else {
				CommonService.Msg("비밀번호를 확인해주세요");
			}

	}

	public void deleteProc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/delete/deleteForm.fxml"));
		Parent deleteForm;
		try {
			deleteForm = loader.load();
			
			DeleteController del = loader.getController();
			del.setDeleteForm(deleteForm);
			
			Scene scene = new Scene(deleteForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("회원탈퇴");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}