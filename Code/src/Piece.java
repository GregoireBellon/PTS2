public class Piece {
	private TypeCase[][] piece;

	public Piece(TypePiece type) {
		piece = new TypeCase[3][3];
		switch (type) {
		case Paille:
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			piece[2][1] = TypeCase.Jardin;
			break;
		case Bois:
			piece[1][0] = TypeCase.Jardin;
			piece[1][1] = TypeCase.Maison;
			piece[1][2] = TypeCase.Jardin;
			break;
		case Brique:
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

	public void tournerHoraire() {
		TypeCase[][] pieceTournee = new TypeCase[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
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
				if (contexte == Contexte.Diurne && (piece[i][j] == TypeCase.Maison || piece[i][j] == TypeCase.Jardin)
						&& Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Vide)
					return false;
				else if (piece[i][j] == TypeCase.Jardin && Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Vide)
					return false;
				else if (piece[i][j] == TypeCase.Maison
						&& Jeux.getPlateau()[x + (i - x)][y + (j - y)] != TypeCase.Cochon)
					return false;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(piece[i][j] != null)
					Jeux.setPlateau(piece[i][j],x + (i - x),y + (j - y));
			}
		}
		return true;
	}

}
