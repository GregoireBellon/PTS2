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
			System.out.println(ligne.split(" ")[0]);
			System.out.println(solution);
			for (int i = 0; i < ligne.split(" ")[0].length(); i++) {
				for (int j = 0; j < ligne.split(" ")[0].length(); j++)
				switch (ligne.charAt(i)) {
				case 'i':
					plateau[i][j] = new Case(TypeCase.Innexistante);
					break;
				case 'v':
					plateau[i][j] = new Case(TypeCase.Vide);
					break;
				case 'c':
					plateau[i][j] = new Case(TypeCase.Cochon);
					break;
				case 'l':
					plateau[i][j] = new Case(TypeCase.Loup);
					break;

				}

			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void afficherPlateau() {
		/*StringBuilder aff = new StringBuilder();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				if (plateau[i][j].getType() == null)
					System.out.println("Oui les blondes");
				switch (plateau[i][j].getType()) {
				case Innexistante:
					aff.append(" ");
					break;
				case Vide:
					aff.append("-");
					break;
				case Cochon:
					aff.append("C");
					break;
				case Loup:
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
				System.out.println(aff);
			}
			aff.append("\n");

		}
		System.out.println(aff);*/
		System.out.println(plateau[0][0]);
		System.out.println(plateau[0][1]);
		System.out.println(plateau[0][2]);
		System.out.println(plateau[0][3]);
		System.out.println(plateau[1][0]);
		System.out.println(plateau[1][1]);
		System.out.println(plateau[1][2]);
		System.out.println(plateau[1][3]);
		System.out.println(plateau[2][0]);
		System.out.println(plateau[2][1]);
		System.out.println(plateau[2][2]);
		System.out.println(plateau[2][3]);
		System.out.println(plateau[3][0]);
		System.out.println(plateau[3][1]);
		System.out.println(plateau[3][2]);
		System.out.println(plateau[3][3]);


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
				if (plateau[i - 4 * j][j].getType() != TypeCase.Loup)
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
