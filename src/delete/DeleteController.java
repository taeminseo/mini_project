package delete;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import DTO.MemberDTO;
import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mypage.MypageService;


public class DeleteController implements Initializable {
	private Parent deleteForm;
	private DeleteService deleteSvc;
	
	@FXML TextField idText;
	@FXML PasswordField pwText;
	@FXML PasswordField confirmText;
	
	public void setDeleteForm(Parent deleteForm) {
		this.deleteForm = deleteForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		deleteSvc = new DeleteService();
		
	}
	
	public void deleteProc() {
		deleteSvc.deleteProc(deleteForm);
		showInfo();
	}
	
	//select member id 출력
	void showInfo() {
		MemberDAO dao = new MemberDAO();
//		MemberDTO dto = dao.selectMember();
		
//		idText.setText(dto.getMember_id());
		
	}
}
