package poo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class UtilSons {
	public static Media musiqueDeFond;
	public static MediaPlayer mediaPlayerMusique;
	
	public static Media sonBoutonMedia;
	public static MediaPlayer bruitages;
	
	public static void initSon() {
		File sonBouton = new File("ressources/sonBouton.mp3");
		sonBoutonMedia = new Media(sonBouton.toURI().toString());
		bruitages = new MediaPlayer(sonBoutonMedia);
		
		File musiqueFond = new File("ressources/Angry Birds Theme.mp3");
		musiqueDeFond = new Media(musiqueFond.toURI().toString());
		mediaPlayerMusique = new MediaPlayer(musiqueDeFond);
		mediaPlayerMusique.setVolume(0.5);
	}
	
	public static void jouerSonBouton() {
		double volume = bruitages.getVolume();
		File sonBouton = new File("ressources/sonBouton.mp3");
		sonBoutonMedia = new Media(sonBouton.toURI().toString());
		bruitages = new MediaPlayer(sonBoutonMedia);
		bruitages.setVolume(volume);
		bruitages.play();
	}
	
	public static void jouerMusiqueFond() {
		
		mediaPlayerMusique.setAutoPlay(true);

		mediaPlayerMusique.setOnEndOfMedia(new Runnable() {
			public void run() {
				mediaPlayerMusique.seek(Duration.ZERO);
			}
		});
	}
	
	


}
