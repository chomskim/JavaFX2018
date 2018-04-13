/**
 * 
 * @author cskim -- hufs.ac.kr 
 * 2016. 4. 14.
 * Copy Right -- Free for Educational Purpose
 *
 */
package hufs.ces.shape2;

/**
 * @author cskim
 *
 */
public class Cuboid extends Rectangle {
	
	private double depth;
	
	public Cuboid() {
		this(0,0,0,0,0);
	}	
	public Cuboid(int x, int y, double w, double h, double d) {
		super(x, y, w, h);
		depth = d;
	}
	@Override
	public double getArea() {
		return 2 * getWidth() * getHeight() +
				   2 * getDepth() * getHeight() +
				   2 * getWidth() * getDepth();
	}

	@Override
	public double getVolume() {
		return getWidth() * getHeight() * getDepth();
	}

	@Override
	public String getName() {
		return "Cuboid";	
	}

	@Override
	public String toString() {
		return 	super.toString() + "; Depth = " + getDepth();

	}

	/**
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(double depth) {
		this.depth = depth;
	}


}
