/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.clock;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class AppleClockPane extends ClockPane {

	double clockRadius;
	double centerX;
	double centerY;
	
	public AppleClockPane() {
		this.setBackground(new Background(new BackgroundFill(Color.rgb(240, 240, 240), CornerRadii.EMPTY, Insets.EMPTY)));
	}
	@Override
	protected void paintClock() {
		// Initialize clock parameters
		clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		centerX = getWidth() / 2;
		centerY = getHeight() / 2;

		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		
		circle.setFill(Color.WHITE);
		getChildren().clear();
		getChildren().add(circle);
		
		// Draw Min Tick
		double minLeng = clockRadius*16/160;
		for (int i = 0; i < 60; i++) {
			Line minTick = new Line(0, -clockRadius + 5, 0, -clockRadius + 5 + minLeng);
			minTick.setStrokeWidth(Math.max(clockRadius*3/160, 1));
			minTick.setStrokeLineCap(StrokeLineCap.BUTT);
			Rotate rot1 = new Rotate();
			rot1.setPivotX(0);
			rot1.setPivotY(0);
			rot1.setAngle(Math.toDegrees(i*2*Math.PI/60));
			Translate tra1 = new Translate(centerX, centerY);

			minTick.getTransforms().addAll(tra1, rot1);
			getChildren().add(minTick);
		}
		// Draw Hour Tick
		double hourLeng = clockRadius*36/160;
		for (int i = 0; i < 12; i++) {
			Line hourTick = new Line(0, -clockRadius + 5, 0, -clockRadius + 5 + hourLeng);
			hourTick.setStrokeWidth(clockRadius*13/160);
			hourTick.setStrokeLineCap(StrokeLineCap.BUTT);
			Rotate rot2 = new Rotate();
			rot2.setPivotX(0);
			rot2.setPivotY(0);
			rot2.setAngle(Math.toDegrees(i*2*Math.PI/12));
			Translate tra2 = new Translate(centerX, centerY);

			hourTick.getTransforms().addAll(tra2, rot2);
			getChildren().add(hourTick);			
		}
		// Draw Name of Clock
		Text clockName = new Text(centerX-clockRadius*0.32, centerY+clockRadius*0.6, "Apple Zaktung");
		clockName.setFont(Font.font("Verdana", FontWeight.NORMAL, clockRadius*0.1));
		getChildren().add(clockName);

		// Draw Hands and Shadow
		Group hands = new Group();
		// Draw minute hand
		Line minHand = new Line(0, clockRadius*0.3, 0, -clockRadius*0.85);
		minHand.setStrokeWidth(clockRadius*13/160);
		minHand.setStrokeLineCap(StrokeLineCap.BUTT);
		Rotate rot3 = new Rotate();
		rot3.setPivotX(0);
		rot3.setPivotY(0);
		rot3.setAngle(Math.toDegrees(minute * (2 * Math.PI / 60)));
		Translate tra3 = new Translate(centerX, centerY);
		minHand.getTransforms().addAll(tra3, rot3);
		hands.getChildren().add(minHand);
		
		// Draw hour hand
		Line hourHand = new Line(0, clockRadius*0.3, 0, -clockRadius*0.5);
		hourHand.setStrokeWidth(clockRadius*13/160);
		hourHand.setStrokeLineCap(StrokeLineCap.BUTT);
		Rotate rot4 = new Rotate();
		rot4.setPivotX(0);
		rot4.setPivotY(0);
		rot4.setAngle(Math.toDegrees((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		Translate tra4 = new Translate(centerX, centerY);
		hourHand.getTransforms().addAll(tra4, rot4);
		hands.getChildren().add(hourHand);			

		// Draw second hand
		double centerS = clockRadius*5/160;
		Circle secCircle = new Circle(centerX, centerY, centerS);
		secCircle.setFill(Color.RED);
		hands.getChildren().add(secCircle);	

		Line secHand = new Line(0, clockRadius*0.26, 0, -clockRadius*0.68);
		secHand.setStroke(Color.RED);
		secHand.setStrokeWidth(clockRadius*4/160);
		secHand.setStrokeLineCap(StrokeLineCap.BUTT);
		Rotate rot5 = new Rotate();
		rot5.setPivotX(0);
		rot5.setPivotY(0);
		rot5.setAngle(Math.toDegrees(second * (2 * Math.PI / 60)));
		Translate tra5 = new Translate(centerX, centerY);
		secHand.getTransforms().addAll(tra5, rot5);
		hands.getChildren().add(secHand);
				
		// Draw Red Circle at End Point		
		double endRa = clockRadius*10/160d;
		double endX = -endRa;
		double endY = -clockRadius*0.7;
		double endCX = endX + endRa;
		double endCY = endY + endRa;
		
		Circle endCircle = new Circle(endCX, endCY, endRa);
		endCircle.setFill(Color.RED);

		Rotate rot6 = new Rotate();
		rot6.setPivotX(0);
		rot6.setPivotY(0);
		rot6.setAngle(Math.toDegrees(second * (2 * Math.PI / 60)));
		Translate tra6 = new Translate(centerX, centerY);
		endCircle.getTransforms().addAll(tra6, rot6);
		hands.getChildren().add(endCircle);			
		
		double ratio = clockRadius / 160;
		DropShadow sha = new DropShadow();
		sha.setWidth(5*ratio);
		sha.setHeight(5*ratio);
		sha.setOffsetX(3*ratio);
		sha.setOffsetY(3*ratio);
		sha.setRadius(5*ratio);
		hands.setEffect(sha);
		
		getChildren().add(hands);
	}
}
