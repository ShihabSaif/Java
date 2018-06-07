package surviveThePlanPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import Audio.AudioPlayer;
import Audio.AudioPlayer2;
import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class wallDraw {
	
	AudioPlayer2 collision;
	AudioPlayer GameSound;
	
	private Random r = new Random();
	public int xCoordinate;
	public int yCoordinate=r.nextInt(GamePanel.height-400)  ; //max 600 and min 200 
	private int widthWall = 45;
	private int heightWall = GamePanel.height-yCoordinate;
	private int gap = 300;
	private BufferedImage image = null;
	public int soundCounter = 0;
	public static int speed = -6;
	
//	public wallDraw(AudioPlayer a)
//	{
//		GameSound=a;
//	}
	
	public wallDraw(int xCoordinate)
	{
		this.xCoordinate=xCoordinate;
		LoadImage();
		
		
		collision = new AudioPlayer2("/plain_crash (mp3cut.net)(1).mp3");
	}

	private void LoadImage() {
		try{
			image=ImageIO.read(new File("D:/6th semester/Java/java codes/Survive the Plane/images/images.png"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void drawWall(Graphics g)
	{
		g.drawImage(image, xCoordinate, yCoordinate, null); //bottom wall
		g.drawImage(image, xCoordinate, (-GamePanel.height)+(yCoordinate-gap), null); //upper wall -800+(600-200)
	}
	
	public void wallMovement()
	{
		xCoordinate+=speed; //600 -> 600-6 , 600-6-6 , 600-6-6-6 , ...... 0 -> -6
							//900 -> 900-6 , 900-6-6 , 900-6-6-6 , ...... 0 to minus values to -45
		
		if(xCoordinate<=-widthWall) //reset the wall if it goes near the window
		{
			xCoordinate = GamePanel.width;
			yCoordinate = r.nextInt(GamePanel.height-400)+200;
			heightWall = GamePanel.height-yCoordinate;
		}
	
     	Rectangle lowerRect = new Rectangle(xCoordinate,yCoordinate,widthWall,heightWall);
     	Rectangle upperRect = new Rectangle(xCoordinate,0,widthWall,GamePanel.height-(heightWall+gap));
     	
     	
     	if(lowerRect.intersects(planeImage.getBirdRect()) || upperRect.intersects(planeImage.getBirdRect()))
     	{
     		//GameSound.stop(); 		
     		collision.play();
     		//true or false in intersect
     		boolean option = GamePanel.popUpMessage();
     		
     		if(option==true)
     		{

         		try{
         			Thread.sleep(250);
         		}catch(Exception ex)
         		{
         			ex.printStackTrace();
         		}
         		planeImage.reset();
         		wallReset();
     		}
     		else
     		{
     			//close the enter window if user input no
     			JFrame frame = PlaneMain.getWindow();
				frame.dispose();
     			Difficulty.timer.stop();
     		}
     		
     	}
     	
	}
    
	//after touching the wall of plane wall needs to reset
	private void wallReset() {
		 yCoordinate=r.nextInt((GamePanel.height-400));
		 heightWall = GamePanel.height-yCoordinate;
		 GamePanel.GameOver=true;
//		 soundCounter=0;
	}

	
}

