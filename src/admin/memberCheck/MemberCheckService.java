package admin.memberCheck;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MemberCheckService {
	
	//뒤로가기 버튼 클릭시 
	public void backProc(Parent MemberinfoForm) {
		CommonService.WindowClose(MemberinfoForm);
	}
	
	//회원 삭제 버튼 클릭시  -- onclick event 
	public void deleteProc(Parent MemberinfoForm) {
		
		CommonService.Msg("회원이 삭제되었습니다.");
	}
}
