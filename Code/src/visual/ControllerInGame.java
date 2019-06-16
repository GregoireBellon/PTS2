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

	private boolean piece1Placee;

	@FXML
	private ImageView Piece2;

	private boolean piece2Placee;

	@FXML
	private ImageView Piece3;

	private boolean piece3Placee;

	/*
	 * private double[][] positionDepartCases = { { 230, 140 }, { 340, 140 }, { 120,
	 * 250 }, { 230, 250 }, { 340, 250 }, { 450, 250 }, { 120, 360 }, { 230, 360 },
	 * { 340, 360 }, { 450, 360 }, { 230, 470 }, { 340, 470 }, { 450, 470 } };
	 */
	private double[][] positionDepartCases = { { 10, 30 }, { 120, 30 }, { 230, 30 }, { 340, 30 }, { 450, 30 },
			{ 560, 30 }, { 10, 140 }, { 120, 140 }, { 230, 140 }, { 340, 140 }, { 450, 140 }, { 560, 140 }, { 10, 250 },
			{ 120, 250 }, { 230, 250 }, { 340, 250 }, { 450, 250 }, { 560, 250 }, { 10, 250 }, { 120, 360 },
			{ 230, 360 }, { 340, 360 }, { 450, 360 }, { 560, 360 }, { 10, 470 }, { 120, 470 }, { 230, 470 },
			{ 340, 470 }, { 450, 470 }, { 560, 470 }, { 10, 580 }, { 120, 580 }, { 230, 580 }, { 340, 580 },
			{ 450, 580 }, { 560, 580 } };
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
		piece1Placee = false;
		suiviPieceSouris(jeu.getPiece1(), event, 1);
	}

	@FXML
	void activerDeplacementPiece2(MouseEvent event) {
		piece2Placee = false;
		suiviPieceSouris(jeu.getPiece2(), event, 2);
	}

	@FXML
	void activerDeplacementPiece3(MouseEvent event) {
		piece3Placee = false;
		suiviPieceSouris(jeu.getPiece3(), event, 3);
	}

	private void deplacerImage(ImageView image, double x, double y) {
		double fromX = image.getLayoutX();
		double fromY = image.getLayoutY();
		double toX = x;
		double toY = y;

		toX -= image.getLayoutX();
		toY -= image.getLayoutY();

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
		placerPiece(1, jeu.getPiece1(), event);
	}

	@FXML
	void PieceDragueFini2(MouseEvent event) {
		placerPiece(2, jeu.getPiece2(), event);
	}

	@FXML
	void PieceDragueFini3(MouseEvent event) {
		placerPiece(3, jeu.getPiece3(), event);
	}

	private boolean placementAutoriser(int numPiece, int numCase, int numRotation) {
		int xCase = (numCase % 6) - 2;
		int yCase = (numCase / 6) - 1;
		if ((numCase % 6) == 0) {
			xCase = 4;
		}
		if (numCase > 30) {
			yCase = 4;
		}

		int xCaseMaison = Piece.obtenirEmplacementMaison(xCase, yCase, numPiece - 1, numRotation)[0];
		int yCaseMaison = Piece.obtenirEmplacementMaison(xCase, yCase, numPiece - 1, numRotation)[1];
		/*
		 * int xCase = -1; int yCase = -1; switch (numCase) { case 1: xCase =
		 * Piece.obtenirEmplacementMaison(1, 0, numPiece - 1, numRotation)[0]; yCase =
		 * Piece.obtenirEmplacementMaison(1, 0, numPiece - 1, numRotation)[1]; break;
		 * case 2: xCase = Piece.obtenirEmplacementMaison(2, 0, numPiece - 1,
		 * numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(2, 0, numPiece - 1,
		 * numRotation)[1]; break; case 3: xCase = Piece.obtenirEmplacementMaison(0, 1,
		 * numPiece - 1, numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(0, 1,
		 * numPiece - 1, numRotation)[1]; break; case 4: xCase =
		 * Piece.obtenirEmplacementMaison(1, 1, numPiece - 1, numRotation)[0]; yCase =
		 * Piece.obtenirEmplacementMaison(1, 1, numPiece - 1, numRotation)[1]; break;
		 * case 5: xCase = Piece.obtenirEmplacementMaison(2, 1, numPiece - 1,
		 * numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(2, 1, numPiece - 1,
		 * numRotation)[1]; break; case 6: xCase = Piece.obtenirEmplacementMaison(3, 1,
		 * numPiece - 1, numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(3, 1,
		 * numPiece - 1, numRotation)[1]; break; case 7: xCase =
		 * Piece.obtenirEmplacementMaison(0, 2, numPiece - 1, numRotation)[0]; yCase =
		 * Piece.obtenirEmplacementMaison(0, 2, numPiece - 1, numRotation)[1]; break;
		 * case 8: xCase = Piece.obtenirEmplacementMaison(1, 2, numPiece - 1,
		 * numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(1, 2, numPiece - 1,
		 * numRotation)[1]; break; case 9: xCase = Piece.obtenirEmplacementMaison(2, 2,
		 * numPiece - 1, numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(2, 2,
		 * numPiece - 1, numRotation)[1]; break; case 10: xCase =
		 * Piece.obtenirEmplacementMaison(3, 2, numPiece - 1, numRotation)[0]; yCase =
		 * Piece.obtenirEmplacementMaison(3, 2, numPiece - 1, numRotation)[1]; break;
		 * case 11: xCase = Piece.obtenirEmplacementMaison(1, 3, numPiece - 1,
		 * numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(1, 3, numPiece - 1,
		 * numRotation)[1]; break; case 12: xCase = Piece.obtenirEmplacementMaison(2, 3,
		 * numPiece - 1, numRotation)[0]; yCase = Piece.obtenirEmplacementMaison(2, 3,
		 * numPiece - 1, numRotation)[1]; break; case 13: xCase =
		 * Piece.obtenirEmplacementMaison(3, 3, numPiece - 1, numRotation)[0]; yCase =
		 * Piece.obtenirEmplacementMaison(3, 3, numPiece - 1, numRotation)[1]; break;
		 *
		 * default: break; }
		 */
		if ((xCase != -2) && (yCase != -2)) {
			System.out.println("Case ciblée par la maison: " + xCaseMaison + " ; " + yCaseMaison);
			switch (numPiece) {
			case 1:
				return jeu.getPiece1().verifPlacement(yCaseMaison, xCaseMaison, Contexte.Diurne);
			case 2:
				return jeu.getPiece2().verifPlacement(yCaseMaison, xCaseMaison, Contexte.Diurne);
			case 3:
				return jeu.getPiece3().verifPlacement(yCaseMaison, xCaseMaison, Contexte.Diurne);
			default:
				break;
			}
		}
		return true;
	}

	public void placerPiece(int numPiece, Piece p, MouseEvent me) {
		ImageView image = Piece1;
		switch (numPiece) {
		case 1:
			image = Piece1;
			break;
		case 2:
			image = Piece2;
			break;
		case 3:
			image = Piece3;
			break;

		default:
			break;
		}
		double minDistance = Integer.MAX_VALUE;
		double fromX = image.getX() + positionDepartPieces[numPiece - 1][0];
		double fromY = image.getY() + positionDepartPieces[numPiece - 1][1];
		int numCase = -1;
		for (int i = 0; i < 36; i++) {
			double distance = Math.sqrt(
					Math.pow((fromX - positionDepartCases[i][0]), 2) + Math.pow(fromY - positionDepartCases[i][1], 2));
			if (distance < minDistance) {
				minDistance = distance;
				numCase = i;
			}
		}
		if ((minDistance < 100) && placementAutoriser(numPiece, numCase + 1, p.getDegreRotation() / 90)) {
			deplacerImage(image, positionDepartCases[numCase][0], positionDepartCases[numCase][1]);
			switch (numPiece) {
			case 1:
				piece1Placee = true;
				break;
			case 2:
				piece2Placee = true;
				break;
			case 3:
				piece3Placee = true;
				break;

			default:
				break;
			}
		}
		if (piece1Placee && piece2Placee && piece3Placee) {
			System.out.println("GAGNÉÉÉÉÉÉ");
		}
		jeu.afficherPlateau();
	}

	@FXML
	void rotationPiece1(ScrollEvent event) {
		jeu.getPiece1().tournerHoraire();
		Piece1 = jeu.getPiece1().getImagePiece();
		jeu.getPiece1().afficherPiece();
		piece1Placee = false;
	}

	@FXML
	void rotationPiece2(ScrollEvent event) {
		jeu.getPiece2().tournerHoraire();
		Piece2 = jeu.getPiece2().getImagePiece();
		jeu.getPiece2().afficherPiece();
		piece2Placee = false;
	}

	@FXML
	void rotationPiece3(ScrollEvent event) {
		jeu.getPiece3().tournerHoraire();
		Piece3 = jeu.getPiece3().getImagePiece();
		jeu.getPiece3().afficherPiece();
		piece3Placee = false;
	}

	private void suiviPieceSouris(Piece piece, MouseEvent e, int numPiece) {
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
