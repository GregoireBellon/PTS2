
public class TestPlacerPiece {
	public static void main(String[] args) {

		Defi d = new Defi("1");
		d.afficherPlateau();
		Piece p = new Piece(TypePiece.Paille);
		System.out.println(p.verifPlacement(1, 1, Contexte.Diurne));
		p.Placer(1, 1, Contexte.Diurne);
		d.afficherPlateau();
		
		p.enlever();
		
		d.afficherPlateau();
		
	}
}
