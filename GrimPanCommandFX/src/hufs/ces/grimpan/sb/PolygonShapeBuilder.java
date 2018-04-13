/**
 * Created on 2015. 3. 8.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.sb;

import hufs.ces.grimpan.core.GrimPanModel;
import hufs.ces.grimpan.core.ShapeFactory;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * @author cskim
 *
 */
public class PolygonShapeBuilder implements ShapeBuilder {

	ShapeFactory sf = null;	
	GrimPanModel model = null;
	
	public PolygonShapeBuilder(GrimPanModel model, ShapeFactory sf){
		this.model = model;
		this.sf = sf;
	}
	/* (non-Javadoc)
	 * @see hufs.cse.grimpan.strategy.ShapeBuilder#performMousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void performMousePressed(MouseEvent event) {
		Point2D p1 = new Point2D(Math.max(0, event.getX()), Math.max(0, event.getY()));
		model.setStartMousePosition(p1);
		model.setCurrMousePosition(p1);
		model.setPrevMousePosition(p1);		

		model.polygonPoints.add(model.getCurrMousePosition());
		if (event.isShiftDown()) {
			//((Path)model.curDrawShape).getElements().add(new ClosePath());
			model.curDrawShape = sf.createPolygonFromClickedPoints();
			model.polygonPoints.clear();
			model.shapeList.add(model.curDrawShape);
			model.curDrawShape = null;
			model.addShapeAction();
		}
		else {
			model.curDrawShape = sf.createPolylineFromClickedPoints();
		}
	}

	/* (non-Javadoc)
	 * @see hufs.cse.grimpan.strategy.ShapeBuilder#performMouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void performMouseReleased(MouseEvent event) {
		Point2D p1 = new Point2D(Math.max(0, event.getX()), Math.max(0, event.getY()));
		model.setPrevMousePosition(model.getCurrMousePosition());
		model.setCurrMousePosition(p1);

	}

	/* (non-Javadoc)
	 * @see hufs.cse.grimpan.strategy.ShapeBuilder#performMouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void performMouseDragged(MouseEvent event) {
		Point2D p1 = new Point2D(Math.max(0, event.getX()), Math.max(0, event.getY()));
		model.setPrevMousePosition(model.getCurrMousePosition());
		model.setCurrMousePosition(p1);

	}

}
