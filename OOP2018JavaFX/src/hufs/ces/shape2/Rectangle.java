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
public class Rectangle extends Point {

	private double width;
	private double height;
	
	public Rectangle() {
		this(0,0);
	}
	public Rectangle(double w, double h) {
		this(0,0,w,h);
	}
	public Rectangle(int x, int y, double w, double h) {
		super(x, y);
		width = w;
		height = h;
	}
	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#getArea()
	 */
	@Override
	public double getArea() {
		return getWidth() * getHeight(); 
	}

	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#getVolume()
	 */
	@Override
	public double getVolume() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#getName()
	 */
	@Override
	public String getName() {
		return "Rectangle";	
	}

	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#putValue()
	 */
	@Override
	public String toString() {
		return 	"Top Left = " +
		super.toString() +
		"; Width = " + getWidth()+" Height = "+ getHeight();


	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
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
