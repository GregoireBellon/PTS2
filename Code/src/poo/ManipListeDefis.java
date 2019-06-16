package poo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ManipListeDefis {

	public static File liste_defis = new File(System.getProperty("user.dir") + "/Stockage/ListeDefis.txt"); // Répertoire

	public static void CreerFichier() { // crée ou initialise le fichier

		try {
			if (!liste_defis.exists()) {
				liste_defis.createNewFile();
			} else {
				try {
					FileWriter supp = new FileWriter(liste_defis, false);
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
			FileWriter ecrit = new FileWriter(liste_defis, true);
			BufferedWriter orga_ecrit = new BufferedWriter(ecrit);

			int num_niveau;
			int compteur_contexte = 1;
			String contexte;
			String ligne = "";
			for (num_niveau = 1; num_niveau < 33; num_niveau++) { // num ligne, difficulte, contexte, fait
				compteur_contexte = compteur_contexte % 9;

				if (compteur_contexte == 0) {
					compteur_contexte = 1;
				}

				ligne = ligne + Integer.toString(num_niveau) + "/";
				if (compteur_contexte < 5) {
					contexte = "diurne";
				}

				else
					contexte = "nocturne";

				if (num_niveau < 9) {
					ligne = ligne + "starter/";
				} else if (num_niveau < 17) {
					ligne = ligne + "junior/";
				} else if (num_niveau < 25) {
					ligne = ligne + "expert/";
				} else
					ligne = ligne + "master/";

				ligne = ligne + contexte + "/non\n";

				orga_ecrit.write(ligne);

				ligne = "";
				compteur_contexte++;

			}
			orga_ecrit.close();
			ecrit.close();
		} catch (IOException e) {
			System.out.println("Problème lors de l'écriture du fichier : \n" + e.getMessage());
		}
	}

	public static boolean estTermine(int niveau) {
		try {
			FileReader read = new FileReader(liste_defis);
			BufferedReader read_orga = new BufferedReader(read);
			StringTokenizer separateur = new StringTokenizer("", "/");

			String ligne;
			while (read_orga.ready()) {
				ligne = read_orga.readLine();
				separateur = new StringTokenizer(ligne, "/");
				if (Integer.parseInt(separateur.nextToken()) == niveau) {
					separateur.nextToken();
					separateur.nextToken();
					if (separateur.nextToken().equals("oui")) {
						read_orga.close();
						read.close();
						return true;
					} else {
						read_orga.close();
						read.close();
						return false;
					}

				}
			}
			read_orga.close();
			read.close();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		return false;
	}

	public static void setTermine(int niveau) {

		try {
		FileReader read = new FileReader(liste_defis);
		BufferedReader read_orga = new BufferedReader(read);
		StringTokenizer separateur = new StringTokenizer("", "/");

		String fichier = "";
		String ligne;
		while (read_orga.ready()) {
			ligne = read_orga.readLine();
			separateur = new StringTokenizer(ligne, "/");
			if (Integer.parseInt(separateur.nextToken()) == niveau) {
				
			ligne = Integer.toString(niveau)+"/"+separateur.nextToken()+"/"+separateur.nextToken()+"/oui";
			
			}
		fichier = fichier + ligne+"\n";
		}
		
		read_orga.close();
		read.close();
		FileWriter ecriture = new FileWriter(liste_defis);
		ecriture.write(fichier);
		ecriture.close();
		}catch(IOException e) {
		System.out.println("Le fichier n'existe pas");
	}
	
}
}
