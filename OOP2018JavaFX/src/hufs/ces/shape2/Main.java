/**
 * 
 * @author cskim -- hufs.ac.kr 
 * 2016. 4. 7.
 * Copy Right -- Free for Educational Purpose
 *
 */
package hufs.ces.shape2;

import java.util.ArrayList;

/**
 * @author cskim
 *
 */
public class Main {

	static ArrayList<Shape> shapeList = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point point = new Point(7,11);
		Circle circle = new Circle(22, 8, 3.5);
		Cylinder cylinder = new Cylinder(20, 30, 3.3, 10.75);
		Rectangle rect = new Rectangle(10, 10, 10.0, 5.0);
		Cuboid cub = new Cuboid(10, 10, 5.0, 3.0, 10.0);

		shapeList = new ArrayList<Shape>();
		shapeList.add(point);
		shapeList.add(circle);
		shapeList.add(cylinder);
		shapeList.add(rect);
		shapeList.add(cub);

		for (Shape s:shapeList){
			System.out.println(s.getName()+" "+ s);
			System.out.println("Area="+s.getArea()+" Volume="+s.getVolume());
		}
	}

}
