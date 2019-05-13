
public class TestPiece {

	public static void main(String[] args) {
		Piece p = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		p.afficherPièce();
		bois.afficherPièce();
		brique.afficherPièce();
		p.tournerAntiHoraire();
		p.afficherPièce();
		p.tournerAntiHoraire();
		p.afficherPièce();
		p.tournerAntiHoraire();
		p.afficherPièce();
		p.tournerAntiHoraire();
		p.afficherPièce();

		
	}

}
