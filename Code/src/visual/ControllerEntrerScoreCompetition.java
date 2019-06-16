package visual;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import poo.UtilSons;

public class ControllerEntrerScoreCompetition {

	@FXML
	private TextField textFieldNom;

	@FXML
	private Label labelTemps;

	private String nomJoueur;

	private String temps;
	
	
	/* 	
	 * CA C'EST CE QU'IL FAUT LANCER SI LE MEC A FAIT UN DES MEILLEURS SCORES, C'EST A ECRIRE DANS LE CONTROLLER QUI GERE L'INTERFACE DU MODE COMPET
	 * 
	 * @FXML
	public void faireEntrerScore(ActionEvent event) {
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EntrerScoreCompetitionFXML.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerEntrerScoreCompetition score = loader.getController();
			score.setTemps("Le temps fait");

			Scene sceneJeu = new Scene(stageJeu);

			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */

	@FXML
	void cliquerConfirmer(ActionEvent event) {
		/////////////////////////////////////// Enregistrer le
		/////////////////////////////////////// score//////////////////////////////////////////
		UtilSons.jouerSonBouton();
		nomJoueur = textFieldNom.getText();
		if (!nomJoueur.equals("")) { // VERIFIE QUE LE JOUEUR AI PAS RENTRE UNE VALEUR NULLE, ON NE SAUVEGARDE PAS
										// SON SCORE SI IL N A PAS ENTRE DE NOM, QU IL PUISSE JOUER JUSTE POUR LE FUN

		}
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

	public void setTemps(String temps) {
		this.temps = temps;
		labelTemps.setText(temps);
	}

}
