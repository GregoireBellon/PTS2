
public class TestPiece {

	public static void main(String[] args) {
		Piece paille = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		paille.afficherPiece();
		bois.afficherPiece();
		brique.afficherPiece();
		paille.tournerHoraire();
		paille.afficherPiece();
		bois.tournerAntiHoraire();
		bois.afficherPiece();
		brique.tournerAntiHoraire();
		brique.afficherPiece();
		


		
	}

}
