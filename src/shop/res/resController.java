package shop.res;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shop.component.component;

import shop.main.shopController;
import shop.main.shopService;
import common.CommonService;
import login.LoginDTO;
import login.LoginServiceImpl;
import shop.res.resService;
import common.CommonService;
import main.Controller;
import reg.RegDAO;


// 컨트롤러들의 참조 값을 저장하는 기능.

public class resController implements Initializable {
	private Parent resForm;
	private resService resSvc;
	private resController resController;
	private Parent shopMenu;
	private shopService shopSvc;
	private shopController shopcontroller;
	private LoginDTO login;

	@FXML
	private TableView<shopRes> resView;
    @FXML
    private TableColumn<shopRes, String> resColumn,conColumn,carNColumn,resNumColumn;
    @FXML
    private TextField resDateTxt;
    @FXML
    private DatePicker resUpDate;
    @FXML
    private TextField carNumTxt;
    	
    ObservableList<shopRes> listR;
    
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int index = -1;
	
	
	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

	@FXML
	void getSelected (MouseEvent event) {
		index = resView.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
	
		resDateTxt.setText(resColumn.getCellData(index).toString());
//		resUpDate.setPromptText(resColumn.getCellData(index).toString());
		carNumTxt.setText(carNColumn.getCellData(index).toString());
		
		
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.resSvc = new resService();
		
		
	}

//	@FXML
//	public void showTableProc() {
//		resNumColumn.setCellValueFactory(new PropertyValueFactory<shopRes, String>("resNum"));
//		resColumn.setCellValueFactory(new PropertyValueFactory<shopRes, String>("reservationDate"));
//		conColumn.setCellValueFactory(new PropertyValueFactory<shopRes, String>("Contents"));
//		carNColumn.setCellValueFactory(new PropertyValueFactory<shopRes, String>("carNum"));
//		listR = RegDAO.getdata(login.getMember_num());
//		resView.setItems(listR);
//	}
//	@FXML
//	public void dateSelectProc(ActionEvent event){
//		String strDate = resUpDate.getValue().toString();
//		System.out.println(strDate);
//	}
//	
//	public void resUpdateProc()  {
//		
//		
//		listR = ResDAO.getdata(login.getMember_num());
//		
//		String value1 = resDateTxt.getText();
//		String strDate = resUpDate.getValue().toString();
//		String value3 = carNumTxt.getText();
//		
//		System.out.println(value1);
//		System.out.println(strDate);
//		System.out.println(value3);
//		
//		String sql = "update reservation set reservationDate = '"+strDate+"' where reservationDate = '"+value1+"'";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.execute();
//			CommonService.Msg("부품 수정");
//	
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	
	
}
