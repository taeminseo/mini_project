package shop.inspect;

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

public class insService implements IinsService  {

	
	public void progressProc(Parent root) {
		
	}


	public void checkLogProc(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/checkLog/checkLog.fxml"));
		Parent checkLog;
		try {
			checkLog = loader.load();
			
			Scene scene = new Scene(checkLog);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("점검 일지");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	public void endProc(Parent root) {
		// TODO Auto-generated method stub
		
	}


	

}
