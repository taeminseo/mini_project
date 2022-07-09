package reservationMain;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.MemberDAO;
import DAO.ReservationDAO;
import DTO.CheckDTO;
import DTO.ReservationDTO;
import common.CommonService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import login.LoginDTO;
import main.Controller;
import reg.RegService;

public class ReservationController implements Initializable{
	private Parent resForm;
	ReservationService resSvc;
	private Controller controller;
	private LoginDTO login;
	
	@FXML
	private TextField t_resNum, t_resDay;
	@FXML
	private TableView<ReservationDTO> tableView;
	@FXML
	private TableColumn<ReservationDTO, String> resDay,resCont,shopName;
	@FXML
	private TableColumn<ReservationDTO, Integer> res_num;
	
	@FXML
	private ComboBox<String> c_shopName, c_resCont,c_day;
	@FXML
	private DatePicker d_resDay;	
	
//	ReservationDAO dao = new ReservationDAO();
	ObservableList<ReservationDTO> resList;
	
	
	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
		System.out.println("저장된 로그인 아이디값 : "+login.getId());
		System.out.println("저장된 멤버id값 : "+login.getMember_num());
	}

	public void setResForm(Parent resForm) {
		this.resForm = resForm;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resSvc = new ReservationService();
	}
	
	
	
	// 예약하기
	public void resInsertProc() {
		resSvc.reserveInsertProc(resForm, login);
	}
	// 예약 수정
	public void resUpdateProc() {
		int nSel = selecttableView();
		int rnum = res_num.getCellData(nSel);
//		
//		String resCont = selectC_resCont();
//		String shopName = selectC_shopName();
//		String resDay = dateselectProc();
//		
//		System.out.println("---- dto 삽입전 ----");
//		System.out.println("예약번호 : "+rnum);
//		System.out.println("정비소이름"+shopName);
//		System.out.println("예약일: "+resDay);
//		System.out.println("예약내용: "+resCont);
//		
//		ReservationDTO dto  = new ReservationDTO();
//		
//		dto.setContents(resDay);
//		dto.setMember_num(login.getMember_num());
//		dto.setRes_num(rnum);
//		dto.setReservation_day(resDay);
//		dto.setShop_name(shopName);
//		
//
//		System.out.println("-----서비스 수행전----");
//		System.out.println("예약번호 : "+dto.getRes_num());
//		System.out.println("정비소이름"+dto.getShop_name());
//		System.out.println("예약일: "+dto.getReservation_day());
//		System.out.println("예약내용: "+dto.getContents());
//		
		resSvc.reserveUpdateProc(resForm, login, rnum);
	}
	// 예약 삭제
	public void resDeleteProc() {
		int nSel = selecttableView();
		int rnum = res_num.getCellData(nSel);
		ReservationDAO dao = new ReservationDAO();
		dao.delete(rnum);
		
		if(dao.delete(rnum)==1) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("삭제실패");
		}
		
	}
	//예약보기
	public void resShowProc() {
		if(getLogin().getId() == null)	System.out.println("로그인세션문제발생");
		else	System.out.println("로그인id값 : "+getLogin().getId());
		
		res_num.setCellValueFactory(new PropertyValueFactory<ReservationDTO,Integer>("res_num"));
		resDay.setCellValueFactory(new PropertyValueFactory<ReservationDTO,String>("reservation_day"));
		resCont.setCellValueFactory(new PropertyValueFactory<ReservationDTO,String>("contents"));
		shopName.setCellValueFactory(new PropertyValueFactory<ReservationDTO,String>("shop_name"));
		
		ReservationDAO dao = new ReservationDAO();
		resList = dao.showreservations(getLogin());
		System.out.println("--------------예약보기 버튼 클릭시-----------");

		tableView.setItems(resList);
	}
	
	//마우스로 테이블뷰 클릭했을시 보여주는 메소드
	@FXML
	public int selecttableView() {
		//MouseEvent event
    	int nSel = tableView.getSelectionModel().getSelectedIndex(); 
//    	
//		c_shopName.setValue(shopName.getCellData(nSel));
//		c_resCont.setValue(resCont.getCellData(nSel));
		
		return nSel;
    }
	
	@FXML
	public String dateselectProc(){
		//ActionEvent event
		String day = d_resDay.getValue().toString();
		t_resDay.setText(day);
		System.out.println(t_resDay.getText());
		
		return day;
	}
//	@FXML
//    String selectC_resCont(){
////		ActionEvent event
//		String rCont = null;
//    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
//    	// 방지 하기 위해서 예외를 설정 합니다.
//    	try {
//      		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
//        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
//    		rCont = c_resCont.getSelectionModel().getSelectedItem().toString();
//   
//    	}catch(Exception e) {
//    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
//    	}
//		System.out.println(rCont);
//    	
//    	return rCont;
//    }
//	@FXML
//    String selectC_shopName() {
//		String sName = null;
//    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
//    	// 방지 하기 위해서 예외를 설정 합니다.
//    	try {
//      		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
//        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
//    		sName = c_shopName.getSelectionModel().getSelectedItem().toString();
//   
//    	}catch(Exception e) {
//    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
//    	}
//    	System.out.println(sName);
//    	
//    	return sName;
//    }
	
	
	
}
