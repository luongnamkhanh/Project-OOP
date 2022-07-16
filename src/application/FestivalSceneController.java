package application;

import java.util.ArrayList;
import java.util.Scanner;

import event.FestivalQuery;
import importData.HelloRDFWorld;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class FestivalSceneController extends SwitchSceneController{
	@FXML
	private Button backButton;
	@FXML
	private Button continueButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void pressContinueButton(ActionEvent e) throws IOException {

		ArrayList<Boolean> userChoice = new ArrayList<Boolean>();

		HelloRDFWorld a = new HelloRDFWorld();
		FestivalQuery g = new FestivalQuery();
		String festivalFilename = "Festival.ttl";

		a.importData(g.constructQuery(userChoice), festivalFilename);

		String result = "";
		File file = new File(festivalFilename);
		Scanner sc = new Scanner(file);
 
    	while (sc.hasNextLine())
      		result = result + sc.nextLine() + "\n";

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
		root = loader.load();

		ResultSceneController resultSceneController = loader.getController();
		resultSceneController.displayResult(result);

		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.show();
		
	}
}

