package surviveThePlanPackage;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlaneMain extends JFrame{
	
	//window create
	//1st panel contain menu of the game
	//2nd panel which contain main game part
	
	public static JFrame window;
//	public  static Timer timer,timer2;
	private int proceed = 4;
	public PlaneMain()
	{
		window = new JFrame();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:/Users/Shihab/Desktop/Survive the Plane/images/cursor-3-512.png");
        Cursor c = toolkit.createCustomCursor(image , new Point(window.getContentPane().getX(), window.getContentPane().getY()), "img");
        window.getContentPane().setCursor (c);
		MenuPanel mp = new MenuPanel(window);
		window.add(mp);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(GamePanel.width, GamePanel.height);
		window.setLocationRelativeTo(null);
		window.setTitle("Survive The Plane");
		window.setResizable(true);
		
	}
	
	
	public static JFrame getWindow()
	{
		return window;
	}
	
	public static void main(String[] args)
	{
		PlaneMain plane = new PlaneMain();
		
	}
}
