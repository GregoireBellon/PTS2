import java.util.Arrays;

public class Piece {
	
	private CompoPiece[][] piece;
	
	public Piece(TypePiece type) {
		piece = new CompoPiece[3][3];
		switch(type) {
		case Paille:
			piece[1][1] = CompoPiece.Maison;
			piece[1][2] = CompoPiece.Jardin;
			piece[2][1] = CompoPiece.Jardin;
			break;
		case Bois:
			piece[1][0] = CompoPiece.Jardin;
			piece[1][1] = CompoPiece.Maison;
			piece[1][2] = CompoPiece.Jardin;
			break;
		case Brique:
			piece[1][2] = CompoPiece.Jardin;
			piece[2][0] = CompoPiece.Jardin;
			piece[2][1] = CompoPiece.Jardin;
			piece[2][2] = CompoPiece.Maison;
		}
		
	}

	public CompoPiece[][] getPiece() {
		return piece;
	}

	public void setPiece(CompoPiece[][] piece) {
		this.piece = piece;
	}

	public void afficher() {
		StringBuilder aff = new StringBuilder();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null)
					if (piece[i][j] == CompoPiece.Maison) {
						aff.append("M");
					}
					else {
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
		CompoPiece[][] pieceTournee = new CompoPiece[3][3];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (piece[i][j] != null) {
					if (i == 0)
						 pieceTournee [j][2] = piece[i][j];
					if (i == 1)
						pieceTournee [j][1] = piece[i][j];
					if (i == 2)
						pieceTournee [j][0] = piece[i][j];
				}	
			}
		}
		piece = pieceTournee;
	}

}
