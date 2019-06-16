package visual;

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
import poo.Contexte;
import poo.Jeux;
import poo.Piece;

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

	private double[][] positionDepartCases = { { 230, 140 }, { 340, 140 }, { 120, 250 }, { 230, 250 }, { 340, 250 },
			{ 450, 250 }, { 120, 360 }, { 230, 360 }, { 340, 360 }, { 450, 360 }, { 230, 470 }, { 340, 470 },
			{ 450, 470 } };
	private double[][] positionDepartPieces = { { 671, 14 }, { 671, 140 }, { 671, 390 } };
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
		jeu.getPiece1().enlever();
		suiviPieceSouris(jeu.getPiece1(), event);
	}

	@FXML
	void activerDeplacementPiece2(MouseEvent event) {
		jeu.getPiece2().enlever();
		suiviPieceSouris(jeu.getPiece2(), event);
	}

	@FXML
	void activerDeplacementPiece3(MouseEvent event) {
		jeu.getPiece3().enlever();
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
				image.setImage(new Image("imagesDuJeu/imageCochon.PNG"));
				break;
			case Vide:
				image.setImage(new Image("imagesDuJeu/imageVide.PNG"));
				break;
			case Loup:
				image.setImage(new Image("imagesDuJeu/imageLoup.PNG"));
				break;
			default:
				image.setImage(new Image("imagesDuJeu/imageLoup.PNG"));
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
		placerPiece(1, jeu.getPiece1());
	}

	@FXML
	void PieceDragueFini2(MouseEvent event) {
		placerPiece(2, jeu.getPiece2());
	}

	@FXML
	void PieceDragueFini3(MouseEvent event) {
		placerPiece(3, jeu.getPiece3());
	}

	private boolean placementAutoriser(int numPiece, int numCase, int numRotation) {
		int xCase = -1;
		int yCase = -1;
		switch (numCase) {
		case 1:
			xCase = Piece.obtenirEmplacementMaison(1, 0, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(1, 0, numPiece - 1, numRotation)[1];
			break;
		case 2:
			xCase = Piece.obtenirEmplacementMaison(2, 0, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(2, 0, numPiece - 1, numRotation)[1];
			break;
		case 3:
			xCase = Piece.obtenirEmplacementMaison(0, 1, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(0, 1, numPiece - 1, numRotation)[1];
			break;
		case 4:
			xCase = Piece.obtenirEmplacementMaison(1, 1, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(1, 1, numPiece - 1, numRotation)[1];
			break;
		case 5:
			xCase = Piece.obtenirEmplacementMaison(2, 1, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(2, 1, numPiece - 1, numRotation)[1];
			break;
		case 6:
			xCase = Piece.obtenirEmplacementMaison(3, 1, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(3, 1, numPiece - 1, numRotation)[1];
			break;
		case 7:
			xCase = Piece.obtenirEmplacementMaison(0, 2, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(0, 2, numPiece - 1, numRotation)[1];
			break;
		case 8:
			xCase = Piece.obtenirEmplacementMaison(1, 2, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(1, 2, numPiece - 1, numRotation)[1];
			break;
		case 9:
			xCase = Piece.obtenirEmplacementMaison(2, 2, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(2, 2, numPiece - 1, numRotation)[1];
			break;
		case 10:
			xCase = Piece.obtenirEmplacementMaison(3, 2, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(3, 2, numPiece - 1, numRotation)[1];
			break;
		case 11:
			xCase = Piece.obtenirEmplacementMaison(1, 3, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(1, 3, numPiece - 1, numRotation)[1];
			break;
		case 12:
			xCase = Piece.obtenirEmplacementMaison(2, 3, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(2, 3, numPiece - 1, numRotation)[1];
			break;
		case 13:
			xCase = Piece.obtenirEmplacementMaison(3, 3, numPiece - 1, numRotation)[0];
			yCase = Piece.obtenirEmplacementMaison(3, 3, numPiece - 1, numRotation)[1];
			break;

		default:
			break;
		}
		if ((xCase != -1) && (yCase != -1)) {
			System.out.println("Case ciblée : " + xCase + " ; " + yCase);
			switch (numPiece) {
			case 1:
				return jeu.getPiece1().placer(yCase, xCase, Contexte.Diurne);
			case 2:
				return jeu.getPiece2().placer(yCase, xCase, Contexte.Diurne);
			case 3:
				return jeu.getPiece3().placer(yCase, xCase, Contexte.Diurne);
			default:
				break;
			}
		}
		return true;
	}

	public void placerPiece(int numPiece, Piece p) {
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
		if ((minDistance < 500) && placementAutoriser(numPiece, numCase + 1, p.getDegreRotation() / 90)) {
			deplacerImage(image, positionDepartCases[numCase][0], positionDepartCases[numCase][1]);

		}
		if (jeu.getDefi().verifierDefi()) {
			System.out.println("GAGNÉÉÉÉÉÉ");
		}
		jeu.afficherPlateau();
	}

	@FXML
	void rotationPiece1(ScrollEvent event) {
		jeu.getPiece1().tournerHoraire();
		Piece1 = jeu.getPiece1().getImagePiece();
		jeu.getPiece1().afficherPiece();
		jeu.getPiece1().enlever();
	}

	@FXML
	void rotationPiece2(ScrollEvent event) {
		jeu.getPiece2().tournerHoraire();
		Piece2 = jeu.getPiece2().getImagePiece();
		jeu.getPiece2().afficherPiece();
		jeu.getPiece2().enlever();
	}

	@FXML
	void rotationPiece3(ScrollEvent event) {
		jeu.getPiece3().tournerHoraire();
		Piece3 = jeu.getPiece3().getImagePiece();
		jeu.getPiece3().afficherPiece();
		jeu.getPiece3().enlever();
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
