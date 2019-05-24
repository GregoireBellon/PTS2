
public class Jeux {
	
	private static TypeCase[][] plateau = new TypeCase[4][4];
	private Piece piece1 = new Piece(TypePiece.Paille);
	private Piece piece2 = new Piece(TypePiece.Brique);
	private Piece piece3 = new Piece(TypePiece.Bois);

	public static TypeCase[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(TypeCase[][] plateau) {
		this.plateau = plateau;
	}

	public static void setPlateau(TypeCase typeCase, int i, int j) {
		plateau[i][j]=typeCase;
	}

	public Piece getPiece1() {
		return piece1;
	}

	public void setPiece1(Piece piece1) {
		this.piece1 = piece1;
	}

	public Piece getPiece2() {
		return piece2;
	}

	public void setPiece2(Piece piece2) {
		this.piece2 = piece2;
	}

	public Piece getPiece3() {
		return piece3;
	}

	public void setPiece3(Piece piece3) {
		this.piece3 = piece3;
	}
	
}
