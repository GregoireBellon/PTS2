package visual;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import poo.UtilSons;

public class ControllerAccueil implements Initializable {

	@FXML
	private Canvas canvas;

	@FXML
	private Slider sliderMusique;

	@FXML
	private Slider sliderEffets;

	@FXML
	private CheckBox checkBoxPleinEcran;

	@FXML
	private Label labelMusique;

	@FXML
	private Label labelEffets;

	@FXML
	private Button quitter;
	
	@FXML
	private Button plus;
	
	@FXML
	private Button reinitialiser;

	private GraphicsContext g;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		g = canvas.getGraphicsContext2D();

		sliderMusique.setValue(UtilSons.mediaPlayerMusique.getVolume());
		sliderEffets.setValue(UtilSons.bruitages.getVolume());
		checkBoxPleinEcran.setSelected(DemarrageApplication.fullScreen);

	}

	@FXML
	void CliquerEntraînement(ActionEvent event) {
		UtilSons.jouerSonBouton();

		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Parent stage = FXMLLoader.load(getClass().getResource("EntrainementFXML.fxml"));

			Scene scene = new Scene(stage);

			fenetre.setScene(scene);

			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void CliquerProgression(ActionEvent event) {
		UtilSons.jouerSonBouton();

		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Parent stage = FXMLLoader.load(getClass().getResource("ProgressionFXML.fxml"));

			Scene scene = new Scene(stage);

			fenetre.setScene(scene);

			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void cliquerClassement(ActionEvent event) {
		UtilSons.jouerSonBouton();

		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Parent stage = FXMLLoader.load(getClass().getResource("ClassementFXML.fxml"));

			Scene scene = new Scene(stage);

			fenetre.setScene(scene);

			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void cliquerCompetition(ActionEvent event) {
		UtilSons.jouerSonBouton();

		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Parent stage = FXMLLoader.load(getClass().getResource("CompetitionFXML.fxml"));

			Scene scene = new Scene(stage);

			fenetre.setScene(scene);

			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void cliquerOptions(ActionEvent event) {
		UtilSons.jouerSonBouton();
		sliderMusique.setVisible(!sliderMusique.isVisible());
		sliderEffets.setVisible(!sliderEffets.isVisible());
		checkBoxPleinEcran.setVisible(!checkBoxPleinEcran.isVisible());
		labelMusique.setVisible(!labelMusique.isVisible());
		labelEffets.setVisible(!labelEffets.isVisible());
		quitter.setVisible(!quitter.isVisible());
		plus.setVisible(!plus.isVisible());
		reinitialiser.setVisible(false);
		if (sliderMusique.isVisible()) {
			g.setFill(Color.WHITE);
			g.beginPath();
			g.rect(0, 0, 299, 377);
			g.fill();
		} else {
			g.clearRect(0, 0, 299, 377);
		}
	}

	@FXML
	void cliquerPleinEcran(ActionEvent event) {
		UtilSons.jouerSonBouton();
		Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
		DemarrageApplication.fullScreen = !fenetre.isFullScreen();
		fenetre.setFullScreenExitHint("");
		fenetre.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		fenetre.setFullScreen(!fenetre.isFullScreen());

	}

	@FXML
	void changerVolumeEffets(MouseEvent event) {
		UtilSons.bruitages.setVolume(sliderEffets.getValue());
	}

	@FXML
	void changerVolumeMusique(MouseEvent event) {
		UtilSons.mediaPlayerMusique.setVolume(sliderMusique.getValue());

	}

	@FXML
	public void cliquerQuitter(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	public void cliquerPlus(ActionEvent event) {
		UtilSons.jouerSonBouton();
		reinitialiser.setVisible(!reinitialiser.isVisible());
	}
	
	@FXML
	public void cliquerReinitialiser(ActionEvent event) {
		UtilSons.jouerSonBouton();
		
		/////////////////////A COMPLETER////////////////////////
	}


}