package visual;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.Contexte;
import poo.Random;
import poo.UtilSons;

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
		
		Random.niveauRandom(13, Contexte.Diurne);

	}

	@FXML
	void cliquerDJ(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(7, Contexte.Diurne);


	}

	@FXML
	void cliquerDM(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(19, Contexte.Diurne);


	}

	@FXML
	void cliquerDS(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(1, Contexte.Diurne);


	}

	@FXML
	void cliquerNE(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(13, Contexte.Nocturne);


	}

	@FXML
	void cliquerNJ(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(7, Contexte.Nocturne);


	}

	@FXML
	void cliquerNM(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(19, Contexte.Nocturne);


	}

	@FXML
	void cliquerNS(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		Random.niveauRandom(1, Contexte.Nocturne);


	}

}
