package reservationMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ReservationDoController implements Initializable{

	private Parent resForm;
	private ReservationDoService resDoSvc;
	
	
	public void setRegForm(Parent resForm) {
		this.resForm = resForm;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resDoSvc = new ReservationDoService();
		
	}
	
	//각 기능별 입력
	
	// 버튼누르면 삽입
	void resDoInsertProc() {
		resDoSvc.resDoInsertProc(resForm);
	}
	// 버튼누르면 수정
	void resDoUpdateProc() {
		resDoSvc.resDoUpdateProc(resForm);
	}
	//버튼누르면 삭제
	void resDoDeleteProc() {
		resDoSvc.resDoDeleteProc();
	}

	
}
