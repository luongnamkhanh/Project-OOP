package application;

import java.util.ArrayList;
import java.util.Scanner;

import historicalFigure.KingQuery;
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

public class KingSceneController extends SwitchSceneController{
	@FXML
	private Button backButton;
	@FXML
	private Button continueButton;
	@FXML
	private CheckBox birthNameCheckBox;
	@FXML
	private CheckBox birthDateCheckBox;
	@FXML
	private CheckBox deathDateCheckBox;
	@FXML
	private CheckBox birthPlaceCheckBox;
	@FXML
	private CheckBox parentsCheckBox;
	@FXML
	private CheckBox spouseCheckBox;
	@FXML
	private CheckBox childrenCheckBox;
	@FXML
	private CheckBox eraDateCheckBox;
	@FXML
	private CheckBox eraNameCheckBox;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void pressContinueButton(ActionEvent e) throws IOException {

		ArrayList<Boolean> userChoice = new ArrayList<Boolean>();
		if(birthNameCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);
		
		if(birthDateCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(deathDateCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(birthPlaceCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(parentsCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(spouseCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(childrenCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(eraDateCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(eraNameCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		HelloRDFWorld a = new HelloRDFWorld();
		KingQuery g = new KingQuery();
		String kingFilename = "King.ttl";

		a.importData(g.constructQuery(userChoice), kingFilename);

		String result = "";
		File file = new File(kingFilename);
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