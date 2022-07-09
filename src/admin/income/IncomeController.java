package admin.income;

import java.net.URL;
import java.util.ResourceBundle;

import DTO.ReservationDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class IncomeController implements Initializable{

	@FXML
	private TableView<IncomeDTO> tableView;
	@FXML
	private TableColumn<IncomeDTO, Integer> count, income,lee;

	@FXML
	private TableColumn<IncomeDTO, String> shopName;
	ObservableList<IncomeDTO> list;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		IncomeDAO dao = new IncomeDAO();
		
		count.setCellValueFactory(new PropertyValueFactory<IncomeDTO,Integer>("count"));
		income.setCellValueFactory(new PropertyValueFactory<IncomeDTO,Integer>("income"));
		shopName.setCellValueFactory(new PropertyValueFactory<IncomeDTO,String>("shop_name"));
		lee.setCellValueFactory(new PropertyValueFactory<IncomeDTO,Integer>("lee_ik"));
		list = dao.showIncome();
		tableView.setItems(list);
	}
}
