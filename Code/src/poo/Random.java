package poo;

public class Random {
	
	
	public static String niveauRandom(int premierNiveau, Contexte contexte) {
		StringBuilder retour = new StringBuilder();
		int resultat = (int) (Math.random()*6 + premierNiveau);
		retour.append(Integer.toString(resultat));
		switch (contexte) {
		case Diurne :
			retour.append('D');
			break;
		case Nocturne :
			retour.append('N');
			break;
		}
		return retour.toString();
	}

}
