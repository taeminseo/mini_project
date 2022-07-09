package check;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.CheckDAO;
import DAO.ReservationDAO;
import DTO.CheckDTO;
import DTO.ReservationDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import login.LoginDTO;
import memberMain.MemberController;

public class CheckController implements Initializable{
	
		@FXML
	    private TableView<CheckDTO> tableView;
		@FXML
	    private TableColumn<CheckDTO, String> check_day,shop_name,car_sit,check_cost;
//		CheckDAO dao = new CheckDAO();
		
//		ObservableList<CheckDTO> list = dao.showchecks();
		
		private CheckService cheSvc;
		private MemberController memCon;
		private Parent checkForm;
		private LoginDTO login;
		
		public LoginDTO getLogin() {
			return login;
		}
		public void setLogin(LoginDTO dto) {
			this.login = dto;
		}

		public Parent getCheckForm() {
			return checkForm;
		}
		public void setCheckForm(Parent checkForm) {
			this.checkForm = checkForm;
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			cheSvc = new CheckService();
//			
//			check_day.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("check_day"));
//			shop_name.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("shop_name"));
//			car_sit.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("car_sit"));
//			check_cost.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("check_cost"));
//			tableView.setItems(checkList);
		}
		
		
		public void resShowProc() {
			if(getLogin().getId() == null)	System.out.println("로그인세션문제발생");
			else	System.out.println("로그인id값 : "+getLogin().getId());
			
			check_day.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("check_day"));
			shop_name.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("shop_name"));
			car_sit.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("car_sit"));
			check_cost.setCellValueFactory(new PropertyValueFactory<CheckDTO,String>("check_cost"));
			
			CheckDAO dao = new CheckDAO();
			ObservableList<CheckDTO> list = dao.showchecks(getLogin());
			System.out.println("--------------예약보기 버튼 클릭시-----------");

			tableView.setItems(list);
		}

	
}
