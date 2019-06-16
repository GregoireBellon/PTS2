package poo;

public class Jeux {

	private Defi defi;

	private Piece piece1 = new Piece(TypePiece.Brique, this);

	private Piece piece2 = new Piece(TypePiece.Paille, this);

	private Piece piece3 = new Piece(TypePiece.Bois, this);

	private TypeCase[][] plateau;

	public Jeux(String defi) {
		plateau = new TypeCase[4][4];
		this.defi = new Defi(defi, this);
	}
	
	public Jeux() {
		plateau = new TypeCase[4][4];
		defi = new Defi("1D", this);
	}

	public void afficherPlateau() {
		defi.afficherPlateau();
	}

	public Defi getDefi() {
		return defi;
	}

	public Piece getPiece1() {
		return piece1;
	}

	public Piece getPiece2() {
		return piece2;
	}

	public Piece getPiece3() {
		return piece3;
	}

	public TypeCase[][] getPlateau() {
		return plateau;
	}

	public void setDefi(Defi defi) {
		this.defi = defi;
	}

	public void setPiece1(Piece piece1) {
		this.piece1 = piece1;
	}

	public void setPiece2(Piece piece2) {
		this.piece2 = piece2;
	}

	public void setPiece3(Piece piece3) {
		this.piece3 = piece3;
	}

	public void setPlateau(TypeCase typeCase, int i, int j) {
		plateau[i][j] = typeCase;
	}

	public void setPlateau(TypeCase[][] plateau) {
		this.plateau = plateau;
	}

}
