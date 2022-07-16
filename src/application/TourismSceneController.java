package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TourismSceneController {

	@FXML
	private Button templeButton;
	@FXML
	private Button caveButton;
	@FXML
	private Button islandButton;
	@FXML
	private Button nationalParkButton;
	@FXML
	private Button battleButton;
	@FXML
	private Button festivalButton;
	@FXML
	private Button warHeroButton;
	@FXML
	private Button politicianButton;
	@FXML
	private Button kingButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public void pressTempleButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TempleInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void pressCaveButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CaveInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void pressNationalParkButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NationalParkInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void pressIslandButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("IslandInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void pressBattleButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void pressFestivalButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FestivalInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void pressWarHeroButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WarHeroInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 500);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void pressPoliticianButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PoliticianInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void pressKingButton(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("KingInstanceScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root, 400, 500);
		stage.setScene(scene);
		stage.show();
	}

}