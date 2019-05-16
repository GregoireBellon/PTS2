public class Piece {
	private TypeCase[][] piece;

	/**
	 * Crée une pièce
	 * 
	 * @param type correspond au type de pièce a créer
	 */
	public Piece(TypePiece type) {
		piece = new TypeCase[3][3];
		switch (type) {
		case Paille: //Crée une pièce avec la maison de paille
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			break;
		case Bois: //Crée une pièce avec la maison de bois
			piece[1][0] = TypeCase.Jardin;
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			break;
		case Brique: //Crée une pièce avec la maison de brique
			piece[1][2] = TypeCase.Jardin;
			piece[2][0] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			piece[2][2] = TypeCase.Maison;
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
					if (piece[i][j] == TypeCase.Maison) {
						aff.append("M");
					} else {
						aff.append("J");
					}
				else
					aff.append("-");
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
		for (int i = 0; i <= 2; i++) {		// Parcourt le tableau de la pièce
			for (int j = 0; j <= 2; j++) {	//
				if (piece[i][j] != null) {
					if (i == 0)
						pieceTournee[j][2] = piece[i][j];
					if (i == 1)
						pieceTournee[j][1] = piece[i][j];
					if (i == 2)
						pieceTournee[j][0] = piece[i][j];
				}
			}
		}
		piece = pieceTournee;
	}

	/**
	 * Permet de tourner la pièce de 90° vers la gauche
	 */
	public void tournerAntiHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null) {
					if (i == 0)
						pieceTournee[2 - j][0] = piece[i][j];
					if (i == 1)
						pieceTournee[2 - j][1] = piece[i][j];
					if (i == 2)
						pieceTournee[2 - j][2] = piece[i][j];
				}
			}
		}
		piece = pieceTournee;
	}

	public boolean Placer(int x, int y, Contexte contexte) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				//Si la piece est un jardin et que la case sur laquelle elle doit etre placé n'est pas vide on return false
				if (piece[i][j] == TypeCase.Jardin && Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Vide)
					return false;
				//Contexte Diurne
				//Si la piece est une Maison et que la case sur laquelle elle doit etre placé n'est pas vide on return false
				if (contexte == Contexte.Diurne && piece[i][j] == TypeCase.Maison && Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Vide) {
					return false;
				}
				//Contexte Nocturne
				//Si la piece est une Maison et que la case sur laquelle elle doit etre placé n'est pas un cochon on return false
				if (contexte == Contexte.Nocturne && piece[i][j] == TypeCase.Maison && Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Cochon) {
					return false;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (piece[i][j] != null)
					Jeux.setPlateau(piece[i][j], x + (i - x), y + (j - y));
			}
		}
		return true;
	}

}

}
