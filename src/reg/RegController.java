	package reg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import common.CommonService;

public class RegController implements Initializable{
	private Parent regForm;
	private RegService regService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regService = new RegService();
	}
	
	public void setRegForm(Parent regForm) {
		this.regForm = regForm;
	}
	
	// 회원 가입 버튼 클릭 시 동작.
	public void regProc() {
		regService.insert(regForm);
	}
	
	// 취소 버튼 클릭 시 동작.
	public void regCancelProc() {
		CommonService.WindowClose(regForm);
	}
}
