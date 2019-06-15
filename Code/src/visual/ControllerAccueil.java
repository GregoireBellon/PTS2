package visual;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ControllerAccueil {

    @FXML
    private Canvas Canvas;

    @FXML
    private Slider sliderMusique;

    @FXML
    private Slider sliderEffets;

    @FXML
    private CheckBox checkBoxPleinEcran;

    @FXML
    void CliquerEntraînement(ActionEvent event) {
    	UtilSons.jouerSonBouton();
    	
    	/*Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EntrainementFXML.fxml"));

		Parent stageJeu = loader.load();

		
		PageJeuController Controller = loader.getController();
		jeuController.initValues(this.getNbJoueurs(), this.getDifficulte());

		Scene sceneJeu = new Scene(stageJeu);

		sceneJeu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		fenetre.setScene(sceneJeu);

		jeuController.debutPartie();
		fenetre.setFullScreen(true); // Si ratio d'écran == 1280/721
		fenetre.show();*/
    }

    @FXML
    void CliquerProgression(ActionEvent event) {

    }

    @FXML
    void cliquerClassement(ActionEvent event) {

    }

    @FXML
    void cliquerCompétition(ActionEvent event) {

    }

    @FXML
    void cliquerOptions(ActionEvent event) {

    }

    @FXML
    void cliquerPleinEcran(ActionEvent event) {

    }

}