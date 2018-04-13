/**
 * Created on Nov 20, 2012
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.house;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author cskim
 *
 */
public class HouseFrame extends JFrame {

	private JPanel contentPane;
	private HouseModel houseModel = new HouseModel();
	private DrawPanel drawPanel = new DrawPanel(houseModel);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseFrame frame = new HouseFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HouseFrame() {
		setTitle("Houses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(drawPanel, BorderLayout.CENTER);
		
		buildHouse2();
	}

	void buildHouse(){
		House house1 = new House(null, 50, 50, 200, 350);
		Roof roof1 = new DomeRoof(house1, 0, 0, 200, 100);
		house1.setRoof(roof1);
		Wall wall1 = new Wall(house1, 0, 100, 200, 250);
		Window win1 = new DoubleWindow(wall1, 40, 40, 40, 80);
		//win1.setSash(true);
		wall1.windows.add(win1);
		Window win2 = new DoubleWindow(wall1, 120, 40, 40, 80);
		//win2.setSash(true);
		wall1.windows.add(win2);
		Door door1 = new Door(wall1, 86, 180, 35, 70);
		//door1.setLeftKnob(false);
		wall1.setDoor(door1);
		house1.setWall(wall1);
		
		houseModel.houseList.add(house1);
		
		house1 = new House(null, 250, 100, 300, 300);
		roof1 = new GambrelRoof(house1, 0, 0, 300, 100);
		house1.setRoof(roof1);
		wall1 = new Wall(house1, 0, 100, 300, 200);
		win1 = new QuadWindow(wall1, 80, 20, 36, 70);
		win1.setSash(true);
		wall1.windows.add(win1);
		win2 = new QuadWindow(wall1, 200, 20, 36, 70);
		win2.setSash(true);
		wall1.windows.add(win2);
		door1 = new Door(wall1, 50, 140, 33, 60);
		//door1.setLeftKnob(false);
		wall1.setDoor(door1);
		house1.setWall(wall1);
		
		houseModel.houseList.add(house1);
		
		house1 = new House(null, 550, 20, 200, 380);
		roof1 = new CathedralRoof(house1, 0, 0, 200, 100);
		house1.setRoof(roof1);
		wall1 = new Wall(house1, 0, 100, 200, 280);
		win1 = new Window(wall1, 30, 40, 40, 80);
		win1.setSash(true);
		wall1.windows.add(win1);
		win2 = new Window(wall1, 130, 40, 40, 80);
		win2.setSash(true);
		wall1.windows.add(win2);
		door1 = new Door(wall1, 150, 200, 40, 80);
		door1.setLeftKnob(false);
		wall1.setDoor(door1);
		house1.setWall(wall1);
		
		houseModel.houseList.add(house1);

		drawPanel.repaint();
	}
	void buildHouse2(){
		House house1 = new House(null, 50, 50, 200, 350);
		Roof roof1 = new GambrelRoof(house1, 0, 0, 200, 100);
		house1.setRoof(roof1);
		Wall wall1 = new Wall(house1, 0, 100, 200, 250);
		Window win1 = new QuadWindow(wall1, 40, 40, 40, 80);
		win1.setSash(true);
		wall1.windows.add(win1);
		Window win2 = new QuadWindow(wall1, 120, 40, 40, 80);
		win2.setSash(true);
		wall1.windows.add(win2);
		Door door1 = new Door(wall1, 86, 180, 35, 70);
		door1.setLeftKnob(false);
		wall1.setDoor(door1);
		house1.setWall(wall1);		
		houseModel.houseList.add(house1);
		
		house1 = new House(null, 250, 100, 300, 300);
		roof1 = new CathedralRoof(house1, 0, 0, 300, 100);
		house1.setRoof(roof1);
		wall1 = new Wall(house1, 0, 100, 300, 200);
		win1 = new Window(wall1, 80, 20, 36, 70);
		wall1.windows.add(win1);
		win2 = new Window(wall1, 200, 20, 36, 70);
		wall1.windows.add(win2);
		door1 = new Door(wall1, 50, 140, 33, 60);
		wall1.setDoor(door1);
		house1.setWall(wall1);	
		houseModel.houseList.add(house1);
		
		house1 = new House(null, 550, 20, 200, 380);
		roof1 = new DomeRoof(house1, 0, 0, 200, 100);
		house1.setRoof(roof1);
		wall1 = new Wall(house1, 0, 100, 200, 280);
		win1 = new DoubleWindow(wall1, 30, 40, 40, 80);
		win1.setSash(true);
		wall1.windows.add(win1);
		win2 = new DoubleWindow(wall1, 130, 40, 40, 80);
		win2.setSash(true);
		wall1.windows.add(win2);
		door1 = new Door(wall1, 150, 200, 40, 80);
		wall1.setDoor(door1);
		house1.setWall(wall1);		
		houseModel.houseList.add(house1);

		drawPanel.repaint();
	}
}
