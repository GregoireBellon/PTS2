
public class Jeux {
	
	private static TypeCase[][] plateau = new TypeCase[4][4];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TypeCase[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(TypeCase[][] plateau) {
		this.plateau = plateau;
	}

	public static void setPlateau(TypeCase typeCase, int i, int j) {
		plateau[i][j]=typeCase;
	}

}
