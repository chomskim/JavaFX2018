package hufs.ces.gui;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class OneImageButtonMain extends Application {

	
	Image image1 = new Image(getClass().getResourceAsStream("/images/androidlogo500x500.png"));
	Image image2 = new Image(getClass().getResourceAsStream("/images/simpsons1.gif"));
	boolean isImage1 = true;

	private Button imageButton;
	private BorderPane root;
    
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("OneImageButton");
		
		root = new BorderPane();
		root.setPrefHeight(500);
		root.setPrefWidth(500);
		
		imageButton = new Button();
    	imageButton.setGraphic(new ImageView(image1));
		imageButton.setMaxHeight(1600);
		imageButton.setMaxWidth(2400);
		imageButton.setOnAction(e->imageButton(e));
		
		root.setCenter(imageButton);
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
    void imageButton(ActionEvent event) {
    	if (isImage1) {
        	imageButton.setGraphic(new ImageView(image2));
    	}
    	else {
        	imageButton.setGraphic(new ImageView(image1));
    	}
    	isImage1 = !isImage1;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
