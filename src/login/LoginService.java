package login;

import javafx.scene.Parent;
import main.Controller;
import reg.RegDTO;

public interface LoginService {
	public LoginDTO loginProc(Parent root);
	public void cancelProc(Parent root);
}