/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.core;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import org.controlsfx.tools.Borders;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableDoubleValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GrimPanPane extends VBox implements InvalidationListener {

	private GrimPanModel model;

	private MenuItem menuNew;
	private MenuItem menuOpen;    
	private MenuItem menuSave;    
	private MenuItem menuSaveAs;    
	private MenuItem menuExit;    
	private RadioMenuItem menuLine;    
	private ToggleGroup shapeGroup;    
	private RadioMenuItem menuPencil;    
	private RadioMenuItem menuPolygon;    
	private RadioMenuItem menuRegular;    
	private RadioMenuItem menuOval;  
	private MenuItem menuUndo;
	private MenuItem menuMove;    
	private MenuItem menuDelete;    
	private MenuItem menuStrokeWidth;    
	private MenuItem menuStrokeColor;    
	private MenuItem menuFillColor;    
	private CheckMenuItem menuCheckStroke;    
	private CheckMenuItem menuCheckFill;    
	private MenuItem menuAbout;    
	private DrawPane drawPane; 
	
	private Node borderedPane;
	private FlowPane statusPane;
	private Label shapeLbl;
	private Label sizeLbl;
	private Label messageLbl;
	private Label modeLbl;
	private Label countLbl;
	
	ColorPicker strokeColorPicker = new ColorPicker(Color.BLACK);
	ColorPicker fillColorPicker = new ColorPicker();

	public GrimPanPane() {

		this.model = GrimPanModel.getInstance();
		model.addListener(this);
		
		initialize();
	}

	void initialize() {
		MenuBar menuBar = new MenuBar();
		Menu mFile = new Menu("File");
		Menu mShape = new Menu("Shape");
		Menu mEdit = new Menu("Edit");
		Menu mSetting = new Menu("Setting");
		Menu mHelp = new Menu("Help");

		menuBar.getMenus().addAll(mFile, mShape, mEdit, mSetting, mHelp);

		menuNew = new MenuItem("New");
		menuNew.setOnAction(e->handleMenuNew(e));
		menuOpen = new MenuItem("Open");
		menuSave = new MenuItem("Save");
		menuSaveAs = new MenuItem("Save As ...");
		menuExit = new MenuItem("Exit");
		menuExit.setOnAction(e->handleMenuExit(e));
		mFile.getItems().addAll(menuNew, menuOpen, menuSave, menuSaveAs, new SeparatorMenuItem(), menuExit);

		ToggleGroup shapeGroup = new ToggleGroup();
		menuLine = new RadioMenuItem("Line");
		menuLine.setOnAction(e->handleMenuLine(e));
		menuPencil = new RadioMenuItem("Pencil");
		menuPencil.setOnAction(e->handleMenuPencil(e));
		menuPolygon = new RadioMenuItem("Polygon");
		menuPolygon.setOnAction(e->handleMenuPolygon(e));
		menuRegular = new RadioMenuItem("Regular");
		menuRegular.setOnAction(e->handleMenuRegular(e));
		menuOval = new RadioMenuItem("Oval");
		menuOval.setOnAction(e->handleMenuOval(e));

		menuLine.setToggleGroup(shapeGroup);
		menuPencil.setToggleGroup(shapeGroup);
		menuPolygon.setToggleGroup(shapeGroup);
		menuRegular.setToggleGroup(shapeGroup);
		menuOval.setToggleGroup(shapeGroup);

		menuPencil.setSelected(true);
		mShape.getItems().addAll(menuLine, menuPencil, menuPolygon, menuRegular, menuOval);

		menuUndo = new MenuItem("Undo");
		menuUndo.setOnAction(e->handleMenuUndo(e));
		
		menuMove = new MenuItem("Move");
		menuMove.setOnAction(e->handleMenuMove(e));

		menuDelete = new MenuItem("Delete");
		mEdit.getItems().addAll(menuUndo, menuMove, menuDelete);

		menuStrokeWidth = new MenuItem("Stroke Width");
		menuStrokeWidth.setOnAction(e->handleMenuStrokeWidth(e));

		//menuStrokeColor = new MenuItem("Stroke Color", strokeColorPicker);
		menuStrokeColor = new MenuItem("Stroke Color");
		menuStrokeColor.setOnAction(e->handleMenuStrokeColor(e));

		menuCheckStroke = new CheckMenuItem("Stroke");
		menuCheckStroke.setSelected(true);
		menuCheckStroke.setOnAction(e->handleMenuCheckStroke(e));

		//menuFillColor = new MenuItem("Fill Color", fillColorPicker);   
		menuFillColor = new MenuItem("Fill Color");   
		menuFillColor.setOnAction(e->handleMenuFillColor(e));

		menuCheckFill = new CheckMenuItem("Fill");
		menuCheckFill.setOnAction(e->handleMenuCheckFill(e));

		mSetting.getItems().addAll(menuStrokeWidth, menuStrokeColor, menuFillColor, menuCheckStroke, menuCheckFill);

		menuAbout = new MenuItem("About");
		menuAbout.setOnAction(e->handleMenuAbout(e));
		mHelp.getItems().addAll(menuAbout);

		drawPane = new DrawPane();
		drawPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		drawPane.setOnMousePressed(e->handleMousePressed(e));
		drawPane.setOnMouseReleased(e->handleMouseReleased(e));
		drawPane.setOnMouseDragged(e->handleMouseDragged(e));

		statusPane = new FlowPane();
		statusPane.setHgap(15);
		statusPane.setPadding(new Insets(0));
		statusPane.setPrefHeight(80);
		
		sizeLbl = new Label(model.getSizeText());
		statusPane.getChildren().add(sizeLbl);
		drawPane.widthProperty().addListener(obs -> {
			double val = ((ObservableDoubleValue)obs).get();
		    model.setPaneWidth(val);
		    //sizeLbl.setText(model.getSizeText());
		});
		drawPane.heightProperty().addListener((obs, oldVal, newVal) -> {
			double val = ((ObservableDoubleValue)obs).get();
		    model.setPaneHeight(val);
		    //sizeLbl.setText(model.getSizeText());
		});

		shapeLbl = new Label("Shape:              ");
		statusPane.getChildren().add(shapeLbl);

		modeLbl = new Label("Mode:               ");
		statusPane.getChildren().add(modeLbl);

		countLbl = new Label("Count:               ");		
		statusPane.getChildren().add(countLbl);
		
		messageLbl = new Label("  ");
		statusPane.getChildren().add(messageLbl);
		
		borderedPane = Borders.wrap(statusPane)
				.etchedBorder().innerPadding(3).outerPadding(2).buildAll();
		this.getChildren().addAll(menuBar, drawPane, borderedPane);
		//System.out.println("DrawPane w="+drawPane.getWidth()+" h="+drawPane.getHeight());

		initDrawPane();

	}

	void initDrawPane() {
		model.shapeList.clear();
		model.curDrawShape = null;
		model.polygonPoints.clear();
		// Add Dummy Shape for Mouse Event occur
		model.shapeList.add(new Circle(2000,2000,3,Color.TRANSPARENT));
		drawPane.redraw();
	}

	// File Menu handler
	void handleMenuNew(ActionEvent event) {
		initDrawPane();
	}    
	void handleMenuOpen(ActionEvent event) {

	}
	void handleMenuSave(ActionEvent event) {

	}
	void handleMenuSaveAs(ActionEvent event) {

	}
	void handleMenuExit(ActionEvent event) {
		System.exit(0);
	}

	// Shape Menu handler
	void handleMenuLine(ActionEvent event) {
		model.setEditState(Utils.SHAPE_LINE);
		drawPane.redraw();
	}
	void handleMenuPencil(ActionEvent event) {
		model.setEditState(Utils.SHAPE_PENCIL);
		drawPane.redraw();
	}
	void handleMenuOval(ActionEvent event) {
		model.setEditState(Utils.SHAPE_OVAL);
		drawPane.redraw();
	}
	void handleMenuRegular(ActionEvent event) {
		model.setEditState(Utils.SHAPE_REGULAR);
		Object[] possibleValues = { 
				"3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12"
		};
		Object selectedValue = JOptionPane.showInputDialog(null,
				"Choose one", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
		model.setNPolygon(Integer.parseInt((String)selectedValue));

		drawPane.redraw();
	}

	void handleMenuPolygon(ActionEvent event) {
		model.setEditState(Utils.SHAPE_POLYGON);
		drawPane.redraw();
	}    

	// Edit Menu handler
	void handleMenuUndo(ActionEvent event) {
		model.undoAction();
		drawPane.redraw();
	}
	void handleMenuMove(ActionEvent event) {

		model.setEditState(Utils.EDIT_MOVE);
		if (model.curDrawShape != null){
			model.shapeList.add(model.curDrawShape);
			model.curDrawShape = null;
		}
		drawPane.redraw();
	}
	void handleMenuDelete(ActionEvent event) {

	}    

	// Setting Menu handler
	void handleMenuStrokeColor(ActionEvent event) {
		//model.setShapeStrokeColor(strokeColorPicker.getValue());
		//System.out.println("stroke color="+strokeColorPicker.getValue());
		java.awt.Color awtColor = 
				JColorChooser.showDialog(null, "Choose a color", java.awt.Color.BLACK);
		Color jxColor = Color.BLACK;
		if (awtColor!=null){
			jxColor = new Color(awtColor.getRed()/255.0, awtColor.getGreen()/255.0, awtColor.getBlue()/255.0, 1);
		}
		model.setShapeStrokeColor(jxColor);

	}    
	void handleMenuStrokeWidth(ActionEvent event) {

		String inputVal = JOptionPane.showInputDialog("Stroke Width", "1");
		if (inputVal!=null){
			model.setShapeStrokeWidth(Float.parseFloat(inputVal));
		}
		else {
			model.setShapeStrokeWidth(1f);
		}
	}
	void handleMenuCheckStroke(ActionEvent event) {
		CheckMenuItem checkStroke = (CheckMenuItem)event.getSource();
		if (checkStroke.isSelected())
			model.setShapeStroke(true);
		else
			model.setShapeStroke(false);
	}

	void handleMenuFillColor(ActionEvent event) {
		//model.setShapeFillColor(fillColorPicker.getValue());
		java.awt.Color awtColor = 
				JColorChooser.showDialog(null, "Choose a color", java.awt.Color.BLACK);
		Color jxColor = Color.BLACK;
		if (awtColor!=null){
			jxColor = new Color(awtColor.getRed()/255.0, awtColor.getGreen()/255.0, awtColor.getBlue()/255.0, 1);
		}
		model.setShapeFillColor(jxColor);
	}
	void handleMenuCheckFill(ActionEvent event) {
		CheckMenuItem checkFill = (CheckMenuItem)event.getSource();
		if (checkFill.isSelected())
			model.setShapeFill(true);
		else
			model.setShapeFill(false);
	}

	// Help Menu handler
	void handleMenuAbout(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("GrimPan Ver 0.3.2");
		alert.setContentText("Programmed by cskim, ces, hufs.ac.kr");

		alert.showAndWait();
	}


	// Mouse Event Handler
	void handleMousePressed(MouseEvent event) {

		if (event.getButton()==MouseButton.PRIMARY){
			model.sb.performMousePressed(event);
		}		
		drawPane.redraw();

	}    
	void handleMouseReleased(MouseEvent event) {

		if (event.getButton()==MouseButton.PRIMARY){
			model.sb.performMouseReleased(event);
		}
		drawPane.redraw();
		
	}
	void handleMouseDragged(MouseEvent event) {

		if (event.getButton()==MouseButton.PRIMARY){
			model.sb.performMouseDragged(event);
		}
		drawPane.redraw();
	}
	@Override
	public void invalidated(Observable obs) {
		GrimPanModel mo = (GrimPanModel)obs;
		sizeLbl.setText(mo.getSizeText());
		
		shapeLbl.setText("Shape:");

		modeLbl.setText("Mode:");

		countLbl.setText("Count:"+(mo.shapeList.size()-1));
		
		drawPane.redraw();
	}

}
