package shop.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import common.CommonService;
import login.LoginController;
import login.LoginDTO;
import shop.main.shopController;
import main.Controller;
import main.Main;
import main.MainService;

public class shopService implements IshopService  {
	// 로그아웃
	public  void logOutProc(Parent root) {
		CommonService.Msg("로그아웃하였습니다.");
		CommonService.WindowClose(root);
		
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
	public  void revationProc(Parent root) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/res/resForm.fxml"));
			Parent resForm;
			try {
				resForm = loader.load();
				
				Scene scene = new Scene(resForm);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("예약확인");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	public  void inspectProc(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/inspect/inspectForm.fxml"));
		Parent resForm;
		try {
			resForm = loader.load();

			Scene scene = new Scene(resForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("점검일지");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public  void componentProc(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/component/componentForm.fxml"));
		Parent resForm;
		try {
			resForm = loader.load();
		
			Scene scene = new Scene(resForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("재고확인");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	


}
