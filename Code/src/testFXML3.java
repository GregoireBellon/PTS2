import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.*;

public class testFXML3 extends Application { 
  
    @Override 
    public void start(Stage primaryStage) { 
        final ImageView rectangle = new ImageView("imageCochon.PNG"); 
        rectangle.setOnDragDetected(mouseEvent -> { 
            System.out.println("DnD detecté."); 
            final Dragboard dragBroard = rectangle.startDragAndDrop(TransferMode.COPY); 
            // Remlissage du contenu. 
            final ClipboardContent content = new ClipboardContent(); 
            // Exporter en tant que texte. 
            content.putString("Un rectangle rouge."); 
            // Exporter en tant que couleur ARGB. 
            DataFormat paintFormat = DataFormat.lookupMimeType(Paint.class.getName()); 
            paintFormat = (paintFormat == null) ? new DataFormat(Paint.class.getName()) : paintFormat; 
            // Exporter en tant qu'image.        
            final WritableImage capture = rectangle.snapshot(null, null); 
            content.putImage(capture); 
            // 
            dragBroard.setContent(content); 
            mouseEvent.consume();         
        }); 
        final Pane root = new Pane(); 
        root.getChildren().setAll(rectangle); 
        final Scene scene = new Scene(root, 600, 600); 
        primaryStage.setTitle("Test de DnD"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
  
    public static void main(String[] args) { 
        launch(args); 
    } 
}