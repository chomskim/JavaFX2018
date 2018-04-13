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
public class Cylinder extends Circle {
	private double height;
	
	public Cylinder() {}
	public Cylinder(int x, int y, double radius, double heightValue) {
		super(x, y, radius);
		setHeight(heightValue);
	}
	public double getArea() {
		return 2 * super.getArea() + getCircumference() * getHeight();
	}
	public double getVolume() { 
		return super.getArea() * getHeight(); 
		}
	public String getName() { 
		return "Cylinder"; 
		}
	public String toString() {
		return super.toString()+ "; Height = " + getHeight();
	}
	

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
}
