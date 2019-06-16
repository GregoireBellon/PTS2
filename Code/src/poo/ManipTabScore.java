package poo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManipTabScore {

	public static File tab_score = new File(System.getProperty("user.dir") + "/TabScore.txt"); // Répertoire

	public static void CreerFichier() {
		// courant+"/TabScore.txt"

		try {
			if (!tab_score.exists()) {
				tab_score.createNewFile();
			} else {
				try {
					FileWriter supp = new FileWriter(tab_score, false);
					supp.write("");
					supp.close();
				} catch (IOException e) {
					System.out.println("Problème critique lors du formatage : \n" + e.getMessage());
					return;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème dans la création de fichier");
			return;
		}

		try {
			FileWriter ecrit = new FileWriter(tab_score, true);
			BufferedWriter orga_ecrit = new BufferedWriter(ecrit);

			int i;
			for (i = 1; i < 9; i++) {
				orga_ecrit.write("<contexte =" + i + ">");
				orga_ecrit.newLine();
				for (int k = 0; k < 20; k++) {
					orga_ecrit.write("<empty>");
					orga_ecrit.newLine();
				}
			}
			orga_ecrit.close();
			ecrit.close();
		} catch (IOException e) {
			System.out.println("Problème lors de l'écriture du fichier : \n" + e.getMessage());
		}
	}

	public static boolean EstHighScore(int contexte, int score) { //nom score

		List<String> liste = CopierLignesContexte(contexte);
		
		int recup_score;
		
		for(String extract : liste) {
		recup_score = Integer.parseInt(extract.substring(extract.indexOf(" ")+1));
			if(score>recup_score) return true;
		}
		
		return false;
		
	}

	public static List<String>CopierLignesContexte(int contexte){
		
		List<String> scores = new ArrayList<String>();
		int contexte_tete = 0;
		int ligne_compteur = 0;
		String ligne="";
		
		try {
			FileReader parcours = new FileReader(tab_score);
			BufferedReader parcoursBuff = new BufferedReader(parcours);
			
			if (parcoursBuff.ready()) { // on passe à la premiere ligne;
				parcoursBuff.readLine(); // "ligne" est le string qui stoque chaque ligne
				contexte_tete++;
			}
			
			while (parcoursBuff.ready()) { // tant que le fichier n'est pas fini

				if (contexte_tete < contexte) { // si on n'est pas au contexte recherché
					for (ligne_compteur = 0; ligne_compteur < 20; ligne_compteur++) { // on saute les lignes
						parcoursBuff.readLine();
					}
					parcoursBuff.readLine();
					ligne_compteur = 0; // le compteur repasse à 0
					contexte_tete++; // la tête change de contexte
				}

				if (contexte_tete == contexte) {// si la tête est dans le bon contexte, on lit toutes les lignes et on
					for (ligne_compteur = 0; ligne_compteur < 20; ligne_compteur++) { // on saute des lignes
						
						ligne=parcoursBuff.readLine();
						
						if(!ligne.contains("<empty>")) {
							scores.add(ligne);	
						}
						else break;
					}
					break;
						}

					
				
				if (ligne_compteur == 20) {
					contexte_tete++;
					ligne_compteur = 0;
				}

				if (contexte_tete > contexte) {
				break;
				}
			}
			
			parcoursBuff.close();
			parcours.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return scores;
	}
	//
	//
	//
	//
	public static void CollerListe(int contexte, List<String> scores) {
		
		int contexte_tete = 0;
		int ligne_compteur = 0;
		String fichier="";
		try {
			FileReader parcours = new FileReader(tab_score);
			BufferedReader parcoursBuff = new BufferedReader(parcours);
			
			if (parcoursBuff.ready()) { // on passe à la premiere ligne;
				fichier=fichier+parcoursBuff.readLine()+"\n"; // "ligne" est le string qui stoque chaque ligne
				contexte_tete++;
			}
			
			while (parcoursBuff.ready()) { // tant que le fichier n'est pas fini

				if (contexte_tete < contexte) { // si on n'est pas au contexte recherché
					for (ligne_compteur = 0; ligne_compteur < 20; ligne_compteur++) { // on saute les lignes
						fichier=fichier+parcoursBuff.readLine()+"\n";
					}
					fichier=fichier+parcoursBuff.readLine()+"\n";
					ligne_compteur = 0; // le compteur repasse à 0
					contexte_tete++; // la tête change de contexte
				}

				if (contexte_tete == contexte) {// si la tête est dans le bon contexte, on lit toutes les lignes et on
					for (ligne_compteur = 0; ligne_compteur < 20; ligne_compteur++) { // on saute des lignes
						
						if(ligne_compteur<scores.size()) {
							fichier=fichier+scores.get(ligne_compteur)+"\n";
						}
						
						else fichier = fichier + "<empty> \n";
						parcoursBuff.readLine();
					}
					
						}

					
				
				if (ligne_compteur == 20) {
					contexte_tete++;
					ligne_compteur = 0;
				}

				if (contexte_tete > contexte) {
					fichier = fichier+parcoursBuff.readLine()+"\n";
				}
			}
			
			parcoursBuff.close();
			parcours.close();
			
			FileWriter ecriture = new FileWriter(tab_score);
			ecriture.write(fichier);
			ecriture.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//
	//
	//
	//
//////////////////////////////////////////////////////////////////////////////////
	public static List<Score> recupScore(int contexte){
		
		List<String> scoresString = CopierLignesContexte(contexte);
		List<Score> scores = new ArrayList<Score>();
		
		int extract_temps;
		String extract_nom;
		
		for(String extract : scoresString) {
			
			extract_temps = Integer.parseInt(extract.substring(extract.indexOf(" ")+1));
			extract_nom = extract.substring(0, extract.indexOf(" "));
			scores.add(new Score(extract_temps, extract_nom));
		}
		
		return scores;

	}
	
	public static void AjouterScore(int contexte, int temps, String nom) { // contexte entre 1 et 8
		List<String> scoresString = new ArrayList<String>();
		List<Score> scores = recupScore(contexte);
		
		scores.add(new Score(temps, nom));

		Collections.sort(scores);
		Collections.reverse(scores);
		
	for(Score extract : scores) {
		scoresString.add(extract.toString());
		}
		
		CollerListe(contexte, scoresString);
	}

	//
	//
	//
	/**
	 * Transforme un temps en millisecondes en String formaté tel que :
	 * minutes.secondes.millisecondes
	 * 
	 * @param temps
	 * @return
	 */
	public static String TransformerMilliTemps(int temps) {

		int minutes = (int) Math.floor((float) temps / 60000);
		temps = temps - (minutes * 60000);
		int secondes = (int) Math.floor((float) temps / 1000);
		temps = temps - (secondes * 1000);
		int millisecondes = temps;

		String minutes_ecriture = Integer.toString(minutes);
		System.out.println(minutes_ecriture);
		String secondes_ecriture = Integer.toString(secondes);
		System.out.println(secondes_ecriture);
		String millisecondes_ecriture = Integer.toString(millisecondes);
		System.out.println(millisecondes_ecriture);

		for (int i = secondes_ecriture.length(); i < 2; i++) {
			secondes_ecriture = '0' + secondes_ecriture;
		}

		for (int i = millisecondes_ecriture.length(); i < 3; i++) {
			millisecondes_ecriture = '0' + millisecondes_ecriture;
		}
		return minutes_ecriture + "." + secondes_ecriture + "." + millisecondes_ecriture;
	}
	//
	//
	//
	//
	public static void AfficherList(List<Integer> list) {
		for(Object a : list) {
		System.out.println(a.toString());
		}
	}
}
