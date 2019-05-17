
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.geom.Point2D;

import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
	private ImageView piece3;

	@FXML
	private ImageView piece2;

	@FXML
	private ImageView case10;

	@FXML
	private ImageView piece1;

	@FXML
	void Piece1Drague(MouseEvent event) {
		piece1.setTranslateX(event.getSceneX() - piece1.getFitWidth()*2);
		piece1.setTranslateY(event.getSceneY() - piece1.getFitHeight()/2 );
		piece1.setX(event.getSceneX()- piece1.getFitWidth()/2 );
		piece1.setY(event.getSceneY()- piece1.getFitHeight()/2 );
	}
	

	@FXML
	void Piece2Drague(MouseEvent event) {
		piece2.setTranslateX(event.getSceneX() - piece2.getFitWidth()*2);
		piece2.setTranslateY(event.getSceneY() - piece2.getFitHeight()*1.5 );
		piece2.setX(event.getSceneX()- piece2.getFitWidth()/2 );
		piece2.setY(event.getSceneY()- piece2.getFitHeight()/2 );
	}

	@FXML
	void Piece3Drague(MouseEvent event) {
		piece3.setTranslateX(event.getSceneX() - piece3.getFitWidth()*1.85);
		piece3.setTranslateY(event.getSceneY() - piece3.getFitHeight()*2.45 );
		piece3.setX(event.getSceneX()- piece3.getFitWidth()/2 );
		piece3.setY(event.getSceneY()- piece3.getFitHeight()/2 );
	}

	@FXML
	void rotationPiece1(ScrollEvent event) {
		jeu.getPiece1().tournerHoraire();
		piece1.setRotate(jeu.getPiece1().getDegreRotation());
	}

	@FXML
	void rotationPiece2(ScrollEvent event) {
		jeu.getPiece2().tournerHoraire();
		piece2.setRotate(jeu.getPiece2().getDegreRotation());
		System.out.println(piece2.getRotate());
	}

	@FXML
	void rotationPiece3(ScrollEvent event) {
		jeu.getPiece3().tournerHoraire();
		piece3.setRotate(jeu.getPiece3().getDegreRotation());
	}

	@FXML
	void PieceDragueFini(MouseEvent event) {
		return;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		jeu = new Jeux();
		TypeCase[][] plateau = jeu.getPlateau();

		plateau[0][1] = TypeCase.Vide;
		plateau[0][2] = TypeCase.Cochon;
		plateau[1][0] = TypeCase.Vide;
		plateau[1][1] = TypeCase.Vide;
		plateau[1][2] = TypeCase.Vide;
		plateau[1][3] = TypeCase.Vide;
		plateau[2][0] = TypeCase.Vide;
		plateau[2][1] = TypeCase.Vide;
		plateau[2][2] = TypeCase.Vide;
		plateau[2][3] = TypeCase.Loup;
		plateau[3][1] = TypeCase.Vide;
		plateau[3][2] = TypeCase.Vide;
		plateau[3][3] = TypeCase.Vide;

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
		switch (plateau[0][2]) {
		case Vide:
			case2.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case2.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case2.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[1][0]) {
		case Vide:
			case3.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case3.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case3.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[1][1]) {
		case Vide:
			case4.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case4.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case4.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[1][2]) {
		case Vide:
			case5.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case5.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case5.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[1][3]) {
		case Vide:
			case6.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case6.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case6.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[2][0]) {
		case Vide:
			case7.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case7.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case7.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[2][1]) {
		case Vide:
			case8.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case8.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case8.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[2][2]) {
		case Vide:
			case9.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case9.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case9.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[2][3]) {
		case Vide:
			case10.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case10.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case10.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[3][1]) {
		case Vide:
			case11.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case11.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case11.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[3][2]) {
		case Vide:
			case12.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case12.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case12.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}
		switch (plateau[3][3]) {
		case Vide:
			case13.setImage(new Image("imageVide.PNG"));
			break;
		case Cochon:
			case13.setImage(new Image("imageCochon.PNG"));
			break;
		case Loup:
			case13.setImage(new Image("imageLoup.PNG"));
		default:
			break;
		}

		switch (jeu.getPiece1().getTypePiece()) {
		case Bois:
			piece1.setImage(new Image("imagePieceBois.PNG"));
			break;
		case Brique:
			piece1.setImage(new Image("imagePieceBrique.PNG"));
			break;
		case Paille:
			piece1.setImage(new Image("imagePiecePaille.PNG"));
			break;

		default:
			break;
		}
		switch (jeu.getPiece2().getTypePiece()) {
		case Bois:
			piece2.setImage(new Image("imagePieceBois.PNG"));
			break;
		case Brique:
			piece2.setImage(new Image("imagePieceBrique.PNG"));
			break;
		case Paille:
			piece2.setImage(new Image("imagePiecePaille.PNG"));
			break;

		default:
			break;
		}
		switch (jeu.getPiece3().getTypePiece()) {
		case Bois:
			piece3.setImage(new Image("imagePieceBois.PNG"));
			break;
		case Brique:
			piece3.setImage(new Image("imagePieceBrique.PNG"));
			break;
		case Paille:
			piece3.setImage(new Image("imagePiecePaille.PNG"));
			break;

		default:
			break;
		}

	}

}
