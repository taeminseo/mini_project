package shop.main;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import shop.main.shopController;
import common.CommonService;
import login.LoginDTO;
import login.LoginServiceImpl;
import reg.RegController;
import shop.main.shopService;
import common.CommonService;
import main.Controller;

// 컨트롤러들의 참조 값을 저장하는 기능.

public class shopController implements Initializable {
	private Parent shopMenu;
	private shopService shopSvc;
	private shopController shopcontroller;
	private LoginServiceImpl loginSvc;
	private Parent loginForm;

	
	public void setShopMenu(Parent shopMenu) {
		this.shopMenu = shopMenu;
	}
	
	public void setShopController(shopController shopController) {
		this.shopcontroller = shopController;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.shopSvc = (shopService) new shopService();
	}
	
	public void logOutProc()  {
		shopSvc.logOutProc(shopMenu);
		
	}
	
	public void revationProc()  {
		shopSvc.revationProc(shopMenu);
		
	}
	public void inspectProc()  {
		shopSvc.inspectProc(shopMenu);
		
	}
	public void componentProc()  {
		shopSvc.componentProc(shopMenu);
		
	}

	

	
}
