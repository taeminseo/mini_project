package admin.memberCheck;

import java.net.URL;

import java.util.ResourceBundle;

import DAO.MemberDAO;
import DAO.ShopDAO;
import DTO.MemberDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class MemberCheckController implements Initializable{
	private Parent MemberinfoForm;
	private MemberCheckService membersvc;
	
	@FXML
	private TableView<MemberDTO> tableView;
	@FXML
	private TableColumn<MemberDTO, String> member_name,member_id,member_pw,member_phone,member_carNum,member_car;
	
	
	ObservableList<MemberDTO> memberList;
	
	public void setMemberinfoForm(Parent MemberinfoForm) {
		this.MemberinfoForm = MemberinfoForm;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		membersvc = new MemberCheckService();
		MemberDAO dao = new MemberDAO();
		
		member_name.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_name"));
		member_id.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_id"));
		member_pw.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_id"));
		member_phone.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_phone"));
		member_carNum.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_carNum"));
		member_car.setCellValueFactory(new PropertyValueFactory<MemberDTO, String>("member_car"));
		
		memberList = dao.showreservations();
		tableView.setItems(memberList);
	}
	
	public void backProc() {
		membersvc.backProc(MemberinfoForm);
	}
	
	@FXML
	public int selecttable() {

    	int nSel = tableView.getSelectionModel().getSelectedIndex(); 
    	return nSel;
    }
	public void deleteProc() {
		int nSel = selecttable();
		String mid = member_id.getCellData(nSel);
		MemberDAO dao = new MemberDAO();
		dao.delete(mid);
	}
}