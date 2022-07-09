package memberMain;

import java.io.IOException;
import java.util.ArrayList;

import DAO.CheckDAO;
import DAO.MemberDAO;
import DAO.ReservationDAO;
import DAO.ShopDAO;
import DTO.CheckDTO;
import DTO.MemberDTO;
import DTO.ReservationDTO;
import check.CheckController;
import common.CommonService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginDTO;
import main.Controller;
import mypage.MypageController;
import reservationMain.ReservationController;

public class MemberService {	

	MemberController memController;
	Controller controller;
	CheckController checkController;
	
	
	public CheckController getCheckController() {
		return checkController;
	}

	public void setCheckController(CheckController checkController) {
		this.checkController = checkController;
	}

	// 예약하기 버튼 클릭시 호출
	// 예약하기 버튼을 클릭시 예약한 정보를 보여주기위해
	// DB에 접근해서 본인이 예약한 모든 정보를 보내준다
	public void resProc(LoginDTO dto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/reservationMain/reservationMain.fxml"));
		Parent resForm;
		try {
			resForm = loader.load();
			
			//다음화면으로 넘어가기 위해
			// 다음화면 컨트롤러에서 화면값이랑 로그인dto값을 세팅해줌
			ReservationController res= loader.getController();
			res.setResForm(resForm);
			res.setLogin(dto);
			
			// 다음화면의 콤보박스 2개의 리스트값을 세팅
			ComboBox<String> shopNameList = (ComboBox<String>)resForm.lookup("#c_shopName");
			ShopDAO dao = new ShopDAO();
			ArrayList<String>  list = dao.showshoplist();
			
			
			if(shopNameList != null) {
				for(String s: list) {
					shopNameList.getItems().add(s);
				}
			}
			
			ComboBox<String> resConList = (ComboBox<String>)resForm.lookup("#c_resCont");
			
			if(resConList != null) {
				resConList.getItems().addAll(
						"엔진오일교체",
						"에어컨필터",
						"타이어",
						"범퍼",
						"배터리교체",
						"브레이크패드",
						"문짝",
						"램프",	
						"사이드미러",
						"단순점검",
						"원인알수없음"
						);
			}
			
			
			// 화면표출
			Stage stage = new Stage();
			stage.setScene(new Scene(resForm));
			stage.setTitle("회원");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 진행사항 버튼 클릭시 호출
	public void checkProc(LoginDTO dto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/check/CheckForm.fxml"));
		Parent checkForm;
		try {
			checkForm = loader.load();
			
			// 다음화면 값 세팅
			CheckController check= loader.getController();
			check.setCheckForm(checkForm);
			check.setLogin(dto);
						
			
			Stage stage = new Stage();
			stage.setScene(new Scene(checkForm));
			stage.setTitle("점검");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 회원정보수정 버튼 클릭시 호출
	public void mypageProc(Parent root, LoginDTO login) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mypage/MypageForm.fxml"));
		Parent myForm;
		try {
			myForm = loader.load();
			
			// 다음 화면값 세팅
			MypageController mypage= loader.getController();
			mypage.setmyForm(myForm);
			mypage.setLogin(login);
			

			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.selectMember(login.getMember_num());
						
			
			TextField nameText = (TextField) myForm.lookup("#nameText");
			TextField phoneNum = (TextField) myForm.lookup("#phoneNum");
			TextField carType = (TextField) myForm.lookup("#carType");
			TextField carNum = (TextField) myForm.lookup("#carNum");
			
			nameText.setText(dto.getMember_name());
			phoneNum.setText(dto.getMember_phone());
			carType.setText(dto.getMember_car());
			carNum.setText(dto.getMember_carNum());
			// 확인용코드
//			System.out.println("login_id :" + dto.getId());s
			
			Stage stage = new Stage();
			stage.setScene(new Scene(myForm));
			stage.setTitle("회원");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	// 로그아웃부분
	public void logout(Parent parent) {
		CommonService.Msg("로그아웃되었습니다");
		CommonService.WindowClose(parent);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/loginForm.fxml"));
		
		Parent loginForm = null;
		
		try {
			loginForm = loader.load();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Controller controller = new Controller();
		
		// LoginController 인스턴스의 참조 값 입력
		controller.setLoginController(loader.getController());
		
		LoginController loginController = controller.getLoginController();
		loginController.setloginForm(loginForm);
		
		Stage stage = new Stage();
		stage.setScene(new Scene(loginForm));
		stage.setTitle("로그인");
		stage.show();
	}
	
}
