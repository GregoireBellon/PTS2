package visual;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerClassement {

    @FXML
    private Label nom1;

    @FXML
    private Label temps1;

    @FXML
    private Label nom2;

    @FXML
    private Label temps2;

    @FXML
    private Label nom3;

    @FXML
    private Label temps3;

    @FXML
    private Label nom4;

    @FXML
    private Label temps4;

    @FXML
    private Label nom5;

    @FXML
    private Label nom6;

    @FXML
    private Label nom7;

    @FXML
    private Label nom8;

    @FXML
    private Label nom9;

    @FXML
    private Label nom10;

    @FXML
    private Label temps5;

    @FXML
    private Label temps6;

    @FXML
    private Label temps7;

    @FXML
    private Label temps8;

    @FXML
    private Label temps9;

    @FXML
    private Label temps10;

    @FXML
    private Label nom11;

    @FXML
    private Label temps11;

    @FXML
    private Label nom12;

    @FXML
    private Label temps12;

    @FXML
    private Label nom13;

    @FXML
    private Label temps13;

    @FXML
    private Label nom14;

    @FXML
    private Label temps14;

    @FXML
    private Label nom15;

    @FXML
    private Label nom16;

    @FXML
    private Label nom17;

    @FXML
    private Label nom18;

    @FXML
    private Label nom19;

    @FXML
    private Label nom20;

    @FXML
    private Label temps15;

    @FXML
    private Label temps16;

    @FXML
    private Label temps17;

    @FXML
    private Label temps18;

    @FXML
    private Label temps19;

    @FXML
    private Label temps20;
    
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

}
