package shop.component;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.ComponentDAO;
import DTO.CheckDTO;
import DTO.ComponentDTO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.ByteStringConverter;
import shop.main.shopController;
import common.CommonService;
import login.LoginDTO;
import login.LoginServiceImpl;
import reg.RegController;
import shop.main.shopService;
import common.CommonService;
import main.Controller;
import shop.component.db;

// 컨트롤러들의 참조 값을 저장하는 기능.

public class comController implements Initializable {
	//tableView사용하기위한 @fxml
			@FXML
		    private TableView<component> inventory;
			@FXML
		    private TableColumn<component, String> nameColumn,countColumn,costColumn;
			@FXML
		    private TableColumn<component, Integer> cNumColumn;
			@FXML
		    private TableColumn<component, Integer> sNumColumn;
			  
			@FXML
			private TextField cNum;

			@FXML
			private TextField name;

			@FXML
			private TextField count;

			@FXML
			private TextField cost;

			@FXML
			private TextField sNum;
			
			
			
			@FXML
			void getSelected (MouseEvent event) {
				index = inventory.getSelectionModel().getSelectedIndex();
				if(index <= -1) {
					return;
				}
				cNum.setText(cNumColumn.getCellData(index).toString());
				name.setText(nameColumn.getCellData(index).toString());
				count.setText(countColumn.getCellData(index).toString());
				cost.setText(costColumn.getCellData(index).toString());
				sNum.setText(sNumColumn.getCellData(index).toString());
				
				
			}
		
			private comController comController;
			private Parent componentForm;

			
			ObservableList<component> listM;
			int index = -1;
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			

			
		
			
			
			@Override
			public void initialize(URL location, ResourceBundle resources) {
				
			
				cNumColumn.setCellValueFactory(new PropertyValueFactory<component, Integer>("cNum"));
				nameColumn.setCellValueFactory(new PropertyValueFactory<component, String>("name"));
				countColumn.setCellValueFactory(new PropertyValueFactory<component, String>("count"));
				costColumn.setCellValueFactory(new PropertyValueFactory<component, String>("cost"));
				sNumColumn.setCellValueFactory(new PropertyValueFactory<component, Integer>("sNum"));
				listM = db.getdata();			
				inventory.setItems(listM);
			}

			
			


	public void addProc()  {
		conn = db.ConnetDb();
		String sql = "insert into component values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cNum.getText());
			ps.setString(2, name.getText());
			ps.setString(3, count.getText());
			ps.setString(4, cost.getText());
			ps.setString(5, sNum.getText());
			ps.execute();
			
			cNum.clear();
			name.clear();
			count.clear();
			cost.clear();
			sNum.clear();
			CommonService.Msg("부품 추가");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void reProc() {
		cNumColumn.setCellValueFactory(new PropertyValueFactory<component, Integer>("cNum"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<component, String>("name"));
		countColumn.setCellValueFactory(new PropertyValueFactory<component, String>("count"));
		costColumn.setCellValueFactory(new PropertyValueFactory<component, String>("cost"));
		sNumColumn.setCellValueFactory(new PropertyValueFactory<component, Integer>("sNum"));
		listM = db.getdata();			
		inventory.setItems(listM);
		
		cNum.clear();
		name.clear();
		count.clear();
		cost.clear();
		sNum.clear();
		CommonService.Msg("새로고침");
		
	}
	
	public void upProc()  {
		conn = db.ConnetDb();
		
		String value1 = cNum.getText();
		String value2 = name.getText();
		String value3 = count.getText();
		String value4 = cost.getText();
		String value5 = sNum.getText();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		String sql = "update component set sNum = '"+value5+"', count = '"+value3+"', cost = '"+value4+"' where name = '"+value2+"' and sNum = '"+value5+"' ";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			CommonService.Msg("부품 수정");
			cNum.clear();
			name.clear();
			count.clear();
			cost.clear();
			sNum.clear();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
