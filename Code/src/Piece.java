import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;

public class Piece {
	private boolean contenirCochon; // Servira pour les proprietes du mode nocturne
	private Map<String, Integer> coordMaison = new HashMap<String, Integer>();
	private int degreRotation; // Ne devrait pas servir
	// pour JavaFX
	private ImageView imagePiece;
	private Jeux jeu;
	private TypeCase[][] piece;
	// position en X sur le plateau
	private Integer posX = null;
	// position en Y sur le plateau
	private Integer posY = null;

	// Contexte dans lequel elle a ete place
	private TypePiece typePiece;

	/**
	 * Cr�e une pi�ce
	 *
	 * @param type correspond au type de pi�ce a cr�er
	 */
	public Piece(TypePiece type, Jeux jeu) {
		this.jeu = jeu;
		typePiece = type;
		piece = new TypeCase[3][3];
		switch (type) {
		case Paille: // Cree une piece avec la maison de paille
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Bois: // Cree une piece avec la maison de bois
			piece[1][0] = TypeCase.Jardin;
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Brique: // Cree une piece avec la maison de brique
			piece[1][2] = TypeCase.Jardin;
			piece[2][0] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			piece[2][2] = TypeCase.Maison;
			coordMaison.put("x", 2);
			coordMaison.put("y", 2);
		}
	}

	/**
	 * Affiche la piece en console
	 */
	public void afficherPiece() {
		StringBuilder aff = new StringBuilder();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null) {
					aff.append(piece[i][j]);
				} else {
					aff.append("   ");
				}
			}
			aff.append("\n");
		}
		System.out.println(aff);
	}

	public void enlever() {
		if ((posX != null) && (posY != null)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (piece[i][j] != null) {
						if (piece[i][j] == TypeCase.Jardin) {
							jeu.setPlateau(TypeCase.Vide, (posX + i) - coordMaison.get("x"),
									(posY + j) - coordMaison.get("y"));
						}
						if (piece[i][j] == TypeCase.Maison) {
							if (isContenirCochon()) {
								jeu.setPlateau(TypeCase.Cochon, posX, posY);
							} else {
								jeu.setPlateau(TypeCase.Vide, posX, posY);
							}
						}
					}
				}
			}
			posX = null;
			posY = null;
		} else {
			System.out.println("Piece non placee");
		}

	}

	public int getDegreRotation() {
		return degreRotation;
	}

	public ImageView getImagePiece() {
		return imagePiece;
	}

	public TypeCase[][] getPiece() {
		return piece;
	}

	public TypePiece getTypePiece() {
		return typePiece;
	}

	public boolean isContenirCochon() {
		return contenirCochon;
	}

	public void Placer(int x, int y, Contexte contexte) {
		if (verifPlacement(x, y, contexte)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (piece[i][j] != null) {
						if (piece[i][j] == TypeCase.Jardin) {
							jeu.setPlateau(piece[i][j], (x + i) - coordMaison.get("x"), (y + j) - coordMaison.get("y"));
						}
						if (piece[i][j] == TypeCase.Maison) {
							jeu.setPlateau(piece[i][j], x, y);
						}
					}
				}
			}
			posX = x;
			posY = y;
		} else {
			System.out.println("Impossible de placer");
			return;
		}

	}

	public void setContenirCochon(boolean contenirCochon) {
		this.contenirCochon = contenirCochon;
	}

	public void setDegreRotation(int degreRotation) {
		this.degreRotation = degreRotation;
	}

	public void setImagePiece(ImageView piece1) {
		imagePiece = piece1;
	}

	public void setPiece(TypeCase[][] piece) {
		this.piece = piece;
	}

	public void setTypePiece(TypePiece typePiece) {
		this.typePiece = typePiece;
	}

	/**
	 * Permet de tourner la pi�ce de 90� vers la gauche
	 */
	public void tournerAntiHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null) {
					if (i == 0) {
						pieceTournee[2 - j][i] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 0);
						}
					}
					if (i == 1) {
						pieceTournee[2 - j][i] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 1);
						}
					}
					if (i == 2) {
						pieceTournee[2 - j][i] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 2);
						}
					}
				}
			}
		}
		piece = pieceTournee;
		degreRotation -= 90;
		degreRotation = degreRotation % 360;
	}

	/**
	 * Permet de tourner la pi�ce de 90� vers la droite
	 */
	public void tournerHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) { // Parcourt le tableau de la piece
			for (int j = 0; j <= 2; j++) { //
				if (piece[i][j] != null) { // A factoriser ( pieceTournee[j][2-i])
					if (i == 0) {
						pieceTournee[j][2 - i] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 2);
						}

					}
					if (i == 1) {
						pieceTournee[j][1] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 1);
						}
					}
					if (i == 2) {
						pieceTournee[j][0] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 0);
						}
					}
				}
			}
		}
		piece = pieceTournee;
		degreRotation += 90;
		degreRotation = degreRotation % 360;
	}

	public boolean verifPlacement(int x, int y, Contexte contexte) {

		if ((x > 3) || (x < 0) || (y > 3) || (y < 0)) {
			return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// Si la piece est un jardin et que la case sur laquelle elle doit etre placee
				// ne fait pas parti du plateau on return false
				if (piece[i][j] == TypeCase.Jardin) {
					if ((((x + i) - coordMaison.get("x")) > 3) || (((x + i) - coordMaison.get("x")) < 0)
							|| (((y + j) - coordMaison.get("y")) > 3) || (((y + j) - coordMaison.get("y")) < 0)) {
						return false;
					}
					if (jeu.getPlateau()[(x + i) - coordMaison.get("x")][(y + j)
							- coordMaison.get("y")] != TypeCase.Vide) {
						return false;
					}
				}

				if (contexte == Contexte.Diurne) {

					// si le contexte est diurne
					// Si la piece est une Maison et que la case sur laquelle elle doit etre placee
					// n'est pas vide on return false

					if ((piece[i][j] == TypeCase.Maison) && (jeu.getPlateau()[x][y] != TypeCase.Vide)) {
						return false;
					}
				}

				// Contexte Nocturne
				// Si la piece est une Maison et que la case sur laquelle elle doit etre plac�
				// n'est pas un cochon on return false
				if ((contexte == Contexte.Nocturne) && (piece[i][j] == TypeCase.Maison)
						&& ((jeu.getPlateau()[i][j] != TypeCase.Cochon) || (jeu.getPlateau()[x][y] != TypeCase.Vide))) {
					return false;
				}
			}
		}
		return true;
	}

}
