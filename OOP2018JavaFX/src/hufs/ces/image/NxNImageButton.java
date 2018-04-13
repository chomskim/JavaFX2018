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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NxNImageButton extends Application {

	private static final int PROWS = 10;

	private Button[][] tiles = new Button[PROWS][PROWS];
	private Image tileImage = null;

	double scrHeight = 500;
	double scrWidth = 500;
	int bwidth = 0;
	int bheight = 0;

	ImageView whiteTile = null;
	
	private GridPane root;

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("NxN Label");

		root = new GridPane();
		root.setPrefHeight(scrHeight);
		root.setPrefWidth(scrWidth);

		initialize();

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

	void initialize(){

		for (int row = 0 ; row < PROWS ; row++ ){
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			root.getRowConstraints().add(rc);
		}
		for (int col = 0 ; col < PROWS; col++ ) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			root.getColumnConstraints().add(cc);
		}

		bwidth = (int)scrWidth/PROWS;
		bheight = (int)scrHeight/PROWS;
		
		whiteTile = new ImageView(ImageUtils.getOneColorImage((double)bwidth, (double)bheight, Color.WHITE));
		tileImage = new Image(getClass().getResourceAsStream("/images/androidlogo500x500.png"));
		for (int row=0; row<PROWS; ++row){
			for (int col=0; col<PROWS; ++col) {
				tiles[row][col] = new Button();
				tiles[row][col].setPadding(new Insets(0,0,0,0));
				tiles[row][col].setGraphic(new ImageView(ImageUtils.getSubImage(tileImage, bwidth*col, bheight*row, bwidth, bheight)));
				tiles[row][col].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				tiles[row][col].setOnAction(e->changeWhite(e));
				root.add(tiles[row][col], col, row);
			}
		}

	}
	void changeWhite(ActionEvent e) {
		Button btn = (Button)e.getSource();
		btn.setGraphic(whiteTile);
	}
}
