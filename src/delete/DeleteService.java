package delete;

import DAO.MemberDAO;
import DTO.MemberDTO;
import common.CommonService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class DeleteService {
	private String id;

	public String getId() {
		return id;
	}
	@FXML PasswordField pwText;
	@FXML PasswordField confirmText;
	
	//조회후 삭제. -- id 값 추가 show info로 보여주기
	//탈퇴하기 버튼을 누르면 회원 수정 페이지 삭제
	public void deleteProc(Parent deleteForm) {
		try {
			TextField idText = (TextField) deleteForm.lookup("#idText");
			PasswordField pwText = (PasswordField) deleteForm.lookup("#pwText");
			PasswordField confirmText = (PasswordField) deleteForm.lookup("#confirmText");
			
			String id = idText.getText();
			String pw = pwText.getText();
			String confirm = confirmText.getText();
			
			
			//회원 삭제를 위해서 필수 입력 데이터
			if(pw.isEmpty() || confirm.isEmpty()) {
				CommonService.Msg("필수로 입력해야하는 요소입니다.");
				return;
			}
			
			if(pw.equals(confirm)) {
				MemberDTO dto = new MemberDTO();
	    		MemberDAO dao = new MemberDAO();
	    		dto.setMember_id(id);
	    		
	    		dao.delete(dto);
	    		 
	    		
			    CommonService.Msg("탈퇴되었습니다");
			    CommonService.WindowClose(deleteForm);
			    
			    
			}else {
				CommonService.Msg("비밀번호를 확인해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
