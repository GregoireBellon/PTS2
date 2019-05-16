
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller implements Initializable {

	private Jeux jeu;

	public void setJeu(Jeux jeu) {
		this.jeu = jeu;
	}

	@FXML
	private ImageView case1;

	@FXML
	private ImageView case2;

	@FXML
	private ImageView case3;

	@FXML
	private ImageView case4;

	@FXML
	private ImageView case5;

	@FXML
	private ImageView case6;

	@FXML
	private ImageView case7;

	@FXML
	private ImageView case8;

	@FXML
	private ImageView case9;

	@FXML
	private ImageView case11;

	@FXML
	private ImageView case12;

	@FXML
	private ImageView case13;

	@FXML
	private ImageView case14;

	@FXML
	private ImageView piece3;

	@FXML
	private ImageView piece2;

	@FXML
	private ImageView case10;

	@FXML
	private ImageView piece1;

	@FXML
	void PieceDrague(ActionEvent event) {
		// teleporter la piece a la souris
	}

	@FXML
	void PieceDragueFini(ActionEvent event) {
		// lacher la piece ?
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TypeCase[][] plateau = jeu.getPlateau();
		switch (plateau[0][1]) {
		case Vide:
			case1.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case1.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case1.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
	}

}
