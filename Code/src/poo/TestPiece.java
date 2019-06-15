package poo;
public class TestPiece {

	public static void main(String[] args) {
		Piece paille = new Piece(TypePiece.Paille);
		Piece bois = new Piece(TypePiece.Bois);
		Piece brique = new Piece(TypePiece.Brique);
		paille.afficherPiece();
		bois.afficherPiece();
		brique.afficherPiece();
		Defi test = new Defi("1N");
		test.afficherPlateau();
		paille.Placer(1, 0, Contexte.Nocturne);
		test.afficherPlateau();
		bois.Placer(3, 2, Contexte.Nocturne);
		brique.Placer(2, 3, Contexte.Nocturne);
		test.afficherPlateau();
		System.out.println(test.verifierDefi());
		paille.enlever();
		test.afficherPlateau();
		paille.Placer(0, 1, Contexte.Nocturne);
		paille.enlever();
		test.afficherPlateau();
		bois.enlever();
		test.afficherPlateau();
		brique.enlever();
		test.afficherPlateau();
		brique.enlever();
		test.afficherPlateau();
		
		
	}

}
