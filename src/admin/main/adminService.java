package admin.main;

import java.io.IOException;

import admin.shopCheck.ShopCheckController;
import admin.shopRegister.ShopRegController;
import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adminService implements IadminService{

	@Override
	public  void logOutProc(Parent root) {
		CommonService.Msg("로그아웃되었습니다.");
		CommonService.WindowClose(root);
		
	}

	@Override
	public void memberInfo(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/memberCheck/MemberInfoForm.fxml"));
		Parent MemberInfoForm;
		try {
			MemberInfoForm = loader.load();
			
			Scene scene = new Scene(MemberInfoForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("회원 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void incomeInfo(Parent root) {
		System.out.println("income호출");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/income/IncomeMainForm.fxml"));
		Parent IncomeMainForm;
		try {
			IncomeMainForm = loader.load();
			
			Scene scene = new Scene(IncomeMainForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("수익 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void shopInfo(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/shopCheck/ShopInfoForm.fxml"));
		Parent ShopInfoForm;
		try {
			ShopInfoForm = loader.load();
			
			ShopCheckController check = loader.getController();
			check.setShopCheckForm(ShopInfoForm);
			
			Scene scene = new Scene(ShopInfoForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("정비소 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void shopRegisterProc(Parent root) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/shopRegister/ShopRegisterForm.fxml"));
		Parent ShopRegisterForm;
		try {
			ShopRegisterForm = loader.load();
			
			ShopRegController reg = loader.getController();
			reg.setShopRegForm(ShopRegisterForm);
			
			Scene scene = new Scene(ShopRegisterForm);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("정비소 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
