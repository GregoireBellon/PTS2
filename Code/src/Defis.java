import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Defis {
	private String nom;
	private boolean fait;
	private Contexte contexte;
	private int difficulte;
	private Case[][] plateau = new Case[4][4];

	public Defis(String nom) {
		chargerDefis(nom);
	}

	private void chargerDefis(String nom) {
		try {
			InputStream flux = new FileInputStream("Stockage/Defis/" + nom + ".txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne = buff.readLine();
			int j = 0;
			for (int i = 0; i < ligne.length(); i++) {
				j = (i % 4 == 0 ? j++ : j);
				switch (ligne.charAt(i)) {
				case 'i':
					plateau[i-4*j][j] = new Case(TypeCase.Innexistante);
					break;
				case 'v':
					plateau[i-4*j][j] = new Case(TypeCase.Vide);
					break;
				case 'c':
					plateau[i-4*j][j] = new Case(TypeCase.Cochon);
					break;
				case 'l':
					plateau[i-4*j][j] = new Case(TypeCase.Loup);
					break;
				default:
					break;
				}

			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	public void afficherNiveau() {
		StringBuilder aff = new StringBuilder();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				switch (plateau[i][j].getType()) {
				case Innexistante :
					aff.append(" ");
					break;
				case Vide :
					aff.append("-");
					break;
				case Cochon :
					aff.append("C");
					break;
				case Loup :
					aff.append("L");
					break;
				case Jardin:
					aff.append("J");
					break;
				case Maison:
					aff.append("M");
					break;
				default:
					break;
				}
				aff.append("\n");
			}
		}
		System.out.println(aff);
	}
}
