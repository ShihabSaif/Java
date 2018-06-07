package surviveThePlanPackage;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	private BufferedImage image = null;
	private BufferedImage start = null;
	
	public boolean startingPoint = false;
	
	JButton play;
	
	public MenuPanel(JFrame window)
	{
		this.setLayout(null);
		addButton();
		
		Difficulty dp = new Difficulty(window);
		LoadImage();
		
		//mouse click event
		this.play.addMouseListener(new MouseAdapter()
				{
			  public void mouseClicked(MouseEvent e)
			  		{
				  		//super.mouseClicked(e);
				  		//startingPoint=true;
				    window.getContentPane().removeAll();
				    window.getContentPane().add(dp);
					dp.setVisible(true); 
					window.revalidate();
					window.repaint();
			  		}
				});
		
		
	}

	private void LoadImage() {
		
		try{
			
			image = ImageIO.read(new File("C:/Users/Shihab/Desktop/Survive the Plane/images/survive the plane.jpg")); //menu file image
			start = ImageIO.read(new File("C:/Users/Shihab/Desktop/Survive the Plane/images/start.png"));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(image, 0, 0, GamePanel.width, GamePanel.height, null);
	}
	
	public void addButton()
	{
		play = new JButton("START");
		play.setBounds(250,500,100,50);
		
		this.add(play);
	}
	
}
