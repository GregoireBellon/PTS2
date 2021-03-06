package visual;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import poo.ManipTabScore;
import poo.Score;
import poo.UtilSons;

public class ControllerClassement implements Initializable {

	@FXML
	private Label categorie;

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

	public int selection = 1; // Tu peux bind directement le contexte � afficher

	public List<String> listeCategories = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listeCategories.add("Junior Diurne");
		listeCategories.add("Junior Nocturne");
		listeCategories.add("Starter Diurne");
		listeCategories.add("Starter Nocturne");
		listeCategories.add("Expert Diurne");
		listeCategories.add("Expert Nocturne");
		listeCategories.add("Master Diurne");
		listeCategories.add("Master Nocturne");
		categorie.setText(listeCategories.get(selection - 1));
		afficherScores();

		

		///////////// A COMPLETER (afficher par d�faut avec la
		///////////// s�lection)////////////////////////
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
	public void cliquerPrecedent(ActionEvent event) {
		UtilSons.jouerSonBouton();
		selection--;
		if (selection < 1)
			selection = 8;
		categorie.setText(listeCategories.get(selection - 1));
		afficherScores();
	}

	@FXML
	public void cliquerSuivant(ActionEvent event) {
		UtilSons.jouerSonBouton();
		selection++;
		if (selection > 8)
			selection = 1;
		categorie.setText(listeCategories.get(selection - 1));
		afficherScores();

	}

	@FXML
	public void afficherScores() {
		List<Score> liste = ManipTabScore.recupScore(selection);

		if (liste.size() > 0) {
			nom1.setText(liste.get(0).getNom());
			temps1.setText(Integer.toString(liste.get(0).getTemps()));
		} else {
			nom1.setText("");
			temps1.setText("");
		}

		if (liste.size() > 1) {
			nom2.setText(liste.get(1).getNom());
			temps2.setText(Integer.toString(liste.get(1).getTemps()));

		} else {
			nom2.setText("");
			temps2.setText("");
		}

		if (liste.size() > 2) {
			nom3.setText(liste.get(2).getNom());
			temps3.setText(Integer.toString(liste.get(2).getTemps()));

		} else {
			nom3.setText("");
			temps3.setText("");
		}

		if (liste.size() > 3) {
			nom4.setText(liste.get(3).getNom());
			temps4.setText(Integer.toString(liste.get(3).getTemps()));

		} else {
			nom4.setText("");
			temps4.setText("");
		}

		if (liste.size() > 4) {
			nom5.setText(liste.get(4).getNom());
			temps5.setText(Integer.toString(liste.get(4).getTemps()));

		} else {
			nom5.setText("");
			temps5.setText("");
		}

		if (liste.size() > 5) {
			nom6.setText(liste.get(5).getNom());
			temps6.setText(Integer.toString(liste.get(5).getTemps()));

		} else {
			nom6.setText("");
			temps6.setText("");
		}

		if (liste.size() > 6) {
			nom7.setText(liste.get(6).getNom());
			temps7.setText(Integer.toString(liste.get(6).getTemps()));

		} else {
			nom7.setText("");
			temps7.setText("");
		}

		if (liste.size() > 7) {
			nom8.setText(liste.get(7).getNom());
			temps8.setText(Integer.toString(liste.get(7).getTemps()));

		} else {
			nom8.setText("");
			temps8.setText("");
		}

		if (liste.size() > 8) {
			nom9.setText(liste.get(8).getNom());
			temps9.setText(Integer.toString(liste.get(8).getTemps()));

		} else {
			nom9.setText("");
			temps9.setText("");
		}

		if (liste.size() > 9) {
			nom10.setText(liste.get(9).getNom());
			temps10.setText(Integer.toString(liste.get(9).getTemps()));

		} else {
			nom10.setText("");
			temps10.setText("");
		}

		if (liste.size() > 10) {
			nom11.setText(liste.get(10).getNom());
			temps11.setText(Integer.toString(liste.get(10).getTemps()));

		} else {
			nom11.setText("");
			temps11.setText("");
		}

		if (liste.size() > 11) {
			nom12.setText(liste.get(11).getNom());
			temps12.setText(Integer.toString(liste.get(11).getTemps()));

		} else {
			nom12.setText("");
			temps12.setText("");
		}

		if (liste.size() > 12) {
			nom13.setText(liste.get(12).getNom());
			temps13.setText(Integer.toString(liste.get(12).getTemps()));

		} else {
			nom13.setText("");
			temps13.setText("");
		}

		if (liste.size() > 13) {
			nom14.setText(liste.get(13).getNom());
			temps14.setText(Integer.toString(liste.get(13).getTemps()));

		} else {
			nom14.setText("");
			temps14.setText("");
		}

		if (liste.size() > 14) {
			nom15.setText(liste.get(14).getNom());
			temps15.setText(Integer.toString(liste.get(14).getTemps()));

		} else {
			nom15.setText("");
			temps15.setText("");
		}

		if (liste.size() > 15) {
			nom16.setText(liste.get(15).getNom());
			temps16.setText(Integer.toString(liste.get(15).getTemps()));

		} else {
			nom16.setText("");
			temps16.setText("");
		}

		if (liste.size() > 16) {
			nom17.setText(liste.get(16).getNom());
			temps17.setText(Integer.toString(liste.get(16).getTemps()));

		} else {
			nom17.setText("");
			temps17.setText("");
		}

		if (liste.size() > 17) {
			nom18.setText(liste.get(17).getNom());
			temps18.setText(Integer.toString(liste.get(17).getTemps()));

		} else {
			nom18.setText("");
			temps18.setText("");
		}

		if (liste.size() > 18) {
			nom19.setText(liste.get(18).getNom());
			temps19.setText(Integer.toString(liste.get(18).getTemps()));

		} else {
			nom19.setText("");
			temps19.setText("");
		}

		if (liste.size() > 19) {
			nom20.setText(liste.get(19).getNom());
			temps20.setText(Integer.toString(liste.get(19).getTemps()));

		} else {
			nom20.setText("");
			temps20.setText("");
		}

	}

	@FXML
	public void initialize() {
		afficherScores();
	}

}
