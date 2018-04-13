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
public class Circle extends Point {

	private	double radius;

	public Circle() {
		this(0,0,0);
	}
	public Circle(int x, int y, double radiusValue) {
		super(x,y) ;
		setRadius(radiusValue);
	}
	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#getArea()
	 */
	@Override
	public double getArea() {
		return Math.PI * getRadius() * getRadius(); 
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
		return "Circle";	
	}

	/* (non-Javadoc)
	 * @see hufs.cse.shape2.Shape#putValue()
	 */
	@Override
	public String toString() {
		return 	"Center = " +
		super.toString() +
		"; Radius = " + getRadius();


	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getDiameter() { 
		return 2 * getRadius(); 
	}
	public double getCircumference() {	
		return Math.PI * getDiameter(); 
		}
	
}
