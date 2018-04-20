/**
 * Created on 2015. 3. 8.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.core;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;

/**
 * @author cskim
 *
 */
public class Utils {

	public static final String DEFAULT_DIR = "C:/Temp/";
	
	public static final int MINPOLYDIST = 6;
	
	public static final int SHAPE_REGULAR = 0;
	public static final int SHAPE_OVAL = 1;
	public static final int SHAPE_POLYGON = 2;
	public static final int SHAPE_LINE = 3;
	public static final int SHAPE_PENCIL = 4;
	public static final int EDIT_MOVE = 5;
	
	static public String getExtension(String fileName) {
		String ext = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			ext = fileName.substring(i+1);
		}
		return ext;
	}

	static public Path2D getPath2DFromSwingShape(Shape sh) {
		
		Path2D pa = new Path2D.Double();
		PathIterator iter = sh.getPathIterator(null);
		
		double[] seg = new double[6];
		while (!iter.isDone()) {
			int segType = iter.currentSegment(seg);
			switch (segType) {
			case PathIterator.SEG_MOVETO:
				pa.moveTo(seg[0], seg[1]);
				break;
			case PathIterator.SEG_LINETO:
				pa.lineTo(seg[0], seg[1]);
				break;
			case PathIterator.SEG_QUADTO:
				pa.quadTo(seg[0], seg[1], seg[2], seg[3]);
				break;
			case PathIterator.SEG_CUBICTO:
				pa.curveTo(seg[0], seg[1], seg[2], seg[3], seg[4], seg[5]);
				break;
			case PathIterator.SEG_CLOSE:
				pa.closePath();
				break;
			}
			iter.next();
		}
		return pa;
	}
}
