package main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import login.LoginDAO;
import login.LoginDTO;
import memberMain.MemberController;
import reservationMain.ReservationController;

public class MainService {
	private Controller controller;
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	// 회원메인창열기
	public void memberOpen(String id, LoginDTO login) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberMain/memberMenu.fxml"));
		Parent memeberMenu;
		try {
			memeberMenu = loader.load();
			
//			controller.setMemController(loader.getController());
//			controller.getMemController().setMemberForm(memeberMenu);

			MemberController mem= loader.getController();
			mem.setMemberForm(memeberMenu);
			mem.setLogin(login);
			LoginDTO dto = mem.getLogin();
			System.out.println("id : " + dto.getId());
			
			Stage stage = new Stage();
			stage.setScene(new Scene(memeberMenu));
			stage.setTitle("회원");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 회원가입창 열기
	public void regOpen(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/reg/regForm.fxml"));
		Parent regForm;
		try {
			regForm = loader.load();
			// 컨트롤러를 reg컨트롤러로 바꾸고
			// 화면을 레그화면으로바꿈
			controller.setRegController(loader.getController());
			controller.getRegController().setRegForm(regForm);
			System.out.println("resgopen : "+regForm);
			
			Scene scene = new Scene(regForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("회원가입");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	// 정비소화면열기
	public void shopOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/shopMenu.fxml"));
		Parent shopMenu;
		try {
			shopMenu = loader.load();
			

			controller.setShopController(loader.getController());
			controller.getShopController().setShopMenu(shopMenu);
	
			Stage stage = new Stage();
			stage.setScene(new Scene(shopMenu));
			stage.setTitle("정비소");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 관리자화면열기
	public void adminOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/AdminMainForm.fxml"));
		Parent adminMenu;
		try {
			adminMenu = loader.load();
			
			controller.setAdminController(loader.getController());
			controller.getAdminController().setAdminMenu(adminMenu);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(adminMenu));
			stage.setTitle("관리자");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// 이거 추가함 로그인세션유지위해서
	public LoginDTO loginsession(String id) {
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.SelectId(id);
		
		return dto;
	}
	
	
}
