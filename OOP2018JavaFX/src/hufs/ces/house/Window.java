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
public class Window extends Shape {

	protected boolean sash = false;
	static final int SASHWIDTH = 2;

	public Window(Shape parent){
		super(parent);
	}
	public Window(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g2) {
		// Draw Default Single Window
		int px = absX();
		int py = absY();
		g2.drawRect(px, py, width, height);
		if (sash){
			g2.drawRect(px-SASHWIDTH, py-SASHWIDTH, width+2*SASHWIDTH, height+2*SASHWIDTH);
		}

	}
	/**
	 * @return the sash
	 */
	public boolean isSash() {
		return sash;
	}
	/**
	 * @param sash the sash to set
	 */
	public void setSash(boolean sash) {
		this.sash = sash;
	}

}
