package reservationMain;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import DAO.ReservationDAO;
import DTO.CheckDTO;
import DTO.ReservationDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import login.LoginDTO;
import main.Controller;

public class ReservationService{
	
	ReservationController resCon;
	
	ObservableList<ReservationDTO> resList;


	//예약일 입력
	public void reserveInsertProc(Parent resForm, LoginDTO login) {
		DatePicker d_resDayDate = (DatePicker)resForm.lookup("#d_resDayDate");
		TextField t_resNum = (TextField)resForm.lookup("#t_resNum");
		TextField t_resDay = (TextField)resForm.lookup("#t_resDay");
		ComboBox<String> c_shopName = (ComboBox<String>)resForm.lookup("#c_shopName");
		ComboBox<String> c_resCont = (ComboBox<String>)resForm.lookup("#c_resCont");
		//String resDayDate="변환ㄴ";

//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		String resDayDate = d_resDayDate.getValue().format(dateFormatter);
//		
//		System.out.println("날짜는: "+resDayDate);
		
		//.getYear();
//		String resDay = resCon.dateselectProc();
//		System.out.println("resDay:" + resDay);
		
//		String resDay = "20220203";
		String resDay = t_resDay.getText();
		String resCont = c_resCont.getValue();
//		Integer iresNum = Integer.parseInt(sresNum);
		String shopName = c_shopName.getValue();
		int memNum = login.getMember_num();
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setContents(resCont);
		dto.setReservation_day(resDay);
		dto.setShop_name(shopName);
		dto.setMember_num(memNum);
		
		// 테스트용코드
		System.out.println("예약 삽입 전 넘겨지는 값들");
		System.out.println("예약번호 : "+dto.getRes_num());
		System.out.println("멤버번호"+dto.getMember_num());
		System.out.println("예약일: "+dto.getReservation_day());
		System.out.println("예약내용: "+dto.getContents());
		
		
		
		ReservationDAO dao = new ReservationDAO();
		dao.insert(dto);
		
		
	}
	
	//예약일 수정
	public void reserveUpdateProc(Parent resForm, LoginDTO login, int rnum) {
		DatePicker d_resDayDate = (DatePicker)resForm.lookup("#d_resDayDate");
		TextField t_resDay = (TextField)resForm.lookup("#t_resDay");
		ComboBox<String> c_shopName = (ComboBox<String>)resForm.lookup("#c_shopName");
		ComboBox<String> c_resCont = (ComboBox<String>)resForm.lookup("#c_resCont");
//		String resDayDate="변환ㄴ";

//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		String resDayDate = d_resDayDate.getValue().format(dateFormatter);
//		
//		System.out.println("날짜는: "+resDayDate);
		
		//.getYear();
//		String resDay = d_resDayDate.getValue().toString();
//		System.out.println("resDay:" + resDay);
		
		String resDay = t_resDay.getText();
		String resCont = c_resCont.getValue();
		String shopName = c_shopName.getValue();
//		
		System.out.println("resDay : "+resDay);
		System.out.println("resCont : "+resCont);
		System.out.println("shopName : "+shopName);
//		String resCont = c_resCont.getSelectionModel().getSelectedItem().toString();
//		String shopName = c_shopName.getSelectionModel().getSelectedItem().toString();
//
		int memNum = login.getMember_num();
		
		
		ReservationDTO dto = new ReservationDTO();
//		
		dto.setContents(resCont);
		dto.setReservation_day(resDay);
		dto.setShop_name(shopName);
		dto.setMember_num(memNum);
		dto.setRes_num(rnum);
		
		// 테스트용코드
//		ReservationDTO dto = resDTO;
//		
		System.out.println("------예약 수정 전 넘겨지는 값들-----");
		System.out.println("예약번호 : "+dto.getRes_num());
		System.out.println("정비소이름"+dto.getShop_name());
		System.out.println("예약일: "+dto.getReservation_day());
		System.out.println("예약내용: "+dto.getContents());
		
		
		
		ReservationDAO dao = new ReservationDAO();
		if(dao.update(dto)==1) {
			System.out.println("변경완료");
		}
		else {
			System.out.println("변경실패");
		}
		
		
	}
	
	//예약일 삭제
	public void reserveDeleteProc(Parent resForm, LoginDTO login) {
		DatePicker d_resDayDate = (DatePicker)resForm.lookup("#d_resDayDate");
		TextField t_resNum = (TextField)resForm.lookup("#t_resNum");
		TextField t_resDay = (TextField)resForm.lookup("#t_resDay");
		ComboBox<String> c_shopName = (ComboBox<String>)resForm.lookup("#c_shopName");
		ComboBox<String> c_resCont = (ComboBox<String>)resForm.lookup("#c_resCont");
		//String resDayDate="변환ㄴ";

//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		String resDayDate = d_resDayDate.getValue().format(dateFormatter);
//		
//		System.out.println("날짜는: "+resDayDate);
		
		//.getYear();
//		String resDay = d_resDayDate.getValue().toString();
//		System.out.println("resDay:" + resDay);
		
		String resDay = t_resDay.getText();
		String resCont = c_resCont.getValue();
		String sresNum = t_resNum.getText();
		Integer iresNum = Integer.parseInt(sresNum);
		String shopName = c_shopName.getValue();
		int memNum = login.getMember_num();
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setContents(resCont);
		dto.setReservation_day(resDay);
		dto.setShop_name(shopName);
		dto.setMember_num(memNum);
		dto.setRes_num(iresNum);
		
		// 테스트용코드
		System.out.println("예약 수정 전 넘겨지는 값들");
		System.out.println("예약번호 : "+dto.getRes_num());
		System.out.println("멤버번호"+dto.getMember_num());
		System.out.println("예약일: "+dto.getReservation_day());
		System.out.println("예약내용: "+dto.getContents());
		
		
		
//		ReservationDAO dao = new ReservationDAO();
//		if(dao.delete(dto)==1) {
//			System.out.println("변경완료");
//		}
//		else {
//			System.out.println("변경실패");
//		}
//		
		
	}
//
//	public void dateselectProc() {
//		String resDay;
//		System.out.println("");
//	}

	


	
	public void resShowProc(Parent resForm, LoginDTO login) {
		ReservationDAO dao = new ReservationDAO();
	}

	
}
