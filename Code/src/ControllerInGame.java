import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ControllerInGame implements Initializable{
	PathTransition animationToSouris = new PathTransition();
	
	private Piece piece1;
	private Piece piece2;
	private Piece piece3;
	

    @FXML
    private ImageView imagePlateau7;

    @FXML
    private ImageView imagePlateau8;

    @FXML
    private ImageView imagePlateau9;

    @FXML
    private ImageView imagePlateau3;

    @FXML
    private ImageView imagePlateau4;

    @FXML
    private Text TextTemps;

    @FXML
    private ImageView imagePlateau5;

    @FXML
    private ImageView imagePlateau6;

    @FXML
    private ImageView imagePlateau12;

    @FXML
    private ImageView imagePlateau13;

    @FXML
    private ImageView imagePlateau1;

    @FXML
    private ImageView imagePlateau2;

    @FXML
    private ImageView imagePlateau10;

    @FXML
    private ImageView imagePlateau11;

    @FXML
    private Button boutonSolution;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView Piece1;

    @FXML
    private Button boutonAbandonner;

    @FXML
    private ImageView Piece2;

    @FXML
    private ImageView Piece3;



    @FXML
    void donnerSolution(ActionEvent event) {

    }

    @FXML
    void abandonner(ActionEvent event) {

    }
    
    @FXML
    void activerDeplacementPiece1(MouseEvent event) {
    	suiviPieceSouris(piece1,event);
    }
    @FXML
    void activerDeplacementPiece2(MouseEvent event) {
    	suiviPieceSouris(piece2,event);
    }
    @FXML
    void activerDeplacementPiece3(MouseEvent event) {
    	suiviPieceSouris(piece3 ,event);
    }
    
    private void suiviPieceSouris(Piece piece, MouseEvent e) {
    		animationToSouris.setNode(null);
    		animationToSouris.stop();
    		double fromX = piece.getImagePiece().getLayoutBounds().getWidth() / 2;
    		double fromY = piece.getImagePiece().getLayoutBounds().getHeight() / 2;
    		double toX = e.getSceneX() - piece.getImagePiece().getFitWidth() ;
    		double toY = e.getSceneY() - piece.getImagePiece().getFitHeight();

    		toX -= piece.getImagePiece().getLayoutX() - (piece.getImagePiece().getLayoutBounds().getWidth() / 2);
    		toY -= piece.getImagePiece().getLayoutY() - (piece.getImagePiece().getLayoutBounds().getHeight() / 2);
    		
    		Path path = new Path();
    		path.getElements().add(new MoveTo(fromX, fromY));
    		path.getElements().add(new LineTo(toX, toY));
    		animationToSouris.setPath(path);
    		animationToSouris.setDuration(Duration.millis(0));
    		animationToSouris.setNode(piece.getImagePiece());
    		animationToSouris.play();
    		
    		piece.getImagePiece().setX(toX);
    		piece.getImagePiece().setY(toY);

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Jeux jeu = new Jeux();
		piece1 = jeu.getPiece1();
		piece2 = jeu.getPiece2();
		piece3 = jeu.getPiece3();
		piece1.setImagePiece(Piece1);
		piece2.setImagePiece(Piece2);
		piece3.setImagePiece(Piece3);
		
	}


}
