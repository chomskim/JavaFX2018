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
public class DomeRoof extends Roof {

	public DomeRoof(Shape parent){
		super(parent);
	}
	public DomeRoof(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw()
	 */
	@Override
	public void draw(Graphics2D g2) {
		int ax = absX();
		int ay = absY();
		g2.setColor(Color.WHITE);
		g2.fillArc(ax, ay, width, 2*height, 0, 180);
		g2.setColor(Color.BLACK);
		g2.drawArc(ax, ay, width, 2*height, 0, 180);
	}

}
