package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ResultSceneController extends SwitchSceneController{
	@FXML
	private Button backButton;
	@FXML
	private Button finishButton;
	@FXML
	private TextArea resultTextArea;

	public void displayResult(String result){
		resultTextArea.setText(result); 
	}

	@Override
	public void pressContinueButton(ActionEvent e) {
		Platform.exit();
	}
}
