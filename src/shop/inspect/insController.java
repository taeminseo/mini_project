package shop.inspect;


import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shop.component.component;
import shop.component.db;
import shop.main.shopController;
import common.CommonService;
import login.LoginDTO;
import login.LoginServiceImpl;
import shop.res.resService;
import shop.res.resdb;
import shop.res.shopRes;
import common.CommonService;
import main.Controller;

// 컨트롤러들의 참조 값을 저장하는 기능.

public class insController implements Initializable {
	private Parent inspectForm;
	private insService insSvc;
	private insController insController;
	private LoginServiceImpl loginSvc;
	private Parent loginForm;

	
	@FXML
    private TableView<inspect> reservationLog;

    @FXML
    private TableColumn<inspect, Integer> resNumColumn;

    @FXML
    private TableColumn<inspect, String> checkDayColumn;

    @FXML
    private TableColumn<inspect, String> sitColumn;

    @FXML
    private TableColumn<inspect, String> carNumColumn;

    @FXML
    private TableColumn<inspect, Integer> costCheckColumn;

    @FXML
    private TableColumn<inspect, String> noteColumn;
    
    @FXML
    public ComboBox<String> combobox;
    
    @FXML
    private TextField resNumTxt;

    @FXML
    private TextField checkDayTxt;
    
    @FXML
    private TextField cNumTxt;

    @FXML
    private TextField costTxt;

    @FXML
    private TextArea noteTxt;
    
    
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int index = -1;

    ObservableList<String> listc = FXCollections.observableArrayList("수리 대기", "수리 중", "수리 완료");

//    ComboBox<String> combobox = (ComboBox<String>)inspectForm.lookup("#combobox");
	
    ObservableList<inspect> listI;
	
	public void setInspectForm(Parent resForm) {
		this.inspectForm = resForm;
	}
	
	public void setInsController(insController insController) {
		this.insController = insController;
	}
	
	@FXML
	void getSelected (MouseEvent event) {
		index = reservationLog.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
		resNumTxt.setText(resNumColumn.getCellData(index).toString());
		checkDayTxt.setText(checkDayColumn.getCellData(index).toString());
		cNumTxt.setText(carNumColumn.getCellData(index).toString());
		costTxt.setText(costCheckColumn.getCellData(index).toString());
		noteTxt.setText(noteColumn.getCellData(index).toString());
		
		
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.insSvc = new insService();
		
		
		combobox.setItems(listc);
		
		resNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, Integer>("resNum"));
		checkDayColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("reservationDate"));
		sitColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("sit"));
		carNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("carNum"));
		costCheckColumn.setCellValueFactory(new PropertyValueFactory<inspect, Integer>("cost"));
		noteColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("note"));
		listI = insdb.getdata();
		reservationLog.setItems(listI);
		
		
		
	}
	

	
	public void progressProc()  {
		insSvc.progressProc(inspectForm);
		
	
		
		conn = insdb.ConnetDb();
		
		String value1 = resNumTxt.getText();
		String value2 = checkDayTxt.getText();
		String value3 = combobox.getValue();
		String value4 = cNumTxt.getText();
		String value5 = costTxt.getText();
		String value6 = noteTxt.getText();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		System.out.println(value6);
		
		resNumTxt.clear();
		checkDayTxt.clear();
		cNumTxt.clear();
		costTxt.clear();
		noteTxt.clear();
		
		String sql = "update reservation set cost = '"+value5+"', sit = '"+value3+"', note = '"+value6+"' where resNum = '"+value1+"' ";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			CommonService.Msg("내용 수정");
			
		
			
			resNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, Integer>("resNum"));
			checkDayColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("reservationDate"));
			sitColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("sit"));
			carNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("carNum"));
			costCheckColumn.setCellValueFactory(new PropertyValueFactory<inspect, Integer>("cost"));
			noteColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("note"));
			listI = insdb.getdata();
			reservationLog.setItems(listI);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void endProc() {
//		insSvc.endProc(inspectForm);
//		
//		conn = insdb.ConnetDb();
//		
//		String value1 = resNumTxt.getText();
//		String value2 = checkDayTxt.getText();
//		String value3 = combobox.getValue();
//		String value4 = cNumTxt.getText();
//		String value5 = costTxt.getText();
//		String value6 = noteTxt.getText();
//		CommonService.Msg("완료");
//		
//		String sql2 = "update reservation(sit, cost, note) values(?,?,?)";
//		try {
//			ps = conn.prepareStatement(sql2);
//			ps.setString(1, value3);
//			ps.setString(2, value5);
//			ps.setString(3, value6);
//			ps.execute();
//			
//			
//		
//	}catch(SQLException e){
//		e.printStackTrace();
		
		
	}
//		String sql = "update reservation set cost = '"+value5+"', sit = '"+value3+"', note = '"+value6+"' where checkDay = '"+value2+"' ";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.execute();
//			
//		
//			
//			resNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, Integer>("resNum"));
//			checkDayColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("reservationDate"));
//			sitColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("sit"));
//			carNumColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("carNum"));
//			costCheckColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("cost"));
//			noteColumn.setCellValueFactory(new PropertyValueFactory<inspect, String>("note"));
//			listI = insdb.getdata();
//			reservationLog.setItems(listI);
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	
	
}
