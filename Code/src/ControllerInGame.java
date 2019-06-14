import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ControllerInGame implements Initializable {

	private PathTransition animationToSouris = new PathTransition();
	@FXML
	private Button boutonAbandonner;
	@FXML
	private Button boutonSolution;

	@FXML
	private ImageView imagePlateau1;
	@FXML
	private ImageView imagePlateau10;
	@FXML
	private ImageView imagePlateau11;

	@FXML
	private ImageView imagePlateau12;

	@FXML
	private ImageView imagePlateau13;

	@FXML
	private ImageView imagePlateau2;

	@FXML
	private ImageView imagePlateau3;

	@FXML
	private ImageView imagePlateau4;

	@FXML
	private ImageView imagePlateau5;

	@FXML
	private ImageView imagePlateau6;

	@FXML
	private ImageView imagePlateau7;

	@FXML
	private ImageView imagePlateau8;

	@FXML
	private ImageView imagePlateau9;

	private Jeux jeu;

	private List<ImageView> listCases;

	@FXML
	private ImageView Piece1;

	@FXML
	private ImageView Piece2;

	@FXML
	private ImageView Piece3;

	private double[][] positionDepartCases = { { 179, 140 }, { 289, 140 }, { 69, 250 }, { 179, 250 }, { 289, 250 },
			{ 399, 250 }, { 69, 360 }, { 179, 360 }, { 289, 360 }, { 399, 360 }, { 179, 470 }, { 289, 470 },
			{ 399, 470 } };
	private double[][] positionDepartPieces = { { 640, 64 }, { 640, 305 }, { 640, } };
	@FXML
	private AnchorPane root;

	@FXML
	private Text TextTemps;

	private double[][] transformCursorPosition = { { 0, 0 }, { 0, 0 }, { 0, 0 } };

	@FXML
	void abandonner(ActionEvent event) {

	}

	@FXML
	void activerDeplacementPiece1(MouseEvent event) {
		suiviPieceSouris(jeu.getPiece1(), event);
	}

	@FXML
	void activerDeplacementPiece2(MouseEvent event) {
		suiviPieceSouris(jeu.getPiece2(), event);
	}

	@FXML
	void activerDeplacementPiece3(MouseEvent event) {
		suiviPieceSouris(jeu.getPiece3(), event);
	}

	private void deplacerImage(ImageView image, double x, double y) {
		double fromX = image.getLayoutX();
		double fromY = image.getLayoutY();
		double toX = x;
		double toY = y;

		toX -= image.getLayoutX() /*- (image.getLayoutBounds().getWidth() / 2)*/;
		toY -= image.getLayoutY() /*- (image.getLayoutBounds().getHeight() / 2)*/;

		Path path = new Path();
		path.getElements().add(new MoveTo(fromX, fromY));
		path.getElements().add(new LineTo(toX, toY));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setPath(path);
		pathTransition.setDuration(Duration.millis(0));
		pathTransition.setNode(image);
		pathTransition.play();

		image.setX(toX);
		image.setY(toY);

	}

	@FXML
	void donnerSolution(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Jeux jeu = new Jeux();
		this.jeu = jeu;
		jeu.getPiece1().setImagePiece(Piece1);
		jeu.getPiece2().setImagePiece(Piece2);
		jeu.getPiece3().setImagePiece(Piece3);

		listCases = new ArrayList<>();

		listCases.add(imagePlateau1);
		listCases.add(imagePlateau2);
		listCases.add(imagePlateau3);
		listCases.add(imagePlateau4);
		listCases.add(imagePlateau5);
		listCases.add(imagePlateau6);
		listCases.add(imagePlateau7);
		listCases.add(imagePlateau8);
		listCases.add(imagePlateau9);
		listCases.add(imagePlateau10);
		listCases.add(imagePlateau11);
		listCases.add(imagePlateau12);
		listCases.add(imagePlateau13);
		int i = 0;
		int j = 0;
		jeu.afficherPlateau();
		for (int k = 0; k < listCases.size(); k++) {
			ImageView image = listCases.get(k);
			switch (jeu.getPlateau()[j][i]) {
			case Cochon:
				image.setImage(new Image("imageCochon.PNG"));
				break;
			case Vide:
				image.setImage(new Image("imageVide.PNG"));
				break;
			case Loup:
				image.setImage(new Image("imageLoup.PNG"));
				break;
			default:
				image.setImage(new Image("imageLoup.PNG"));
				k--;
				break;
			}

			i++;
			if (i > 3) {
				i = 0;
				j++;
			}
		}

	}

	@FXML
	void PieceDragueFini1(MouseEvent event) {
		placerPiece(1);
	}

	@FXML
	void PieceDragueFini2(MouseEvent event) {
		placerPiece(2);
	}

	@FXML
	void PieceDragueFini3(MouseEvent event) {
		placerPiece(3);
	}

	private boolean placementAutoriser(int numPiece, int numCase) {
		int xCase = -1;
		int yCase = -1;
		switch (numCase) {
		case 1:
			xCase = 0;
			yCase = 1;
			break;
		case 2:
			xCase = 0;
			yCase = 2;
			break;
		case 3:
			xCase = 1;
			yCase = 0;
			break;
		case 4:
			xCase = 1;
			yCase = 1;
			break;
		case 5:
			xCase = 1;
			yCase = 2;
			break;
		case 6:
			xCase = 1;
			yCase = 3;
			break;
		case 7:
			xCase = 2;
			yCase = 0;
			break;
		case 8:
			xCase = 2;
			yCase = 1;
			break;
		case 9:
			xCase = 2;
			yCase = 2;
			break;
		case 10:
			xCase = 2;
			yCase = 3;
			break;
		case 11:
			xCase = 3;
			yCase = 1;
			break;
		case 12:
			xCase = 3;
			yCase = 2;
			break;
		case 13:
			xCase = 3;
			yCase = 3;
			break;

		default:
			break;
		}
		if ((xCase != -1) && (yCase != -1)) {
			switch (numPiece) {
			case 1:
				return jeu.getPiece1().placerPiece(xCase, yCase);
			case 2:
				return jeu.getPiece2().placerPiece(xCase, yCase);
			case 3:
				return jeu.getPiece3().placerPiece(xCase, yCase);
			default:
				break;
			}
		}
		return true;
	}

	public void placerPiece(int numPiece) {
		ImageView image = Piece1;
		switch (numPiece) {
		case 1:
			image = Piece1;
			jeu.getPiece1().enlever();
			break;
		case 2:
			image = Piece2;
			jeu.getPiece2().enlever();
			break;
		case 3:
			image = Piece3;
			jeu.getPiece3().enlever();
			break;

		default:
			break;
		}
		double minDistance = Integer.MAX_VALUE;
		double fromX = image.getX() + positionDepartPieces[numPiece - 1][0];
		double fromY = image.getY() + positionDepartPieces[numPiece - 1][1];
		int numCase = -1;
		for (int i = 0; i < 13; i++) {
			double distance = Math.sqrt(
					Math.pow((fromX - positionDepartCases[i][0]), 2) + Math.pow(fromY - positionDepartCases[i][1], 2));
			if (distance < minDistance) {
				minDistance = distance;
				numCase = i;
			}
		}
		if ((minDistance < 100) && placementAutoriser(numPiece, numCase + 1)) {
			switch (numCase) {
			case 0:
				deplacerImage(image, positionDepartCases[0][0], positionDepartCases[0][1]);
				break;
			case 1:
				deplacerImage(image, positionDepartCases[1][0], positionDepartCases[1][1]);
				break;
			case 2:
				deplacerImage(image, positionDepartCases[2][0], positionDepartCases[2][1]);
				break;
			case 3:
				deplacerImage(image, positionDepartCases[3][0], positionDepartCases[3][1]);
				break;
			case 4:
				deplacerImage(image, positionDepartCases[4][0], positionDepartCases[4][1]);
				break;
			case 5:
				deplacerImage(image, positionDepartCases[5][0], positionDepartCases[5][1]);
				break;
			case 6:
				deplacerImage(image, positionDepartCases[6][0], positionDepartCases[6][1]);
				break;
			case 7:
				deplacerImage(image, positionDepartCases[7][0], positionDepartCases[7][1]);
				break;
			case 8:
				deplacerImage(image, positionDepartCases[8][0], positionDepartCases[8][1]);
				break;
			case 9:
				deplacerImage(image, positionDepartCases[9][0], positionDepartCases[9][1]);
				break;
			case 10:
				deplacerImage(image, positionDepartCases[10][0], positionDepartCases[10][1]);
				break;
			case 11:
				deplacerImage(image, positionDepartCases[11][0], positionDepartCases[11][1]);
				break;
			case 12:
				deplacerImage(image, positionDepartCases[12][0], positionDepartCases[12][1]);
				break;

			default:
				break;
			}
		}

	}

	@FXML
	void rotationPiece1(ScrollEvent event) {
		jeu.getPiece1().tournerHoraire();
		jeu.getPiece1().afficherPiece();
	}

	@FXML
	void rotationPiece2(ScrollEvent event) {
		jeu.getPiece2().tournerHoraire();
		jeu.getPiece2().afficherPiece();
	}

	@FXML
	void rotationPiece3(ScrollEvent event) {
		jeu.getPiece3().tournerHoraire();
		jeu.getPiece3().afficherPiece();
	}

	private void suiviPieceSouris(Piece piece, MouseEvent e) {
		piece.getImagePiece().cursorProperty().setValue(Cursor.NONE);
		animationToSouris.setNode(null);
		animationToSouris.stop();
		double fromX = piece.getImagePiece().getLayoutBounds().getWidth() / 2;
		double fromY = piece.getImagePiece().getLayoutBounds().getHeight() / 2;
		double toX = e.getSceneX() - piece.getImagePiece().getFitWidth();
		double toY = e.getSceneY() - piece.getImagePiece().getFitHeight();

		toX -= piece.getImagePiece().getLayoutX() - (piece.getImagePiece().getLayoutBounds().getWidth() / 2);
		toY -= piece.getImagePiece().getLayoutY() - (piece.getImagePiece().getLayoutBounds().getHeight() / 2);

		Path path = new Path();
		path.getElements().add(new MoveTo(fromX, fromY));
		path.getElements().add(new LineTo(toX, toY));
		animationToSouris.setPath(path);
		animationToSouris.setDuration(Duration.millis(0));
		animationToSouris.setNode(piece.getImagePiece());
		animationToSouris.play();
		animationToSouris.setOnFinished(event -> {
		});

		piece.getImagePiece().setX(toX);
		piece.getImagePiece().setY(toY);
		piece.getImagePiece().cursorProperty().setValue(Cursor.DEFAULT);

	}
}
