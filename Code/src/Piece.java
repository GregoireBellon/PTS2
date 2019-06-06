import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece {
	private TypeCase[][] piece;
	// position en X sur le plateau
	private Integer posX = null;
	// position en Y sur le plateau
	private Integer posY = null;
	// Contexte dans lequel elle a ete place
	private TypePiece typePiece;
	private int degreRotation; // Ne devrait pas servir
	private boolean contenirCochon; // Servira pour les proprietes du mode nocturne
	private Map<String, Integer> coordMaison = new HashMap<String, Integer>();
	
	//pour JavaFX
	private ImageView imagePiece;

	/**
	 * Crï¿½e une piï¿½ce
	 * 
	 * @param type correspond au type de piï¿½ce a crï¿½er
	 */
	public Piece(TypePiece type) {
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
				if (piece[i][j] != null)
					aff.append(piece[i][j]);
				else
					aff.append("   ");
			}
			aff.append("\n");
		}
		System.out.println(aff);
	}

	/**
	 * Permet de tourner la piï¿½ce de 90ï¿½ vers la droite
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

	/**
	 * Permet de tourner la piï¿½ce de 90ï¿½ vers la gauche
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

	public void Placer(int x, int y, Contexte contexte) {
		if (this.verifPlacement(x, y, contexte)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (piece[i][j] != null) {
						if (piece[i][j] == TypeCase.Jardin)
							Jeux.setPlateau(piece[i][j], x + i - coordMaison.get("x"), y + j - coordMaison.get("y"));
						if (piece[i][j] == TypeCase.Maison) {
							if (Jeux.getPlateau()[x][y] == TypeCase.Cochon) {
								this.setContenirCochon(true);
							}
							Jeux.setPlateau(piece[i][j], x, y);

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

	public boolean verifPlacement(int x, int y, Contexte contexte) {

		if (x > 3 || x < 0 || y > 3 || y < 0) // Si les coordonnées entrées ne sont pas bonnes
			return false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// Si la piece est un jardin et que la case sur laquelle elle doit etre placee
				// ne fait pas parti du plateau on return false
				if (piece[i][j] == TypeCase.Jardin) {
					if (x + i - coordMaison.get("x") > 3 || x + i - coordMaison.get("x") < 0
							|| y + j - coordMaison.get("y") > 3 || y + j - coordMaison.get("y") < 0) {
						return false;
					}
					if (Jeux.getPlateau()[x + i - coordMaison.get("x")][y + j - coordMaison.get("y")] != TypeCase.Vide)
						return false;
				}
				
				// si le contexte est diurne
				// Si la piece est une Maison et que la case sur laquelle elle doit etre placee
				// n'est pas vide on return false
				if (piece[i][j] == TypeCase.Maison) {
					if (Jeux.getPlateau()[x][y] != TypeCase.Vide && Jeux.getPlateau()[x][y] != TypeCase.Cochon) {
						return false;
					}
					if (contexte == Contexte.Diurne) {
						if (Jeux.getPlateau()[x][y] != TypeCase.Vide) { 
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public void enlever() {
		if (posX != null && posY != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (piece[i][j] != null) {
						if (piece[i][j] == TypeCase.Jardin)
							Jeux.setPlateau(TypeCase.Vide, posX + i - coordMaison.get("x"),
									posY + j - coordMaison.get("y"));
						if (piece[i][j] == TypeCase.Maison) {
							if (this.isContenirCochon())
								Jeux.setPlateau(TypeCase.Cochon, posX, posY);
							else
								Jeux.setPlateau(TypeCase.Vide, posX, posY);
						}
					}
				}
			}
			if (this.isContenirCochon())
				this.setContenirCochon(false);
			posX = null;
			posY = null;
		} else
			System.out.println("Piece non placee");

	}

	public int getDegreRotation() {
		return degreRotation;
	}

	public void setDegreRotation(int degreRotation) {
		this.degreRotation = degreRotation;
	}

	public TypePiece getTypePiece() {
		return typePiece;
	}

	public void setTypePiece(TypePiece typePiece) {
		this.typePiece = typePiece;
	}

	public boolean isContenirCochon() {
		return contenirCochon;
	}

	public void setContenirCochon(boolean contenirCochon) {
		this.contenirCochon = contenirCochon;
	}

	public TypeCase[][] getPiece() {
		return piece;
	}

	public void setPiece(TypeCase[][] piece) {
		this.piece = piece;
	}

	public ImageView getImagePiece() {
		return imagePiece;
	}

	public void setImagePiece(ImageView piece1) {
		this.imagePiece = piece1;
	}

}
