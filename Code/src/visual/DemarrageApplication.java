package visual;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemarrageApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			
			//root = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));
			//primaryStage.setScene(new Scene(root));
			//primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
