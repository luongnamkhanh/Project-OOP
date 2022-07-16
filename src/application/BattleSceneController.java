package application;

import java.util.ArrayList;
import java.util.Scanner;

import event.BattleQuery;
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

public class BattleSceneController extends SwitchSceneController{
	@FXML
	private Button backButton;
	@FXML
	private Button continueButton;
	@FXML
	private CheckBox dateCheckBox;
	@FXML
	private CheckBox placeCheckBox;
	@FXML
	private CheckBox combatantCheckBox;
	@FXML
	private CheckBox resultCheckBox;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void pressContinueButton(ActionEvent e) throws IOException {

		ArrayList<Boolean> userChoice = new ArrayList<Boolean>();
		if(dateCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);
		
		if(placeCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(combatantCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		if(resultCheckBox.isSelected()) 
			userChoice.add(true);
		else
			userChoice.add(false);

		HelloRDFWorld a = new HelloRDFWorld();
		BattleQuery g = new BattleQuery();
		String battleFilename = "Battle.ttl";

		a.importData(g.constructQuery(userChoice), battleFilename);

		String result = "";
		File file = new File(battleFilename);
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
