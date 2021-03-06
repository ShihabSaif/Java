package surviveThePlanPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class planeImageMidium {
	
	 private BufferedImage image = null;
	 public static int planeDiameter = 100;
	 public static int xCoordinate = ((GamePanelMidium.width)/2)-(planeDiameter/2)-170;
	 public  static int yCoordinate = ((GamePanelMidium.height)/2);
	 
	 private static int speed=2;
	 private int accelaretion =1;
	 
	 public planeImageMidium()
	 {
		 LoadImage();
	 }

	private void LoadImage() {
		
		try{
			image=ImageIO.read(new File("D:/6th semester/Java/java codes/Survive the Plane/images/plane.png"));
		}catch(Exception ex){
			
		}
	}
	
	public void drawPlane(Graphics g)
	{
		g.drawImage(image, xCoordinate, yCoordinate, null);
	}
	
	public void planeMovement()
	{
		if(yCoordinate>=0 && yCoordinate<=GamePanelMidium.height)
		{
			speed += accelaretion;  //3,4,5
			yCoordinate+=speed;  //400+3,400+3+4,400+3+4+5
		}
		else
		{
			boolean option = GamePanelMidium.popUpMessage();
			
			if(option)
			{
				try{
	     			Thread.sleep(500);
	     		}catch(Exception ex)
	     		{
	     			ex.printStackTrace();
	     		}
	     		reset();
			}
			else{
				//close window
				JFrame frame = PlaneMain.getWindow();
				frame.dispose();
				Difficulty.timer3.stop();
			}
		}
	
	}
	
	//after touching the wall with plane it needs to reset for play again
	public static void reset() {
		speed  =2;
		yCoordinate = ((GamePanelMidium.height)/2);
		GamePanelMidium.GameOver=true;
		GamePanelMidium.score=0;
	}
	
	public void goUpwards()
	{
		speed = -17;
	}
	
	public static Rectangle getBirdRect()
	{
		Rectangle planeRect = new Rectangle(xCoordinate,yCoordinate,planeDiameter,50);
		return planeRect;
	}
	

}
