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
	private Case[][] plateau = new Case[4][4];

	public Defi(String nom) {
		chargerDefi(nom);
	}

	private void chargerDefi(String nom) {
		try {
			File file = new File("Stockage/Defis/" + nom + ".txt");
			Scanner sc = new Scanner(file);
			String ligne = sc.nextLine();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					switch (ligne.charAt(4*i+j)){
						case 'i' :
						this.ajouterCase(i, j, TypeCase.Innexistante);
						break;
						case 'v' :
						this.ajouterCase(i, j, TypeCase.Vide);
						break;
						case 'c' :
						this.ajouterCase(i, j, TypeCase.Cochon);
						break;
						case 'l' :
						this.ajouterCase(i, j, TypeCase.Loup);
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
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				aff.append(plateau[i][j]);
			}
			aff.append("\n");

		}
		System.out.println(aff);

	}

	public boolean verifierDefi() {
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
	
	public void ajouterCase(int i, int j, TypeCase type) {
		this.plateau[i][j] = new Case(type);
	}
}
