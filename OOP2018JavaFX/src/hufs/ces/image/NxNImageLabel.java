/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.image;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class NxNImageLabel extends Application {


	private static final int PROWS = 10;

	private Label[][] tiles = new Label[PROWS][PROWS];
	private Image tileImage = null;

	double scrHeight = 500;
	double scrWidth = 500;
	double bwidth = 0;
	double bheight = 0;

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

		bwidth = scrWidth/PROWS;
		bheight = scrHeight/PROWS;

		//System.out.println("w="+bwidth+" h="+bheight);
		tileImage = new Image(getClass().getResourceAsStream("/images/androidlogo500x500.png"), bwidth, bheight, false, false);
		for (int row=0; row<PROWS; ++row){
			for (int col=0; col<PROWS; ++col) {
				tiles[row][col] = new Label();
				tiles[row][col].setGraphic(new ImageView(tileImage));
				tiles[row][col].setMaxSize(bwidth, bheight);
				root.add(tiles[row][col], col, row);
			}
		}

	}
}
