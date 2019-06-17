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
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(13, Contexte.Diurne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	@FXML
	void cliquerDJ(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(7, Contexte.Diurne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerDM(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(19, Contexte.Diurne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerDS(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(1, Contexte.Diurne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerNE(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(13, Contexte.Nocturne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerNJ(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(7, Contexte.Nocturne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerNM(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(19, Contexte.Nocturne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@FXML
	void cliquerNS(ActionEvent event) {
		UtilSons.jouerSonBouton();
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveau = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveau.lancerPartie(Random.niveauRandom(1, Contexte.Nocturne));
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}
