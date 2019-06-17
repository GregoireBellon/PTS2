package poo;

import java.io.File;
import java.util.Scanner;

public class Defi {
	private Contexte contexte;
	private int difficulte;
	private boolean fait;
	private Jeux jeu;
	private String nom;
	private String solution;

	/**
	 * Construit un défi
	 *
	 * @param nom est le nom du défi a charger
	 */
	public Defi(String nom, Jeux jeu) {
		this.jeu = jeu;
		chargerDefi(nom);
	}

	public void afficherPlateau() {
		StringBuilder aff = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				aff.append(jeu.getPlateau()[i][j]).toString();
			}
			aff.append("\n");

		}
		System.out.println(aff);

	}

	private void chargerDefi(String nom) {
		// try {
		File file = new File("Stockage/Defis/" + nom + ".txt"); // Récupère les données du fichier correspondant au
		String ligne = "";
		try { // défi à charger
			Scanner sc = new Scanner(file); // Lit les données du fichier file
			ligne = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (nom.contains("N")) {
			contexte = Contexte.Nocturne;
		} else {
			contexte = Contexte.Diurne;
		}
		solution = ligne.split(" ")[1]; // Récupère la solution du niveau
		for (int i = 0; i < 4; i++) { // Parcourt le tableau
			for (int j = 0; j < 4; j++) { //
				switch (ligne.charAt((4 * i) + j)) { // Récupère le caractère désiré
				case 'i':
					jeu.setPlateau(TypeCase.Innexistante, i, j);
					break;
				case 'v':
					jeu.setPlateau(TypeCase.Vide, i, j);
					break;
				case 'c':
					jeu.setPlateau(TypeCase.Cochon, i, j);
					break;
				case 'l':
					jeu.setPlateau(TypeCase.Loup, i, j);
					break;
				}
			}
		}
		// } catch (Exception e) {
		// System.err.println("erreur " + e);
		// }

	}

	public Contexte getContexte() {
		return contexte;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public Jeux getJeu() {
		return jeu;
	}

	public String getNom() {
		return nom;
	}

	public String getSolution() {
		return solution;
	}

	public boolean isFait() {
		return fait;
	}

	public boolean verifierDefi() {
		for (int i = 0; i < 4; i++) { // Parcourt le plateau
			for (int j = 0; j < 4; j++) { //
				switch (solution.charAt((4 * i) + j)) { // Récupère le caractère désiré de la solution
				case 'i':
					if (jeu.getPlateau()[i][j] != TypeCase.Innexistante) {
						return false;
					}
					break;
				case 'v':
					if (jeu.getPlateau()[i][j] != TypeCase.Vide) {
						return false;
					}
					break;
				case 'c':
					if (jeu.getPlateau()[i][j] != TypeCase.Cochon) {
						return false;
					}
					break;
				case 'l':
					if (jeu.getPlateau()[i][j] != TypeCase.Loup) {
						return false;
					}
					break;
				case 'j':
					if (jeu.getPlateau()[i][j] != TypeCase.Jardin) {
						return false;
					}
					break;
				case 'm':
					if (jeu.getPlateau()[i][j] != TypeCase.Maison) {
						return false;
					}
					break;
				default:
					break;
				}
			}
		}
		return true;
	}

	/*
	 * public void ajouterCase(int i, int j, TypeCase type) { // Surement inutile
	 * (Supprimer si c'est le cas) Jeux.getPlateau()[i][j] = new Case(type); }
	 */
}
