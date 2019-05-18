
public class TestPiece {

	public static void main(String[] args) {
		Piece paille = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		paille.afficherPiece();
		bois.afficherPiece();
		brique.afficherPiece();
		Defi test = new Defi("1");
		test.afficherPlateau();
		paille.tournerHoraire();
		bois.tournerAntiHoraire();
		brique.tournerAntiHoraire();
		brique.afficherPiece();
		paille.Placer(0, 2, Contexte.Diurne);
		bois.Placer(2, 3, Contexte.Diurne);
		brique.Placer(1, 1, Contexte.Diurne);
		test.afficherPlateau();
		System.out.println(test.verifierDefi());
		paille.enlever();
		test.afficherPlateau();
		bois.enlever();
		test.afficherPlateau();
		brique.enlever();
		brique.enlever();
		test.afficherPlateau();

		
	}

}
