package surviveThePlanPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanelHard extends JPanel{

	public static boolean GameOver = false;
	public static int score=0;
	public static boolean starting = false;
	public static int proceeed = -1;
	
	public static  int width = 600;
	public static  int height = 800;
	
	private int Xcoordinate=0;
	private BufferedImage image;
	
	PlaneImageHard pim = new PlaneImageHard();
	wallDrawHard wd = new wallDrawHard(GamePanelHard.width);
	wallDrawHard wd2 = new wallDrawHard((GamePanelHard.width)+(GamePanelHard.width/2));
	
	public GamePanelHard(JFrame window)
	{
		LoadImage();
		
		//mouse pressed event
		this.addMouseListener(new MouseAdapter() 
				{
			       public void mousePressed(MouseEvent e)
			       {
			    	   
			    	   //super.mousePressed(e);
			    	   pim.goUpwards();
			       }
				});
	}

	private void LoadImage() {
		
		try{
			
			image=ImageIO.read(new File("C:/Users/Shihab/Desktop/Survive the Plane/images/night-sky-hi.png"));
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(image, Xcoordinate, 0, null);
		g.drawImage(image, Xcoordinate+2400, 0, null);
		
	    pim.drawPlane(g);
	    wd.drawWall(g);
	    wd2.drawWall(g);
	    
	    //to show score
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Garamond",Font.BOLD,40));
	    g.drawString("Score "+score, width/2, 100);
	    
	    if(starting==true)
	    {
	    	g.setFont(new Font("Garamond",Font.BOLD,150));
	    	g.drawString(Integer.toString(proceeed), width/2-75 , 250);
	    }
	}
	
	//move method for bird and wall
	
	
       void move()
	 {
		 pim.planeMovement();
		 wd.wallMovement();
		 wd2.wallMovement();
		 
		 if(GameOver)
		 {
			 wd.xCoordinate=GamePanelHard.width;
			 wd2.xCoordinate=GamePanelHard.width+GamePanelHard.width/2;
			 GameOver=false;
		 }
		 
		 //moving the background with the help of wall measurement
		Xcoordinate+=wallDraw.speed; //speed is initially -6
		 
		 if(Xcoordinate==-2400)
		 {
			 Xcoordinate=0;
		 }
		 
//		 System.out.println(wd.xCoordinate + "->" +pim.xCoordinate + "&" + wd2.xCoordinate +"->"+pim.xCoordinate);
		 
		 if(wd.xCoordinate==pim.xCoordinate || wd2.xCoordinate==pim.xCoordinate)
		 {
			 score++;
		 }
	 }
	 
	 //message pop up
	 public static boolean popUpMessage()
	 {
		 int result = JOptionPane.showConfirmDialog(null, "Game over , Your score is "+score+"\n DO You wanto to restart the game","GameOver",JOptionPane.YES_NO_OPTION);
	     
		 if(result==JOptionPane.YES_OPTION)
		 {
			 return true;
		 }
		 else 
			 return false;
	 }
	
}
