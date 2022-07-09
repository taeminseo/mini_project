package common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {

	// 경고창 띄어서 알림보냄
	// 경고창 띄울 때 Msg("출력할 메세지") 이런식으로 사용
	public static void Msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알림");
		alert.setContentText(content);
		alert.show();
	}
	
	// 다른창을 보여주고 이전창을 닫을때 사용
	public static void WindowClose(Parent form) {
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
	}
	
}
