package admin.shopRegister;

import java.net.URL;
import java.util.ResourceBundle;

import admin.shopCheck.ShopCheckController;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ShopRegController implements Initializable{
	
	private Parent shopRegForm;
	private ShopRegService sRegSvc;
	private ShopCheckController shopCon;
	
	
	public ShopCheckController getShopCon() {
		return shopCon;
	}
	public void setShopCon(ShopCheckController shopCon) {
		this.shopCon = shopCon;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sRegSvc = new ShopRegService();
	}
	public void setShopRegForm(Parent shopRegForm) {
		this.shopRegForm = shopRegForm;
	}
	
	//등록
	public void shopRegProc() {
		System.out.println("등록버튼누름");
		sRegSvc.insert(shopRegForm);
	}
	
}
