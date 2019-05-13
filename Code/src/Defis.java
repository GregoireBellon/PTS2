import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Defis {
	private String nom;
	private String solution;
	private boolean fait;
	private Contexte contexte;
	private int difficulte;
	private Case[][] plateau = new Case[4][4];

	public Defis(String nom) {
		chargerDefis(nom);
	}

	private void chargerDefis(String nom) {
		try {
			File file = new File("Stockage/Defis/" + nom + ".txt");
			Scanner sc = new Scanner(file);
			String ligne = sc.nextLine();
			solution = ligne.split(" ")[1];
			System.out.println(solution);
			int j = 0;
			for (int i = 0; i < ligne.split(" ")[0].length(); i++) {
				j = (i % 4 == 0 ? j++ : j);
				switch (ligne.charAt(i)) {
				case 'i':
					plateau[i - 4 * j][j] = new Case(TypeCase.Innexistante);
					break;
				case 'v':
					plateau[i - 4 * j][j] = new Case(TypeCase.Vide);
					break;
				case 'c':
					plateau[i - 4 * j][j] = new Case(TypeCase.Cochon);
					break;
				case 'l':
					plateau[i - 4 * j][j] = new Case(TypeCase.loup);
					break;
				default:
					break;
				}

			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public boolean verifierDefis() {
		int j = 0;
		for (int i = 0; i < solution.length(); i++) {
			j = (i % 4 == 0 ? j++ : j);
			switch (solution.charAt(i)) {
			case 'i':
				if (plateau[i - 4 * j][j].getType() != TypeCase.Innexistante)
					return false;
				break;
			case 'v':
				if (plateau[i - 4 * j][j].getType() != TypeCase.Vide)
					return false;
				break;
			case 'c':
				if (plateau[i - 4 * j][j].getType() != TypeCase.Cochon)
					return false;
				break;
			case 'l':
				if (plateau[i - 4 * j][j].getType() != TypeCase.loup)
					return false;
				break;
			case 'j':
				if (plateau[i - 4 * j][j].getType() != TypeCase.Jardin)
					return false;
				break;
			case 'm':
				if (plateau[i - 4 * j][j].getType() != TypeCase.Maison)
					return false;
				break;
			default:
				break;
			}
		}
		return true;
	}
}
