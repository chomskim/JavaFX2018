/**
 * Created on 2015. 3. 8.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import hufs.ces.grimpan.command.AddCommand;
import hufs.ces.grimpan.command.Command;
import hufs.ces.grimpan.command.MoveCommand;
import hufs.ces.grimpan.sb.DeleteShapeBuilder;
import hufs.ces.grimpan.sb.LineShapeBuilder;
import hufs.ces.grimpan.sb.MoveShapeBuilder;
import hufs.ces.grimpan.sb.OvalShapeBuilder;
import hufs.ces.grimpan.sb.PencilShapeBuilder;
import hufs.ces.grimpan.sb.PolygonShapeBuilder;
import hufs.ces.grimpan.sb.RegularShapeBuilder;
import hufs.ces.grimpan.sb.ShapeBuilder;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class GrimPanModel implements Observable {
	
	private volatile static GrimPanModel uniqueModelInstance;

	private int editState = Utils.SHAPE_PENCIL;
	
	private ShapeFactory sf = ShapeFactory.getInstance(this);
	public final ShapeBuilder[] SHAPE_BUILDERS = {
			new RegularShapeBuilder(this, sf),
			new OvalShapeBuilder(this, sf),
			new PolygonShapeBuilder(this, sf),
			new LineShapeBuilder(this, sf),
			new PencilShapeBuilder(this, sf),
			new MoveShapeBuilder(this, sf),
			new DeleteShapeBuilder(this, sf)
		};
	public ShapeBuilder sb = null;
	
	private float shapeStrokeWidth = 10f;
	private Color shapeStrokeColor = Color.BLACK;
	private boolean shapeStroke = true;
	private boolean shapeFill = false;
	private Color shapeFillColor = null;
	
	public ObservableList<Shape> shapeList = null;
	
	private Point2D startMousePosition = null;
	private Point2D currMousePosition = null;
	private Point2D prevMousePosition = null;
	
	public Shape curDrawShape = null;
	public ArrayList<Point2D> polygonPoints = null;
	private int selectedShapeIndex = -1;
	
	private int nPolygon = 3;
	
	private File saveFile = null;

	private double paneWidth = 0;
	private double paneHeight = 0;
	
	private Point2D movedPos = null;
	
	private ArrayList<InvalidationListener> listenerList = null;
	public Stack<Command> undoCommandStack = null;

	public static GrimPanModel getInstance() {
		if (uniqueModelInstance == null) {
			synchronized (GrimPanModel.class) {
				if (uniqueModelInstance == null) {
					uniqueModelInstance = new GrimPanModel();
				}
			}
		}
		return uniqueModelInstance;
	}
	private GrimPanModel(){
		
		this.shapeList = FXCollections.observableArrayList();
		this.shapeStrokeColor = Color.BLACK;
		this.shapeFillColor = Color.TRANSPARENT;
		this.polygonPoints = new ArrayList<Point2D>();
		this.listenerList = new ArrayList<InvalidationListener>();

		this.setEditState(Utils.SHAPE_PENCIL);
		this.notifyListeners();
		
		this.undoCommandStack = new Stack<Command>();
	}
	@Override
	public void addListener(InvalidationListener li) {
		this.listenerList.add(li);
		
	}
	@Override
	public void removeListener(InvalidationListener li) {
		this.listenerList.remove(li);
		
	}
	public void notifyListeners() {
		for (InvalidationListener lis : this.listenerList) {
			lis.invalidated(this);
		}
	}

	public int getEditState() {
		return editState;
	}

	public void setEditState(int editState) {
		this.editState = editState;
		this.sb = SHAPE_BUILDERS[this.getEditState()];
		notifyListeners();
	}

	public Point2D getStartMousePosition() {
		return startMousePosition;
	}

	public void setStartMousePosition(Point2D mousePosition) {
		this.startMousePosition = mousePosition;
	}
	public Point2D getPrevMousePosition() {
		return prevMousePosition;
	}

	public void setPrevMousePosition(Point2D mousePosition) {
		this.prevMousePosition = mousePosition;
	}

	public Point2D getCurrMousePosition() {
		return currMousePosition;
	}

	public void setCurrMousePosition(Point2D clickedMousePosition) {
		this.currMousePosition = clickedMousePosition;
	}
	public void readShapeFromSaveFile(File saveFile) {
		/*
		this.saveFile = saveFile;
		ObjectInputStream input;
		try {
			input =
				new ObjectInputStream(new FileInputStream(this.saveFile));
			this.shapeList = (ArrayList<Shape>) input.readObject();
			input.close();

		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Exception");
			e.printStackTrace();
		}
		*/
	}
	public void saveGrimPanData(File saveFile){
		/*
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream(saveFile));
			output.writeObject(this.shapeList);
			output.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Exception");
			e.printStackTrace();
		}
		*/
	}
	/**
	 * @return the saveFile
	 */
	public File getSaveFile() {
		return saveFile;
	}

	/**
	 * @param saveFile the saveFile to set
	 */
	public void setSaveFile(File saveFile) {
		this.saveFile = saveFile;
		//mainFrame.setTitle("±×¸²ÆÇ - "+saveFile.getPath());
	}
	/**
	 * @return the nPolygon
	 */
	public int getNPolygon() {
		return nPolygon;
	}

	/**
	 * @param nPolygon the nPolygon to set
	 */
	public void setNPolygon(int nPolygon) {
		this.nPolygon = nPolygon;
	}

	/**
	 * @return the selectedShape
	 */
	public int getSelectedShapeIndex() {
		return selectedShapeIndex;
	}

	/**
	 * @param selectedShape the selectedShape to set
	 */
	public void setSelectedShapeIndex(int selIndex) {
		this.selectedShapeIndex = selIndex;
	}
	
	public void getSelectedShape(){
		int selIndex = -1;
		Shape shape = null;
		for (int i=this.shapeList.size()-1; i >= 0; --i){
			shape = this.shapeList.get(i);
			if (shape.contains(this.getStartMousePosition().getX(), this.getStartMousePosition().getY())){
				selIndex = i;
				break;
			}
		}
		if (selIndex != -1){
			Color scolor = (Color)shape.getStroke();
			Color fcolor = (Color)shape.getFill();
			if (shape.getStroke()!=Color.TRANSPARENT){
				shape.setStroke(new Color (scolor.getRed(), scolor.getGreen(), scolor.getBlue(), 0.5));
			}
			if (shape.getFill()!=Color.TRANSPARENT){
				shape.setFill(new Color (fcolor.getRed(), fcolor.getGreen(), fcolor.getBlue(), 0.5));
			}
		}
		this.setSelectedShapeIndex(selIndex);
	}

	/**
	 * @return the shapeStrokeColor
	 */
	public Color getShapeStrokeColor() {
		return shapeStrokeColor;
	}

	/**
	 * @param shapeStrokeColor the shapeStrokeColor to set
	 */
	public void setShapeStrokeColor(Color shapeStrokeColor) {
		this.shapeStrokeColor = shapeStrokeColor;
	}

	/**
	 * @return the shapeFill
	 */
	public boolean isShapeFill() {
		return shapeFill;
	}

	/**
	 * @param shapeFill the shapeFill to set
	 */
	public void setShapeFill(boolean shapeFill) {
		this.shapeFill = shapeFill;
	}

	/**
	 * @return the shapeFillColor
	 */
	public Color getShapeFillColor() {
		return shapeFillColor;
	}

	/**
	 * @param shapeFillColor the shapeFillColor to set
	 */
	public void setShapeFillColor(Color shapeFillColor) {
		this.shapeFillColor = shapeFillColor;
	}

	/**
	 * @return the shapeStrokeWidth
	 */
	public float getShapeStrokeWidth() {
		return shapeStrokeWidth;
	}

	/**
	 * @param shapeStrokeWidth the shapeStrokeWidth to set
	 */
	public void setShapeStrokeWidth(float shapeStrokeWidth) {
		this.shapeStrokeWidth = shapeStrokeWidth;
	}

	public boolean isShapeStroke() {
		return shapeStroke;
	}

	public void setShapeStroke(boolean shapeStroke) {
		this.shapeStroke = shapeStroke;
	}
	public double getPaneWidth() {
		return paneWidth;
	}
	public void setPaneWidth(double paneWidth) {
		this.paneWidth = paneWidth;
		this.notifyListeners();
	}
	public double getPaneHeight() {
		return paneHeight;
	}
	public void setPaneHeight(double paneHeight) {
		this.paneHeight = paneHeight;
		this.notifyListeners();
	}
	public String getSizeText() {
		StringBuilder text = new StringBuilder("Size:");
		if (paneWidth==0 || paneHeight==0)
			return text.toString();
		
		text.append(String.valueOf((int)paneWidth));
		text.append('x');
		text.append(String.valueOf((int)paneHeight));

		return text.toString();
	}
	public void addShapeAction() {
		Command addCommand = new AddCommand(this, this.curDrawShape);
		this.undoCommandStack.push(addCommand);// save for undo
		addCommand.execute();

	}

	/**
	 * 
	 */
	public void moveShapeAction() {
		Command moveCommand = new MoveCommand(this, this.getMovedPos());
		this.undoCommandStack.push(moveCommand);// save for undo
		moveCommand.execute();
	}
	public void undoAction() {
		if (this.undoCommandStack.isEmpty())
			return;
		
		Command comm = this.undoCommandStack.pop();
		comm.undo();
		
		this.notifyListeners();
	}
	public Point2D getMovedPos() {
		return movedPos;
	}
	public void setMovedPos(Point2D movedPos) {
		this.movedPos = movedPos;
	}
}
