/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * @author cskim
 *
 */
public class GambrelRoof extends Roof {

	public GambrelRoof(Shape parent){
		super(parent);
	}
	public GambrelRoof(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw()
	 */
	@Override
	public void draw(Graphics2D g2) {
		int ax = absX();
		int ay = absY();
		
		Polygon roof = new Polygon();
		roof.addPoint(ax, ay+height);
		roof.addPoint(ax+width/6, ay+height/2);
		roof.addPoint(ax+width/2, ay);
		roof.addPoint(ax+width*5/6, ay+height/2);
		roof.addPoint(ax+width, ay+height);
		
		g2.setColor(Color.WHITE);
		g2.fillPolygon(roof);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(roof);
	}

}
