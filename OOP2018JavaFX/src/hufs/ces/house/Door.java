/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author cskim
 *
 */
public class Door extends Shape {

	private boolean leftKnob = true;
	static final int KNOBGAP = 2;
	static final int KNOBSIZE = 4;

	public Door(Shape parent){
		super(parent);
	}
	public Door(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g2) {
		int ax = absX();
		int ay = absY();
		g2.setColor(Color.BLACK);
		g2.drawRect(ax, ay, width, height);
		
		if (leftKnob){
			g2.drawArc(ax+KNOBGAP, ay+height/2-KNOBSIZE/2, 
					KNOBSIZE, KNOBSIZE, 0, 360);
		}
		else {
			g2.drawArc(ax+width-KNOBGAP-KNOBSIZE, ay+height/2-KNOBSIZE/2, 
					KNOBSIZE, KNOBSIZE, 0, 360);
		}
	}
	/**
	 * @return the leftKnob
	 */
	public boolean isLeftKnob() {
		return leftKnob;
	}
	/**
	 * @param leftKnob the leftKnob to set
	 */
	public void setLeftKnob(boolean leftKnob) {
		this.leftKnob = leftKnob;
	}

}
