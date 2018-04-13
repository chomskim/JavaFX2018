package hufs.ces.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OneButtonMain extends Application {

	private BorderPane root;
	private Button bigButton;

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("OneButton");

		root = new BorderPane();
		root.setPrefHeight(400);
		root.setPrefWidth(600);
		
		bigButton = new Button("Push Me!!");
		bigButton.setMaxHeight(1600);
		bigButton.setMaxWidth(2400);
		bigButton.setOnAction(e->handleBigButton(e));
		
		root.setCenter(bigButton);
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
    void handleBigButton(ActionEvent event) {
    	bigButton.setText("You Pushed Me.");
    }

	public static void main(String[] args) {
		launch(args);
	}
}
