package poo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManipListeDefis {

	public static File liste_defis = new File(System.getProperty("user.dir") + "/Stockage/ListeDefis.txt"); // Répertoire

	public static void CreerFichier() {
		// courant+"/TabScore.txt"

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

}
