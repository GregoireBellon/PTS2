package visual;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class UtilSons {
	static Media musiqueDeFond;
	static MediaPlayer mediaPlayerMusique;
	
	static Media sonBoutonMedia;
	static MediaPlayer bruitages;
	
	static void initSon() {
		File sonBouton = new File("ressources/sonBouton.mp3");
		sonBoutonMedia = new Media(sonBouton.toURI().toString());
		bruitages = new MediaPlayer(sonBoutonMedia);
		
		File musiqueFond = new File("ressources/Angry Birds Theme.mp3");
		musiqueDeFond = new Media(musiqueFond.toURI().toString());
		mediaPlayerMusique = new MediaPlayer(musiqueDeFond);
		mediaPlayerMusique.setVolume(0.5);
	}
	
	static void jouerSonBouton() {
		double volume = bruitages.getVolume();
		File sonBouton = new File("ressources/sonBouton.mp3");
		sonBoutonMedia = new Media(sonBouton.toURI().toString());
		bruitages = new MediaPlayer(sonBoutonMedia);
		bruitages.setVolume(volume);
		bruitages.play();
	}
	
	static void jouerMusiqueFond() {
		
		mediaPlayerMusique.setAutoPlay(true);

		mediaPlayerMusique.setOnEndOfMedia(new Runnable() {
			public void run() {
				mediaPlayerMusique.seek(Duration.ZERO);
			}
		});
	}
	
	


}
