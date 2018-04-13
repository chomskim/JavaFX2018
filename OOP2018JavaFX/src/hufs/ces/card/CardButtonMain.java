/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.card;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * @author cskim
 *
 */
public class CardButtonMain extends Application {

	private GridPane root;

	private static final int ROWMAX = 4;
	private static final int COLMAX = 13;

	private CardButton[][] cBtn = new CardButton[ROWMAX][COLMAX];
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Card Buttons");

		root = new GridPane();
		root.setPrefHeight(400);
		root.setPrefWidth(900);
				
		initialize();
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initialize() {

        for (int row = 0 ; row < ROWMAX ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < COLMAX; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(cc);
        }

		
		for (int row=0; row< ROWMAX; row++)
			for (int col=0; col< COLMAX; col++) {
				cBtn[row][col] = new CardButton(row,col+1);
				cBtn[row][col].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				cBtn[row][col].setOnAction(new ButtonHandler(row, col));
				root.add(cBtn[row][col], col, row);
			}
	
	}
	public class ButtonHandler implements EventHandler {
		
		private int rowNum = 0;
		private int colNum = 0;
		
		ButtonHandler(int row, int col) {
			this.rowNum = row;
			this.colNum = col;
		}

		@Override
		public void handle(Event event) {
			cBtn[rowNum][colNum].setCardOpen(!cBtn[rowNum][colNum].isCardOpen());			
		}

	}
}