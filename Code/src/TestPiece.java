
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
		System.out.println(test.verifierDefi());
		System.out.println(paille.verifPlacement(1, 1, Contexte.Diurne));
		paille.Placer(1, 1, Contexte.Diurne);
		test.afficherPlateau();


		
	}

}
