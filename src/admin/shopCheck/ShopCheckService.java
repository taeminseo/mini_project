package admin.shopCheck;

import java.io.IOException;

import DTO.ShopDTO;
import admin.shopRegister.ShopRegController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShopCheckService {

	public void insertShopProc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/shopRegister/ShopRegisterForm.fxml"));
		Parent shopRegForm;
		try {
			shopRegForm = loader.load();
			
			ShopRegController shop = loader.getController();
			shop.setShopRegForm(shopRegForm);
			
			Scene scene = new Scene(shopRegForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("정비소정보등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
//	private ShopCheckController shopCheckController;
//	
//	public void setShopCheckController(ShopCheckController shopCheckController) {
//		this.shopCheckController = shopCheckController;
//	}
	
	
}
