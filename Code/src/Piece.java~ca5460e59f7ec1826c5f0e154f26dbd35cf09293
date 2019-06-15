import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;

public class Piece {
	private TypeCase[][] casesPiece;
	private boolean contenirCochon; // Servira pour les proprietes du mode nocturne
	private Map<String, Integer> coordMaison = new HashMap<String, Integer>();
	private int degreRotation; // Ne devrait pas servir
	// pour JavaFX
	private ImageView imagePiece;
	private Jeux jeu;
	// position en X sur le plateau
	private int posX;
	// position en Y sur le plateau
	private int posY;

	// Contexte dans lequel elle a ete place
	private TypePiece typePiece;

	/**
	 * Crï¿½e une piï¿½ce
	 *
	 * @param type correspond au type de piï¿½ce a crï¿½er
	 */
	public Piece(TypePiece type, Jeux jeu) {
		this.jeu = jeu;
		typePiece = type;
		casesPiece = new TypeCase[3][3];
		posX = -1;
		posY = -1;
		switch (type) {
		case Paille: // Cree une piece avec la maison de paille
			casesPiece[1][1] = TypeCase.Maison;
			casesPiece[1][2] = TypeCase.Jardin;
			casesPiece[2][1] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Bois: // Cree une piece avec la maison de bois
			casesPiece[1][0] = TypeCase.Jardin;
			casesPiece[1][1] = TypeCase.Maison;
			casesPiece[1][2] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Brique: // Cree une piece avec la maison de brique
			casesPiece[0][0] = TypeCase.Jardin;
			casesPiece[0][1] = TypeCase.Jardin;
			casesPiece[1][2] = TypeCase.Jardin;
			casesPiece[0][2] = TypeCase.Maison;
			coordMaison.put("x", 0);
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
				if (casesPiece[i][j] != null) {
					aff.append(casesPiece[i][j]);
				} else {
					aff.append("   ");
				}
			}
			aff.append("\n");
		}
		System.out.println(aff);
	}

	public void enlever() {
		if ((posX != -1) && (posY != -1)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (casesPiece[i][j] != null) {
						if (casesPiece[i][j] == TypeCase.Jardin) {
							jeu.setPlateau(TypeCase.Vide, (posX + i), (posY + j));
						}
						if (casesPiece[i][j] == TypeCase.Maison) {
							if (isContenirCochon()) {
								jeu.setPlateau(TypeCase.Cochon, posX + i, posY + j);
							} else {
								jeu.setPlateau(TypeCase.Vide, posX + i, posY + j);
							}
						}
					}
				}
			}
			posX = -1;
			posY = -1;
		} else {
		}
		jeu.afficherPlateau();
	}

	public int getDegreRotation() {
		return degreRotation;
	}

	public ImageView getImagePiece() {
		return imagePiece;
	}

	public TypeCase[][] getPiece() {
		return casesPiece;
	}

	public TypePiece getTypePiece() {
		return typePiece;
	}

	public boolean isContenirCochon() {
		return contenirCochon;
	}

	public boolean placerPiece(int x, int y) {
		if (verifierPlacementPiece(x, y)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (casesPiece[i][j] != null) {
						if (casesPiece[i][j] == TypeCase.Jardin) {
							jeu.setPlateau(TypeCase.Jardin, x + i, y + j);
						}
						if (casesPiece[i][j] == TypeCase.Maison) {
							jeu.setPlateau(TypeCase.Maison, x + i, y + j);
						}
					}
				}
			}
			posX = x;
			posY = y;
			System.err.println("Placée en  : " + posX + " ; " + posY);
			jeu.afficherPlateau();
			return true;
		} else {
			return false;
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
		casesPiece = piece;
	}

	public void setTypePiece(TypePiece typePiece) {
		this.typePiece = typePiece;
	}

	/**
	 * Permet de tourner la piï¿½ce de 90ï¿½ vers la gauche
	 */
	public void tournerAntiHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (casesPiece[i][j] != null) {
					if (i == 0) {
						pieceTournee[2 - j][i] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 0);
						}
					}
					if (i == 1) {
						pieceTournee[2 - j][i] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 1);
						}
					}
					if (i == 2) {
						pieceTournee[2 - j][i] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2 - j);
							coordMaison.put("y", 2);
						}
					}
				}
			}
		}
		casesPiece = pieceTournee;
		degreRotation -= 90;
		degreRotation = degreRotation % 360;
	}

	/**
	 * Permet de tourner la piï¿½ce de 90ï¿½ vers la droite
	 */
	public void tournerHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) { // Parcourt le tableau de la piece
			for (int j = 0; j <= 2; j++) { //
				if (casesPiece[i][j] != null) { // A factoriser ( pieceTournee[j][2-i])
					if (i == 0) {
						pieceTournee[j][2 - i] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 2);
						}

					}
					if (i == 1) {
						pieceTournee[j][1] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 1);
						}
					}
					if (i == 2) {
						pieceTournee[j][0] = casesPiece[i][j];
						if (casesPiece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", j);
							coordMaison.put("y", 0);
						}
					}
				}
			}
		}
		casesPiece = pieceTournee;
		degreRotation += 90;
		degreRotation = degreRotation % 360;
	}

	private boolean verifierPlacementPiece(int x, int y) {
		afficherPiece();
		// Verification que les coordonnées sont bien dans le plateau
		if ((x > 3) || (x < 0) || (y > 3) || (y < 0)) {
			return false;
		}
		// Verification que la piece peut etre posée
		for (int i = 0; i < casesPiece.length; i++) {
			for (int j = 0; j < casesPiece.length; j++) {
				if (casesPiece[i][j] != null) {
					TypeCase t = jeu.getPlateau()[x + i][y + j];
					if (t != TypeCase.Vide) {
						System.err.println("Tu essaye de poser sur un " + t.toString() + "en " + (x + i) + ";" + (y + j)
								+ " en dessus d'un " + casesPiece[i][j] + " en " + i + ";" + j);
						return false;
					}
				} else {

				}
			}
		}
		return true;
	}

	public boolean verifPlacement(int x, int y, Contexte contexte) {

		if ((x > 3) || (x < 0) || (y > 3) || (y < 0)) {
			return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// Si la piece est un jardin et que la case sur laquelle elle doit etre placee
				// ne fait pas parti du plateau on return false
				if (casesPiece[i][j] == TypeCase.Jardin) {
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

					if ((casesPiece[i][j] == TypeCase.Maison) && (jeu.getPlateau()[x][y] != TypeCase.Vide)) {
						return false;
					}
				}

				// Contexte Nocturne
				// Si la piece est une Maison et que la case sur laquelle elle doit etre placï¿½
				// n'est pas un cochon on return false
				if ((contexte == Contexte.Nocturne) && (casesPiece[i][j] == TypeCase.Maison)
						&& ((jeu.getPlateau()[i][j] != TypeCase.Cochon) || (jeu.getPlateau()[x][y] != TypeCase.Vide))) {
					return false;
				}
			}
		}
		return true;
	}
}
