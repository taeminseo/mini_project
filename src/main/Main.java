package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/loginForm.fxml"));
		
		Parent loginForm = null;
		
		try {
			loginForm = loader.load();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Controller controller = new Controller();
		controller.setLoginController(loader.getController());
		
		LoginController loginController = controller.getLoginController();
		loginController.setloginForm(loginForm);

		Scene scene = new Scene(loginForm);
		primaryStage.setTitle("loginForm");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
