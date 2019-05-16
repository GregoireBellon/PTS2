
public class TestPiece {

	public static void main(String[] args) {
		Piece p = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		p.afficherPiece();
		bois.afficherPiece();
		brique.afficherPiece();
		p.tournerAntiHoraire();
		p.afficherPiece();
		p.tournerAntiHoraire();
		p.afficherPiece();
		p.tournerAntiHoraire();
		p.afficherPiece();
		p.tournerAntiHoraire();
		p.afficherPiece();

		
	}

}
