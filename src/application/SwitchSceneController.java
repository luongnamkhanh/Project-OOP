package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchSceneController {
	@FXML
	public void pressBackButton(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TourismScene.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void pressContinueButton(ActionEvent e) throws IOException {
		//For overriding
	}
}
