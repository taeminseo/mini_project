package reg;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import common.CommonService;
import main.Controller;


	public class RegService {
		
		public void insert(Parent regForm) {
			
			TextField nameTxt = (TextField)regForm.lookup("#nameTxt");
			TextField idTxt = (TextField)regForm.lookup("#idTxt");
			PasswordField pwTxt = (PasswordField)regForm.lookup("#pwTxt");
			PasswordField confirmTxt = (PasswordField)regForm.lookup("#confirmTxt");
			TextField phonNumTxt = (TextField) regForm.lookup("#phonNum");
			TextField carNumTxt = (TextField) regForm.lookup("#carNum");
			TextField carTypeTxt = (TextField) regForm.lookup("#carType");
			
			
			String name = nameTxt.getText();
			String id = idTxt.getText();
			String pw = pwTxt.getText();
			String confirm = confirmTxt.getText();
			String phonNum = phonNumTxt.getText();
			String carNum = carNumTxt.getText();
			String carType = carTypeTxt.getText();
			
			//여기에 추가할 것은 아이디에 admin/shop을 넣지 못하게 막는 코드 넣기
			
			if(name.isEmpty() || id.isEmpty() || pw.isEmpty()) {
				CommonService.Msg("필수 데이터 입니다.");
				return;
			}
			if(id.length() < 6) {
				CommonService.Msg("아이디는 6글자 이상이어야합니다.");
				return;
			}

			if(id.substring(0, 4).equals("shop") || id.equals("admin") ) {
				CommonService.Msg("아이디에 shop / admin은 사용하지못합니다.");
				return;
			}
			// 회원번호 따오는것 삽입함
			if(pw.equals(confirm)) {
				RegDAO regDao = new RegDAO();
				RegDTO regDto = regDao.SelectId(id);
				
				if(regDto == null) {
					regDto = new RegDTO();
					regDto.setName(name);
					regDto.setId(id);
					regDto.setPw(pw);
					regDto.setPhonNum(phonNum);
					regDto.setCarNum(carNum);
					regDto.setCarType(carType);
					
					regDao.insert(regDto);
					//회원번호 확인용코
					System.out.println("회원번호 : "+regDao.index());
					CommonService.Msg(id+" 계정이 등록되었습니다.");
				}else {
					CommonService.Msg(id+"는/은 등록된 계정입니다.");
				}
			}else {
				CommonService.Msg("입력한 두 패스워드가 틀립니다.");
			}
			
		}
	}
