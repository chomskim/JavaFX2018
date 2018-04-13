/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.clock;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class FancyClockPane extends ClockPane {

	/** Paint the clock */
	@Override
	protected void paintClock() {
		// Initialize clock parameters
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;

		// Draw circle
		Stop[] stops = new Stop[] { new Stop(0, Color.GRAY), new Stop(1, Color.WHITE)};
		LinearGradient lg1 = new LinearGradient(0, 0, centerX, centerY, false, CycleMethod.REFLECT, stops);
		Circle circle = new Circle(centerX, centerY, clockRadius);
		
		circle.setFill(lg1);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

		// Draw second hand
		double sLength = clockRadius * 0.8;
		MoveTo m1 = new MoveTo(-3, 0);
		LineTo l1 = new LineTo(-6, -3);
		LineTo l2 = new LineTo(sLength, 0);
		LineTo l3 = new LineTo(-6, 3);
		ClosePath cp = new ClosePath();
		Path secHand = new Path(m1, l1, l2, l3, cp);
		
		Rotate rotate = new Rotate();
		rotate.setPivotX(0);
		rotate.setPivotY(0);
		rotate.setAngle(Math.toDegrees(second * (2 * Math.PI / 60)-Math.PI/2));
		Translate translate = new Translate(centerX, centerY);

		secHand.getTransforms().addAll(translate, rotate);
		secHand.setFill(Color.RED);
		
		// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);

		// Draw hour hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);

		getChildren().clear();  
		getChildren().addAll(circle, t1, t2, t3, t4, secHand, mLine, hLine);
		
	}

}
