/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.digitalclock;

import java.util.Calendar;
import java.util.Formatter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class DigitalClockPane extends BorderPane {

	private Label lblDate;
	private Label lblTime;
	private Button btnStart;
	
	public DigitalClockPane() {
		
		initialize();
	}
	void initialize() {
		
		this.setPrefSize(450, 300);
		
		lblDate = new Label();
		lblDate.setPrefHeight(100);
		lblDate.setPrefWidth(Double.MAX_VALUE);		
		lblDate.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		lblDate.setTextFill(Color.rgb(0, 128, 0));
		lblDate.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		lblDate.setAlignment(Pos.CENTER);
		lblDate.setTextAlignment(TextAlignment.CENTER);
		this.setTop(lblDate);

		lblTime = new Label();
		lblTime.setTextFill(Color.BLUE);
		lblTime.setAlignment(Pos.CENTER);
		lblTime.setTextAlignment(TextAlignment.CENTER);
		lblTime.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
		lblTime.setPrefWidth(Double.MAX_VALUE);
		this.setCenter(lblTime);
		
		btnStart = new Button("Start");
		btnStart.setPrefHeight(50);
		btnStart.setOnAction(e->startAction());	
		btnStart.setPrefWidth(Double.MAX_VALUE);
		this.setBottom(btnStart);

	}
	void startAction() {
	    // Create an animation for a running clock
	    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e->setTimeDisplay()));
	    animation.setCycleCount(Timeline.INDEFINITE);
	    animation.play(); // Start animation
	}
	
	void setTimeDisplay(){
		
		Calendar calendar = Calendar.getInstance();

		StringBuilder timeText = new StringBuilder();
		Formatter buildTime = new Formatter(timeText);
		buildTime.format("%tT", calendar);
		lblTime.setText(timeText.toString());

		StringBuilder dateText = new StringBuilder();
		Formatter buildDate = new Formatter(dateText);
		buildDate.format("%1$tY.%1$tm.%1$td", calendar);
		lblDate.setText(dateText.toString());
	}

}
