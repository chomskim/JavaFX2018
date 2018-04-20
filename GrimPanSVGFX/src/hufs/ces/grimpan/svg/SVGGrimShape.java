package hufs.ces.grimpan.svg;

import java.awt.geom.Path2D;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public abstract class SVGGrimShape {
	
	private Shape shape = null;
	
	public SVGGrimShape() {
		super();
	}
	public SVGGrimShape(Shape shape) {
		this.shape = shape;
	}

	public String getSVGStyleString() {
		StringBuilder styleSB = new StringBuilder("style=\"");
		Paint fill = shape.getFill();
		if (fill instanceof Color) {
			Color fcolor = (Color)fill;
			if (fcolor == Color.TRANSPARENT) {
				styleSB.append(" fill:none;");
			}			
			else {
				String colorStr = String.format("rgb(%d,%d,%d)", 
						(int)(fcolor.getRed()*256), (int)(fcolor.getGreen()*256), (int)(fcolor.getBlue()*256));
				styleSB.append(" fill:"+colorStr+";");
			}
		}
		else if (fill != null){
			styleSB.append(" fill:white;");
		}
		Paint stroke = shape.getStroke();
		if (stroke instanceof Color) {
			Color scolor = (Color)stroke;
			if (scolor == Color.TRANSPARENT) {
				styleSB.append(" stroke:none;");
			}
			else {
				String colorStr = String.format("rgb(%d,%d,%d)", 
						(int)(scolor.getRed()*256), (int)(scolor.getGreen()*256), (int)(scolor.getBlue()*256));
				styleSB.append(" stroke:"+colorStr+";");
				Double strokeWidth = shape.getStrokeWidth();
				String widthStr = String.format("%.1f", strokeWidth);
				styleSB.append(" stroke-width:"+widthStr+";");
			}
		}
		else if (stroke != null){
			styleSB.append(" stroke:white;");
		}
		styleSB.append('"');
		
		return styleSB.toString();
	}
	public abstract String getSVGShapeString();

	public abstract Path2D getPath2DShape();
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	

}
