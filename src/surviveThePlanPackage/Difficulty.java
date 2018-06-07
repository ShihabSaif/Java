package surviveThePlanPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Audio.AudioPlayer;
import Audio.AudioPlayer2;

public class Difficulty extends JPanel{
	
	
	JButton easy,midium,tough;
	
	public static boolean easyPoint=false ; 
	public static boolean midiumPoint=false ; 
	public static boolean hardPoint=false ; 
	public int easyCounter = 0;
	public int midiumCounter = 0;
	public int toughCounter = 0;
	
	private BufferedImage esy = null;
	private BufferedImage mdm = null;
	private BufferedImage tgh = null;
	private BufferedImage backGround = null;
	
	public  static Timer timer,timer2,timer3,timer4,timer5,timer6;
	private int proceed = 4;
	
	AudioPlayer gameRun;
	AudioPlayer2 buttonClick,collision;
	public Difficulty(JFrame window)
	{
		gameRun = new AudioPlayer("/airplane.mp3.mp3");
		buttonClick = new AudioPlayer2("/Button.mp3.mp3");
		collision = new AudioPlayer2("/Collision.mp3.mp3");
		
		//wallDraw w =new wallDraw(gameRun,gameRun);
		
		GamePanel gp = new GamePanel(window);
		GamePanelMidium gpm = new GamePanelMidium(window);
		GamePanelHard gph = new GamePanelHard(window);
		LoadImage();
	
		
		this.setBackground(Color.GREEN);
		this.setLayout(null);
		
		addButton();
		
		this.easy.addMouseListener(new MouseAdapter()
		{
			 
	  public void mouseClicked(MouseEvent e)
	  		{
		    buttonClick.play();
		  	window.getContentPane().removeAll();
		    window.getContentPane().add(gp);
			gp.setVisible(true); 
			window.revalidate();
			window.repaint();
			timer2.start();
	  		}
		});
				
		timer = new Timer(20,new ActionListener()
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   gp.repaint();  
	    	   gp.move(); 
	       }
		});
		
		
		timer2 = new Timer(1000,new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				proceed--;
				GamePanel.proceeed=proceed;
				GamePanel.starting=true;
				gp.repaint();
				
				if(proceed==0)
				{
					timer2.stop();
					gameRun.play();
					timer.start();
					GamePanel.starting=false;
				}
			}
			
		});
		
	
     
     	
		this.midium.addMouseListener(new MouseAdapter()
		{
	  public void mouseClicked(MouseEvent e)
	  		{
		  buttonClick.play();
		  window.getContentPane().removeAll();
		    window.getContentPane().add(gpm);
			gpm.setVisible(true); 
			window.revalidate();
			window.repaint();
			timer4.start();
	  		}
		});
		
		timer3 = new Timer(20,new ActionListener()
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   gpm.repaint();  
	    	   gpm.move(); 
	       }
		});
		

		
timer4 = new Timer(1000,new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				proceed--;
				GamePanelMidium.proceeed=proceed;
				GamePanelMidium.starting=true;
				gpm.repaint();
				
				if(proceed==0)
				{
					timer4.stop();
					gameRun.play();
					timer3.start();
					GamePanelMidium.starting=false;
				}
			}
			
	  	});
	  	
	
		
		this.tough.addMouseListener(new MouseAdapter()
		{
			
			
	  public void mouseClicked(MouseEvent e)
	  		{
		  
		  buttonClick.play();
		  window.getContentPane().removeAll();
		    window.getContentPane().add(gph); 
			gph.setVisible(true); 
			window.revalidate();
			window.repaint();
			timer6.start();
	  		}
		});
		
		timer5 = new Timer(20,new ActionListener()
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	   gph.repaint();  
			    	   gph.move(); 
			       }
				});
								
		timer6 = new Timer(1000,new ActionListener(){
			
					public void actionPerformed(ActionEvent e) {
						proceed--;
						GamePanelHard.proceeed=proceed;
						GamePanelHard.starting=true;
						gph.repaint();
						
						if(proceed==0)
						{
							timer6.stop();
							gameRun.play();
							timer5.start();
							GamePanelHard.starting=false;
						}
					}
					
				});
				
			
		
	}
	
	
   private void LoadImage() {
		try{
			esy=ImageIO.read(new File("D:/6th semester/Java/java codes/Survive the Plane/images/easy.jpg")); 
			mdm=ImageIO.read(new File("D:/6th semester/Java/java codes/Survive the Plane/images/Medium_Intertitle.jpg"));
			tgh=ImageIO.read(new File("D:/6th semester/Java/java codes/Survive the Plane/images/tough.jpg"));
			backGround = ImageIO.read(new File("C:/Users/Shihab/Desktop/Survive the Plane/images/plane2.jpg"));
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
 

  

	public void paintComponent(Graphics g)
	{
		g.drawImage(backGround, 0,0,600,800,null);
	
	}

   public void addButton()
   {
	   easy = new JButton(new ImageIcon(esy));
	   easy.setBounds(165, 100, 230,100);
	   
	   midium = new JButton(new ImageIcon(mdm));
	   midium.setBounds(165,300,230,100);
 
	   tough = new JButton(new ImageIcon(tgh));
	   tough.setBounds(165,500,230,100);
	   
	   this.add(easy);
	   this.add(midium);
	   this.add(tough);
	  
   }
   
  
   
}