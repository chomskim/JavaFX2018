/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.core;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GrimPanCommandFXMain  extends Application {

	@Override
	public void start(Stage primaryStage){


		GrimPanPane root = new GrimPanPane();
		Scene scene = new Scene(root, 800, 600);

		primaryStage.setTitle("GrimPan");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
