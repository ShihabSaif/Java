//package surviveThePlanPackage;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.Timer;
//
//public class Difficulty2 {
//	
//	public Difficulty2(String i)
//	{
//		if(i=="1")
//		{
//			 window.getContentPane().removeAll();
//			    window.getContentPane().add(gph); 
//				gph.setVisible(true); 
//				window.revalidate(); 
//				window.repaint();
//		  		
//			
//			timer5 = new Timer(20,new ActionListener()
//					{
//				       public void actionPerformed(ActionEvent e)
//				       {
//				    	   gph.repaint();  
//				    	   gph.move(); 
//				       }
//					});
//									
//			timer6 = new Timer(1000,new ActionListener(){
//				
//						public void actionPerformed(ActionEvent e) {
//							proceed--;
//							GamePanelHard.proceeed=proceed;
//							GamePanelHard.starting=true;
//							gph.repaint();
//							
//							if(proceed==0)
//							{
//								timer6.stop();
//								timer5.start();
//								GamePanelHard.starting=false;
//							}
//						}
//						
//					});
//					timer6.start();
//				
//		}
//	}
//}
