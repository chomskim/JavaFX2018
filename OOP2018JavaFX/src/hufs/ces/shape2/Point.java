/**
 * 
 * @author cskim -- hufs.ac.kr 
 * 2016. 4. 7.
 * Copy Right -- Free for Educational Purpose
 *
 */
package hufs.ces.shape2;

/**
 * @author cskim
 *
 */
public class Point implements Shape {

	private int x;
	private int y;
	
	public Point() {
		this(0, 0);
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public double getArea() {

		return 0;
	}
	@Override
	public double getVolume() {

		return 0;
	}
	@Override
	public String getName() {
		return "Point";	
	}
	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "]";

	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


}
