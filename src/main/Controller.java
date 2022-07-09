package main;


import javafx.scene.Parent;
import login.LoginController;
import login.LoginDAO;
import login.LoginDTO;
import memberMain.MemberController;
import reg.RegController;
import shop.main.shopController;
import admin.main.adminController;
// 컨트롤러들의 참조 값을 저장하는 기능.

public class Controller {
	private LoginController loginController;
	private RegController regController;
	private shopController shopController;
	private adminController adminController;
	private MainService mainService;
	private MemberController memController;
	private Parent memeberMenu;
	private Parent shopMenu;
	private Parent adminMenu;
	
	public Controller() {
		mainService = new MainService();
		mainService.setController(this);
	}
	
	public void setmemeberMenu(Parent memeberMenu) {
		this.memeberMenu = memeberMenu;
	}
	public void setShopMenu(Parent shopMenu) {
		this.shopMenu = shopMenu;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
		this.loginController.setController(this);
	}
	
	public LoginController getLoginController() {
		return loginController;
	}
	
	public void setRegController(RegController regController) {
		this.regController = regController;
	}
	public RegController getRegController() {
		return regController;
	}
	
	
	
	public MemberController getMemController() {
		return memController;
	}

	public void setMemController(MemberController memController) {
		this.memController = memController;
	}

	public shopController getShopController() {
		return shopController;
	}

	public void setShopController(shopController shopController) {
		this.shopController = shopController;
	}
	

	public adminController getAdminController() {
		return adminController;
	}

	public void setAdminController(adminController adminController) {
		this.adminController = adminController;
	}

	public Parent getAdminMenu() {
		return adminMenu;
	}

	public void setAdminMenu(Parent adminMenu) {
		this.adminMenu = adminMenu;
	}

	public void open(String division) {
		if(division.equals("Register")) {
			mainService.regOpen();
		}
		else if(division.equals("admin")) {
			mainService.adminOpen();
			System.out.println("관리자페이지로이동");
		}
		// 여기서 수정해야할 것은
		// id에서 4글짜 shop으로하는거
		else if(division.substring(0,4).equals("shop")) {
			mainService.shopOpen();
			System.out.println("정비소페이지로이동");
		}
		else {
			mainService.memberOpen(division, loginsession(division));
			System.out.println("회원페이지로이동");
		}
		
	}
	// 이거 추가함 로그인세션유지위해서
	// 이건 삭제할수도있음
	public LoginDTO loginsession(String id) {
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.SelectId(id);
		
		return dto;
	}
	
}
