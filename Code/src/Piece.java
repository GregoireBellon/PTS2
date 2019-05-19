import java.util.Hashtable;

public class Piece {
	private TypeCase[][] piece;
	// position en X sur le plateau
	private Integer posX = null;
	// position en Y sur le plateau
	private Integer posY = null;
	// Contexte dans lequel elle a été placé
	private Contexte contexte;
	private TypePiece typePiece;
	private int degreRotation;
	private boolean contenirCochon; // Servira pour les propriétés du mode nocturne
	private Hashtable<String, Integer> coordMaison = new Hashtable<String, Integer>();
	/**
	 * Crée une pièce
	 * 
	 * @param type correspond au type de pièce a créer
	 */
	public Piece(TypePiece type) {
		typePiece = type;
		piece = new TypeCase[3][3];
		switch (type) {
		case Paille: // Crée une pièce avec la maison de paille
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Bois: // Crée une pièce avec la maison de bois
			piece[1][0] = TypeCase.Jardin;
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			coordMaison.put("x", 1);
			coordMaison.put("y", 1);
			break;
		case Brique: // Crée une pièce avec la maison de brique
			piece[1][2] = TypeCase.Jardin;
			piece[2][0] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			piece[2][2] = TypeCase.Maison;
			coordMaison.put("x", 2);
			coordMaison.put("y", 2);
		}
	}

	public TypeCase[][] getPiece() {
		return piece;
	}

	public void setPiece(TypeCase[][] piece) {
		this.piece = piece;
	}

	/**
	 * Affiche la pièce en console
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
	 * Permet de tourner la pièce de 90° vers la droite
	 */
	public void tournerHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) { // Parcourt le tableau de la pièce
			for (int j = 0; j <= 2; j++) { //
				if (piece[i][j] != null) {
					if (i == 0) {
						pieceTournee[j][2] = piece[i][j];
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
	 * Permet de tourner la pièce de 90° vers la gauche
	 */
	public void tournerAntiHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null) {
					if (i == 0) {
						pieceTournee[2 - j][0] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2-j);
							coordMaison.put("y", 0);
						}
					}
					if (i == 1) {
						pieceTournee[2 - j][1] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2-j);
							coordMaison.put("y", 1);
						}
					}
					if (i == 2) {
						pieceTournee[2 - j][2] = piece[i][j];
						if (piece[i][j] == TypeCase.Maison) {
							coordMaison.put("x", 2-j);
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
							Jeux.setPlateau(piece[i][j], x + i - coordMaison.get("x"),y + j - coordMaison.get("y") );
						if (piece[i][j] == TypeCase.Maison)
						Jeux.setPlateau(piece[i][j], x, y);
					}
				}
			}
		}
		else {
			System.out.println("Impossible de placer");
			return;
		}
		posX = x;
		posY = y;
		this.contexte = contexte;
	}

	public boolean verifPlacement(int x, int y, Contexte contexte) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// Si la piece est un jardin et que la case sur laquelle elle doit etre placé
				// ne fait pas parti du plateau on return false
				if (piece[i][j] == TypeCase.Jardin) {
					if (x + i - coordMaison.get("x") > 3  
							|| x + i - coordMaison.get("x") < 0
							|| y + j - coordMaison.get("y") > 3
							|| y + j - coordMaison.get("y") < 0) { 
						return false;
					}
					if (Jeux.getPlateau()[x + i - coordMaison.get("x")][y + j - coordMaison.get("y")] != TypeCase.Vide) // A réviser
						return false;
				}
				// Si la piece est une Maison et que la case sur laquelle elle doit etre placé
				// n'est pas vide on return false
				if (piece[i][j] == TypeCase.Maison
						&& Jeux.getPlateau()[x][y] != TypeCase.Vide) {
					return false;
				}
				// Contexte Nocturne
				// Si la piece est une Maison et que la case sur laquelle elle doit etre placé
				// n'est pas un cochon on return false
				if (contexte == Contexte.Nocturne && piece[i][j] == TypeCase.Maison
						&& Jeux.getPlateau()[i][j] != TypeCase.Cochon) {
					return false;
				}
			}
		}
		return true;
	}

	public void enlever() {
		if (posX != null && posY != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if( contexte==Contexte.Diurne) {
						if (piece[i][j] != null) {
							if (piece[i][j] == TypeCase.Jardin)
								Jeux.setPlateau(TypeCase.Vide, posX + i - coordMaison.get("x"),posY + j - coordMaison.get("y") );
							if (piece[i][j] == TypeCase.Maison)
								Jeux.setPlateau(TypeCase.Vide, posX, posY);
								}
							}
	
					if(contexte==Contexte.Nocturne) {
						if (piece[i][j] != TypeCase.Maison
								&& Jeux.getPlateau()[posX + (i - posX)][posY + (j - posY)] == piece[i][j])
						Jeux.setPlateau(TypeCase.Cochon, posX + (i - posX), posY + (j - posY)); // NON PAS FORCEMENT
						if (piece[i][j] != TypeCase.Jardin
								&& Jeux.getPlateau()[posX + (i - posX)][posY + (j - posY)] == piece[i][j])
						Jeux.setPlateau(TypeCase.Vide, posX + (i - posX), posY + (j - posY));
					}
				}
			}
		}
		else
			System.out.println("Pièce non placée");
		posX = null;
		posY = null;
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


	
}
