
public class TestPiece {

	public static void main(String[] args) {
		Piece p = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		p.afficher();
		bois.afficher();
		brique.afficher();
		p.tournerAntiHoraire();
		p.afficher();
		p.tournerAntiHoraire();
		p.afficher();
		p.tournerAntiHoraire();
		p.afficher();
		p.tournerAntiHoraire();
		p.afficher();

		
	}

}
