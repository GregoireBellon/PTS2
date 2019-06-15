package visual;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerEntrainement {

	@FXML
	public void cliquerRetour(ActionEvent event) {

		UtilSons.jouerSonBouton();

		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Parent stage = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));

			Scene scene = new Scene(stage);

			fenetre.setScene(scene);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void cliquerDE(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerDJ(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerDM(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerDS(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerNE(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerNJ(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerNM(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	void cliquerNS(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

}
