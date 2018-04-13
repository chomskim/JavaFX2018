/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

/**
 * @author cskim
 *
 */
public abstract class Roof extends Shape {

	public Roof(Shape parent){
		super(parent);
	}
	public Roof(Shape parent, int x, int y, int w, int h){
		super(parent, x, y, w, h);
	}
}
