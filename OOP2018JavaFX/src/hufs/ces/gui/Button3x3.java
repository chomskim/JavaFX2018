package hufs.ces.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Button3x3 extends Application {

	static final int MAX_VALUE = 1000;
	private GridPane root;
	
	private Button btn00;
	private Button btn01;
	private Button btn02;
	private Button btn10;
	private Button btn11;
	private Button btn12;
	private Button btn20;
	private Button btn21;
	private Button btn22;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("3x3 Button");

		root = new GridPane();
		root.setPrefHeight(500);
		root.setPrefWidth(500);
		
		btn00 = new Button("1");
		btn01 = new Button("2");
		btn02 = new Button("3");
		btn10 = new Button("4");
		btn11 = new Button("5");
		btn12 = new Button("6");
		btn20 = new Button("7");
		btn21 = new Button("8");
		btn22 = new Button("");
		
		btn00.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn01.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn02.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn10.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn11.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn12.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn20.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn21.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn22.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
        int numRows = 3 ;
        int numColumns = 3 ;
        for (int row = 0 ; row < numRows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < numColumns; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(cc);
        }

		root.addRow(0, btn00, btn01, btn02);
		root.addRow(1, btn10, btn11, btn12);
		root.addRow(2, btn20, btn21, btn22);
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
