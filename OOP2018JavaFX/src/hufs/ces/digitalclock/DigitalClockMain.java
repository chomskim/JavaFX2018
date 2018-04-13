/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.digitalclock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DigitalClockMain extends Application{

	@Override
	public void start(Stage primaryStage) {

		DigitalClockPane root = new DigitalClockPane();
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
