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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerProgression implements Initializable{

    @FXML
    private Button d1;

    @FXML
    private Button d2;

    @FXML
    private Button d3;

    @FXML
    private Button d4;

    @FXML
    private Button d5;

    @FXML
    private Button d6;

    @FXML
    private Button d7;

    @FXML
    private Button d8;

    @FXML
    private Button d9;

    @FXML
    private Button d10;

    @FXML
    private Button d11;

    @FXML
    private Button d12;

    @FXML
    private Button d13;

    @FXML
    private Button d14;

    @FXML
    private Button d15;

    @FXML
    private Button d16;

    @FXML
    private Button d17;

    @FXML
    private Button d18;

    @FXML
    private Button d19;

    @FXML
    private Button d20;

    @FXML
    private Button d21;

    @FXML
    private Button d22;

    @FXML
    private Button d23;

    @FXML
    private Button d24;

    @FXML
    private Button n1;

    @FXML
    private Button n2;

    @FXML
    private Button n3;

    @FXML
    private Button n4;

    @FXML
    private Button n5;

    @FXML
    private Button n6;

    @FXML
    private Button n7;

    @FXML
    private Button n8;

    @FXML
    private Button n9;

    @FXML
    private Button n10;

    @FXML
    private Button n11;

    @FXML
    private Button n12;

    @FXML
    private Button n13;

    @FXML
    private Button n14;

    @FXML
    private Button n15;

    @FXML
    private Button n16;

    @FXML
    private Button n17;

    @FXML
    private Button n18;

    @FXML
    private Button n19;

    @FXML
    private Button n20;

    @FXML
    private Button n21;

    @FXML
    private Button n22;

    @FXML
    private Button n23;

    @FXML
    private Button n24;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//////////////////AJOUTER DE QUOI MONTRER SI UN NIVEAU EST COMPLETE///////////////////
		d1.setStyle("-fx-background-color: #9ACC27"); //C'est la formule pour changer la couleur
	}

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
	public void cliquer1D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer2D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer3D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer4D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer5D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer6D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer7D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer8D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer9D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer10D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer11D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer12D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer13D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer14D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer15D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer16D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer17D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer18D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer19D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer20D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer21D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer22D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer23D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer24D(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}


	@FXML
	public void cliquer1N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer2N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer3N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer4N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer5N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer6N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer7N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer8N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer9N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer10N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer11N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer12N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer13N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer14N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer15N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer16N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer17N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer18N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer19N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer20N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer21N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer22N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer23N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

	@FXML
	public void cliquer24N(ActionEvent event) {
		UtilSons.jouerSonBouton();

	}

}
