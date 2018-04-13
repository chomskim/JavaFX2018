/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author cskim
 *
 */
public class Wall extends Shape {

	private Door door = null;
	public ArrayList<Window> windows = null;
	
	public Wall(Shape parent){
		super(parent);
		windows = new ArrayList<Window>();
	}
	public Wall(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
		windows = new ArrayList<Window>();
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g2) {
		int ax = absX();
		int ay = absY();
		
		g2.setColor(Color.WHITE);
		g2.fillRect(ax, ay, width, height);
		g2.setColor(Color.BLACK);
		g2.drawRect(ax, ay, width, height);

		if (door!=null)
			door.draw(g2);
		
		for (Window w:windows){
			w.draw(g2);
		}

	}
	/**
	 * @return the door
	 */
	public Door getDoor() {
		return door;
	}
	/**
	 * @param door the door to set
	 */
	public void setDoor(Door door) {
		this.door = door;
	}

}
