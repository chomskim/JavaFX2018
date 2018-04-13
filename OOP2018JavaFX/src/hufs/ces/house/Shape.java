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
public abstract class Shape implements Drawable {

	protected int x = 0;
	protected int y = 0;
	protected int width = 0;
	protected int height = 0;
	protected Shape parent = null;
	
	public Shape(Shape parent){
		this.parent = parent;
		if (parent!=null){
			this.x = 0;
			this.y = 0;
			this.width = parent.width;
			this.height = parent.height;
		}
	}
	public Shape(Shape parent, int x, int y, int w, int h){
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	public abstract void draw(Graphics2D g2);

	public int absX(){
		if (parent == null){
			return this.x;
		}
		else {
			return this.x + parent.absX();
		}
	}
	public int absY(){
		if (parent == null){
			return this.y;
		}
		else {
			return this.y + parent.absY();
		}
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the parent
	 */
	public Shape getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Shape parent) {
		this.parent = parent;
	}

}
