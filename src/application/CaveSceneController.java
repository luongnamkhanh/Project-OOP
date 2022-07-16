package application;

import java.util.ArrayList;
import java.util.Scanner;

import attraction.CaveQuery;
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

public class CaveSceneController extends SwitchSceneController{
	@FXML
	private Button backButton;
	@FXML
	private Button continueButton;
	@FXML
	private CheckBox latCheckBox;
	@FXML
	private CheckBox longtCheckBox;
	@FXML
	private CheckBox locationCheckBox;
	@FXML
	private CheckBox depthCheckBox;
	@FXML
	private CheckBox lengthCheckBox;
	@FXML
	private CheckBox discoveryCheckBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void pressContinueButton(ActionEvent e) throws IOException {

		ArrayList<Boolean> userChoice = new ArrayList<Boolean>();
		if(latCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);
		
		if(longtCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(locationCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(depthCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(lengthCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(discoveryCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		HelloRDFWorld a = new HelloRDFWorld();
		CaveQuery g = new CaveQuery();
		String caveFilename = "Cave.ttl";

		a.importData(g.constructQuery(userChoice), caveFilename);

		String result = "";
		File file = new File(caveFilename);
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