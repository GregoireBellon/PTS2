package visual;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class UtilSons {
	static Media media;
	
	static void jouerSonBouton() {
		File file = new File("ressources/sonBouton.mp3");
		media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
	
	static void jouerSonRoblox() {
		File file = new File("ressources/music/roblox death sound effect.mp3");
		media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
	


}
