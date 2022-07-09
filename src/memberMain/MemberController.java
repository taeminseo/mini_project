package memberMain;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.CheckDAO;
import DAO.ReservationDAO;
import DTO.CheckDTO;
import DTO.ReservationDTO;
import check.CheckController;
import common.CommonService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import login.LoginDTO;
import main.MainService;
import mypage.MypageController;
import reservationMain.ReservationController;

public class MemberController implements Initializable {
	
	private CommonService commonService;
	private MemberService memSvc;
	private Parent memberForm;
	private ReservationController resController;
	private MypageController myController;
	private CheckController checkController;
	//로그인세션을 유지하기위한 LoginDTO
	private LoginDTO login;
	
	@Override
	//시작하면 실행하는 함수
	public void initialize(URL location, ResourceBundle resources) {
		this.memSvc = new MemberService();
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

	public CheckController getCheckController() {
		return checkController;
	}

	public void setCheckController(CheckController checkController) {
		this.checkController = checkController;
	}

	// 예약컨트롤러 세터게터
	public ReservationController getResController() {
		return resController;
	}

	public void setResController(ReservationController resController) {
		this.resController = resController;
	}

	// 회원정보 컨트롤러 세터/게터	
	public MypageController getMyController() {
		return myController;
	}

	public void setMyController(MypageController myController) {
		this.myController = myController;
	}

	//화면 세터
	public void setMemberForm(Parent memberForm) {
		this.memberForm = memberForm;
	}
	
	public void logout() {
		memSvc.logout(memberForm);
	}

	// 예약하기 버튼 클릭시 호출
	public void resProc() {
		memSvc.resProc(getLogin());
	}
	
	// 진행사항 버튼 클릭시 호출
	public void checkProc() {
		memSvc.checkProc(getLogin());
	}
	
	// 회원정보수정 버튼 클릭시 호출
	public void mypageProc() {
		memSvc.mypageProc(memberForm,getLogin());
	}
	

	
	
	
}
