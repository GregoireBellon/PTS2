import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Defi {
	private String nom;
	private String solution;
	private boolean fait;
	private Contexte contexte;
	private int difficulte;

	public Defi(String nom) {
		chargerDefi(nom);
	}

	private void chargerDefi(String nom) {
		try {
			File file = new File("Stockage/Defis/" + nom + ".txt");
			Scanner sc = new Scanner(file);
			String ligne = sc.nextLine();
			solution = ligne.split(" ")[1];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					switch (ligne.charAt(4*i+j)){
						case 'i' :
							Jeux.setPlateau(TypeCase.Innexistante,i, j);
						break;
						case 'v' :
							Jeux.setPlateau(TypeCase.Vide,i, j);
						break;
						case 'c' :
							Jeux.setPlateau(TypeCase.Cochon,i, j);
						break;
						case 'l' :
							Jeux.setPlateau(TypeCase.Loup,i, j);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void afficherPlateau() {
		StringBuilder aff = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				aff.append(Jeux.getPlateau()[i][j]).toString();
			}
			aff.append("\n");

		}
		System.out.println(aff);

	}

	public boolean verifierDefi() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				switch (solution.charAt(4*i+j)) {
				case 'i':
					if (Jeux.getPlateau()[i][j] != TypeCase.Innexistante)
						return false;
					break;
				case 'v':
					if (Jeux.getPlateau()[i][j] != TypeCase.Vide)
						return false;
					break;
				case 'c':
					if (Jeux.getPlateau()[i][j] != TypeCase.Cochon)
						return false;
					break;
				case 'l':
					if (Jeux.getPlateau()[i][j] != TypeCase.Loup)
						return false;
					break;
				case 'j':
					if (Jeux.getPlateau()[i][j] != TypeCase.Jardin)
						return false;
					break;
				case 'm':
					if (Jeux.getPlateau()[i][j] != TypeCase.Maison)
						return false;
					break;
				default:
					break;
				}
			}
		}
		return true;

	}
	
}
