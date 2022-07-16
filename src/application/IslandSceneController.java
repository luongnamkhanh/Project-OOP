package application;

import java.util.ArrayList;
import java.util.Scanner;

import attraction.IslandQuery;
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

public class IslandSceneController extends SwitchSceneController{
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
	private CheckBox totalAreaCheckBox;
	@FXML
	private CheckBox totalPopulationCheckBox;
	
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

		if(totalAreaCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(totalPopulationCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		HelloRDFWorld a = new HelloRDFWorld();
		IslandQuery g = new IslandQuery();
		String islandFilename = "Island.ttl";

		a.importData(g.constructQuery(userChoice), islandFilename);

		String result = "";
		File file = new File(islandFilename);
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
