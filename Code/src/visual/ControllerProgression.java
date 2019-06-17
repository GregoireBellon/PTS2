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
import poo.ManipListeDefis;
import poo.UtilSons;

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
		
		if(ManipListeDefis.estTermine(1)) {
			d1.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(2)) {
			d2.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(3)) {
			d3.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(4)) {
			d4.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(5)) {
			d5.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(6)) {
			d6.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(7)) {
			n1.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(8)) {
			n2.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(9)) {
			n3.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(10)) {
			n4.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(11)) {
			n5.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(12)) {
			n6.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(13)) {
			d7.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(14)) {
			d8.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(15)) {
			d9.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(16)) {
			d10.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(17)) {
			d11.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(18)) {
			d12.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(19)) {
			n7.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(20)) {
			n8.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(21)) {
			n9.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(22)) {
			n10.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(23)) {
			n11.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(24)) {
			n12.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(25)) {
			d13.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(26)) {
			d14.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(27)) {
			d15.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(28)) {
			d16.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(29)) {
			d17.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(30)) {
			d18.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(31)) {
			n13.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(32)) {
			n14.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(33)) {
			n15.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(34)) {
			n16.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(35)) {
			n17.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(36)) {
			n18.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(37)) {
			d19.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(38)) {
			d20.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(39)) {
			d21.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(40)) {
			d22.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(41)) {
			d23.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(42)) {
			d24.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(43)) {
			n19.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(44)) {
			n20.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(45)) {
			n21.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(46)) {
			n22.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(47)) {
			n23.setStyle("-fx-background-color: #9ACC27");
		}if(ManipListeDefis.estTermine(48)) {
			n24.setStyle("-fx-background-color: #9ACC27");
		}
		
		
	 //C'est la formule pour changer la couleur
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
		lancerNiveau(event, "1D");
	}

	@FXML
	public void cliquer2D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "2D");

	}

	@FXML
	public void cliquer3D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "3D");

	}

	@FXML
	public void cliquer4D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "4D");

	}

	@FXML
	public void cliquer5D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "5D");

	}

	@FXML
	public void cliquer6D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "6D");

	}

	@FXML
	public void cliquer7D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "7D");

	}

	@FXML
	public void cliquer8D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "8D");

	}

	@FXML
	public void cliquer9D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "9D");

	}

	@FXML
	public void cliquer10D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "10D");

	}

	@FXML
	public void cliquer11D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "11D");

	}

	@FXML
	public void cliquer12D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "12D");

	}

	@FXML
	public void cliquer13D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "13D");

	}

	@FXML
	public void cliquer14D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "14D");

	}

	@FXML
	public void cliquer15D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "15D");

	}

	@FXML
	public void cliquer16D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "16D");

	}

	@FXML
	public void cliquer17D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "17D");

	}

	@FXML
	public void cliquer18D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "18D");

	}

	@FXML
	public void cliquer19D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "19D");

	}

	@FXML
	public void cliquer20D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "20D");

	}

	@FXML
	public void cliquer21D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "21D");

	}

	@FXML
	public void cliquer22D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "22D");

	}

	@FXML
	public void cliquer23D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "23D");

	}

	@FXML
	public void cliquer24D(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "24D");

	}


	@FXML
	public void cliquer1N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "1N");

	}

	@FXML
	public void cliquer2N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "2N");

	}

	@FXML
	public void cliquer3N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "3N");

	}

	@FXML
	public void cliquer4N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "4N");

	}

	@FXML
	public void cliquer5N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "5N");

	}

	@FXML
	public void cliquer6N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "6N");

	}

	@FXML
	public void cliquer7N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "7N");

	}

	@FXML
	public void cliquer8N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "8N");

	}

	@FXML
	public void cliquer9N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "9N");

	}

	@FXML
	public void cliquer10N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "10N");

	}

	@FXML
	public void cliquer11N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "11N");

	}

	@FXML
	public void cliquer12N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "12N");

	}

	@FXML
	public void cliquer13N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "13N");

	}

	@FXML
	public void cliquer14N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "14N");

	}

	@FXML
	public void cliquer15N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "15N");

	}

	@FXML
	public void cliquer16N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "16N");

	}

	@FXML
	public void cliquer17N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "17N");

	}

	@FXML
	public void cliquer18N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "18N");

	}

	@FXML
	public void cliquer19N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "19N");

	}

	@FXML
	public void cliquer20N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "20N");

	}

	@FXML
	public void cliquer21N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "21N");

	}

	@FXML
	public void cliquer22N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "22N");

	}

	@FXML
	public void cliquer23N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "23N");

	}

	@FXML
	public void cliquer24N(ActionEvent event) {
		UtilSons.jouerSonBouton();
		lancerNiveau(event, "24N");

	}

	private void lancerNiveau(ActionEvent event, String niveau) {
		try {
			Stage fenetre = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));

			Parent stageJeu;

			stageJeu = loader.load();

			ControllerInGame niveauACharger = loader.getController();
			

			Scene sceneJeu = new Scene(stageJeu);

			niveauACharger.lancerPartie(niveau);
			
			fenetre.setScene(sceneJeu);
			
			fenetre.setFullScreen(DemarrageApplication.fullScreen);

			fenetre.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}