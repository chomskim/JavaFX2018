/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.image;

import hufs.ces.util.ImageUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OneImageAvgButton extends  Application {

	Image origImage = new Image(getClass().getResourceAsStream("/images/simpsons1.gif"));
	Image avgImage = null;
	ImageView image1 = new ImageView(origImage);
	ImageView image2 = null;

	private Button imageButton;
	private BorderPane root;

	int fwidth = 400;
	int fheight = 400;

	boolean isAvgImage = false;

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("OneImageButtonFit");
		
		root = new BorderPane();
		root.setPrefHeight(fwidth);
		root.setPrefWidth(fheight);
		root.setPadding(new Insets(0,0,0,0));
		
		Color bcol = ImageUtils.getAverageColor(origImage);
		avgImage = ImageUtils.getOneColorImage(origImage.getWidth(), origImage.getHeight(), bcol);
		image2 = new ImageView(avgImage);
		
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
			if (!isAvgImage){
				imageButton.setGraphic(image2);
				isAvgImage = true;
			}
			else {
				imageButton.setGraphic(image1);
				isAvgImage = false;
			}
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}