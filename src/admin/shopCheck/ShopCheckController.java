package admin.shopCheck;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import DAO.ShopDAO;
import DTO.ShopDTO;
import admin.shopRegister.ShopRegController;
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
import javafx.scene.input.MouseEvent;
import shop.component.component;
import shop.component.db;

public class ShopCheckController implements Initializable{
	
	@FXML
	private TextField text_shopName,text_shopId,text_shopPw,text_shopTel,text_shopLocation,text_shopCeo;
	@FXML
    private TableView<ShopDTO> tableView;
	@FXML
    private TableColumn<ShopDTO, String> shopName,shopId,shopPw,shopTel,shopLocation,shopCeo;
	
	
	ObservableList<ShopDTO> listS;
	
	
	private ShopCheckService schSvc;
	private Parent shopCheckForm;
	private ShopRegController regCon; 
	
	public ShopRegController getRegCon() {
		return regCon;
	}

	public void setRegCon(ShopRegController regCon) {
		this.regCon = regCon;
	}

	public Parent getShopCheckForm() {
		return shopCheckForm;
	}

	public void setShopCheckForm(Parent shopCheckForm) {
		this.shopCheckForm = shopCheckForm;
	}

	private Parent shopInfoForm;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		schSvc = new ShopCheckService();
		ShopDAO dao = new ShopDAO();
		
		shopName.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("shop_name"));
		shopId.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("shop_id"));
		shopPw.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("shop_pw"));
		shopTel.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("phone_num"));
		shopLocation.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("ceo_name"));
		shopCeo.setCellValueFactory(new PropertyValueFactory<ShopDTO, String>("ceo_name"));
		
		listS = dao.shopShow();	
		tableView.setItems(listS);
		
		
		
	}
	
	public void showShopworkProc() {
		
	}

	public void insertShopProc() {
		schSvc.insertShopProc();
	}
	
	@FXML
	public int selecttableView(	) {

    	int nSel = tableView.getSelectionModel().getSelectedIndex(); 

//		String sid = shopId.getCellData(nSel);
//		System.out.println("선택된 아이디는 " + sid);
    	return nSel;
    }
	public void deleteShopProc() {
		int nSel = selecttableView();
		System.out.println("nSel : " + nSel);
		String sid = shopId.getCellData(nSel);
		System.out.println("id : " + sid);
		ShopDAO dao = new ShopDAO();
		dao.delete(sid);
	}
	
	
	

}

	
