package visual;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTestJavaFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame.fxml"));


			root = loader.load();
			
			ControllerInGame controller = loader.getController();
			
			controller.lancerPartie("1N");

			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
