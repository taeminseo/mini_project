package admin.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import login.LoginServiceImpl;

public class adminController implements Initializable{
	private Parent adminMenu;
	private adminService adminSvc;
	private adminController adminController;
	private LoginServiceImpl loginSvc;
	private Parent loginForm;
	
	public void setAdminMenu(Parent adminMenu) {
		this.adminMenu = adminMenu;
	}
	public void setAdminController(adminController adminController) {
		this.adminController = adminController;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.adminSvc = (adminService) new adminService();
	}
	
	public void logOutProc()  {
		adminSvc.logOutProc(adminMenu);
		
	}
	
	public void memberInfo()  {
		adminSvc.memberInfo(adminMenu);
		
	}
	public void incomeInfo()  {
		adminSvc.incomeInfo(adminMenu);
		
	}
	public void shopInfo()  {
		adminSvc.shopInfo(adminMenu);
		
	}
	public void shopRegisterProc() {
		adminSvc.shopRegisterProc(adminMenu);
	}
	
}
