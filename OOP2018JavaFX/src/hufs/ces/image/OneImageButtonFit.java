/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.image;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OneImageButtonFit extends Application {

	
	ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/images/androidlogo500x500.png")));
	ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/images/simpsons1.gif")));
	boolean isImage1 = true;

	private Button imageButton;
	private BorderPane root;
    
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("OneImageButtonFit");
		
		root = new BorderPane();
		root.setPrefHeight(500);
		root.setPrefWidth(500);
		root.setPadding(new Insets(0,0,0,0));
		
		image1.fitHeightProperty().bind(root.heightProperty());
		image1.fitWidthProperty().bind(root.widthProperty());
		image2.fitHeightProperty().bind(root.heightProperty());
		image2.fitWidthProperty().bind(root.widthProperty());
		
		imageButton = new Button();
		imageButton.setPadding(new Insets(0,0,0,0));
    	imageButton.setGraphic(image1);
		imageButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		imageButton.setOnAction(e->imageButton(e));
		
		root.setCenter(imageButton);
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
    void imageButton(ActionEvent event) {
    	if (isImage1) {
        	imageButton.setGraphic(image2);
    	}
    	else {
        	imageButton.setGraphic(image1);
    	}
    	isImage1 = !isImage1;
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
