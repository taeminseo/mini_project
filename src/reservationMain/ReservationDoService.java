package reservationMain;

import DAO.ReservationDAO;
import DTO.ReservationDTO;
import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ReservationDoService {
	
	
	//각 기능별 입력
	//예약정보 삽입
	public void resDoInsertProc(Parent resForm) {
//		ComboBox<String> shopCombo = (ComboBox<String>)resForm.lookup("#shopCombo");
//		ComboBox<String> contentCombo = (ComboBox<String>)resForm.lookup("#contentCombo");
//		DatePicker reservationdayCombo = (DatePicker) resForm.lookup("#reservationdayCombo");
//		
//		//받은 정보는 지점이름, 예약내용, 예약일
//		String shop_name = shopCombo.getValue();
//		String contents = contentCombo.getValue();
//		
//		// 이부분을 맞게 수정해야함 예약일을 어떻게할지
//		//String reservation_day = reservationdayCombo.getValue();
//		
//		ReservationDAO dao = new ReservationDAO();
//		ReservationDTO dto = new ReservationDTO();
//		
		// 이부분에 예약정보가 중복되는지 확인하는 코드(예약dao에 예약정보 조회하는 코드삽입)
		
		// 여유되면 삽입 성공/실패 확인용코드까지
//		int result = dao.insert(dto);
//		if(result ==0) CommonService.Msg("예약에 실패했습니다.");
//		else CommonService.Msg("예약에 실패했습니다.");
	}

	// 예약정보 수정
	public void resDoUpdateProc(Parent resForm) {
//		ComboBox<String> shopCombo = (ComboBox<String>)resForm.lookup("#shopCombo");
//		ComboBox<String> contentCombo = (ComboBox<String>)resForm.lookup("#contentCombo");
//		ComboBox<String> reservationdayCombo = (ComboBox<String>) resForm.lookup("#reservationdayCombo");
//		
//		//받은 정보는 지점이름, 예약내용, 예약일
//		String shop_name = shopCombo.getValue();
//		String contents = contentCombo.getValue();
//		String reservation_day = reservationdayCombo.getValue();
//		
//		ReservationDAO dao = new ReservationDAO();
//		ReservationDTO dto = new ReservationDTO();
//	
		// 여유되면 삽입 성공/실패 확인용코드까지
//		int result = dao.update(dto);
//		if(result ==0) CommonService.Msg("예약에 실패했습니다.");
//		else CommonService.Msg("예약에 실패했습니다.");
	}
//
	public void resDoDeleteProc() {
		
	}

	

	
	
}
