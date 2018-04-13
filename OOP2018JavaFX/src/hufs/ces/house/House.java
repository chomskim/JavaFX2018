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
public class House extends Shape {

	private Wall wall = null;
	private Roof roof = null;

	public House(Shape parent){
		super(parent);
	}
	public House(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.house.Shape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g2) {
		wall.draw(g2);
		roof.draw(g2);

	}
	/**
	 * @return the wall
	 */
	public Wall getWall() {
		return wall;
	}
	/**
	 * @param wall the wall to set
	 */
	public void setWall(Wall wall) {
		this.wall = wall;
	}
	/**
	 * @return the roof
	 */
	public Roof getRoof() {
		return roof;
	}
	/**
	 * @param roof the roof to set
	 */
	public void setRoof(Roof roof) {
		this.roof = roof;
	}

}
