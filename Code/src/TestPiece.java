
public class TestPiece {

	public static void main(String[] args) {
		Piece p = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		p.afficherPi�ce();
		bois.afficherPi�ce();
		brique.afficherPi�ce();
		p.tournerAntiHoraire();
		p.afficherPi�ce();
		p.tournerAntiHoraire();
		p.afficherPi�ce();
		p.tournerAntiHoraire();
		p.afficherPi�ce();
		p.tournerAntiHoraire();
		p.afficherPi�ce();

		
	}

}
