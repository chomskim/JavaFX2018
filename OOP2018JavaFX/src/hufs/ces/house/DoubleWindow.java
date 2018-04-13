/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

import java.awt.Graphics2D;

/**
 * @author cskim
 *
 */
public class DoubleWindow extends Window {

	public DoubleWindow(Shape parent){
		super(parent);
	}
	public DoubleWindow(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	@Override
	public void draw(Graphics2D g2) {
		// Draw Default Single Window
		int px = absX();
		int py = absY();
		g2.drawRect(px, py, width, height);
		if (sash){
			g2.drawRect(px+SASHWIDTH, py+SASHWIDTH, width-2*SASHWIDTH, height-2*SASHWIDTH);
		}
		g2.drawLine(px, py+height/2, px+width, py+height/2);
	}

}
