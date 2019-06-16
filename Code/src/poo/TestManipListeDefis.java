package poo;

public class TestManipListeDefis {

	public static void main(String[] args) {

		ManipListeDefis.CreerFichier();
		System.out.println(ManipListeDefis.estTermine(5));
		ManipListeDefis.setTermine(8);
		System.out.println(ManipListeDefis.estTermine(8));

		
	}

}
