package admin.shopRegister;

import common.CommonService;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShopRegService{

	public void insert(Parent shopRegForm) {
		System.out.println(shopRegForm);
		System.out.println("이름저장");
		TextField shopNameTxt = (TextField)shopRegForm.lookup("#shopNameTxt");
		System.out.println("이름저장값" + shopNameTxt.getText());
		System.out.println("아이디저장");
		TextField shopIdTxt = (TextField)shopRegForm.lookup("#shopIdTxt");
		System.out.println("아이디저장값" + shopIdTxt.getText());
		TextField shopPwTxt = (TextField)shopRegForm.lookup("#shopPwTxt");
		System.out.println("비밀번호저장");
		TextField shopPhonNumTxt = (TextField) shopRegForm.lookup("#shopPhonNumTxt");
		TextField shopLocationTxt = (TextField) shopRegForm.lookup("#shopLocationTxt");
		TextField shopCeoTxt = (TextField) shopRegForm.lookup("#shopCeoTxt");
		System.out.println("저장완료");
		
		String name = shopNameTxt.getText();
		String id = shopIdTxt.getText();
		String pw = shopPwTxt.getText();
		String phonNum = shopPhonNumTxt.getText();
		String location = shopLocationTxt.getText();
		String ceo = shopCeoTxt.getText();
		
		// 확인용코드
		System.out.println("name:" + name);
		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		System.out.println("phonNum:" + phonNum);
		System.out.println("location:" + location);
		System.out.println("ceo:" + ceo);
		
		if(name.isEmpty() || id.isEmpty() || pw.isEmpty()) {
			CommonService.Msg("필수 데이터 입니다.");
			return;
		}
		
		ShopRegDAO shopRegDao = new ShopRegDAO();
		ShopRegDTO shopRegDto = shopRegDao.SelectId(id);
		
		if(shopRegDto == null) {
			shopRegDto = new ShopRegDTO();
			shopRegDto.setSNum((shopRegDao.index()+1));
			shopRegDto.setName(name);
			shopRegDto.setId(id);
			shopRegDto.setPw(pw);
			shopRegDto.setPhonNum(phonNum);
			shopRegDto.setLocation(location);
			shopRegDto.setCeoName(ceo);
			
			shopRegDao.insert(shopRegDto);
			//회원번호 확인용코
			System.out.println("회원번호 : "+shopRegDao.index());
			CommonService.Msg(id+" 계정이 등록되었습니다.");
		}else {
			CommonService.Msg(id+"는/은 등록된 계정입니다.");
		}
	}

}
