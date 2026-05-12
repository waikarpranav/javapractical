import java.awt.*;
import java.awt.event.*;
public class Experiment2 extends Frame implements MouseListener
{
	String msg = "" ;
	public Experiment2()
	{
		addMouseListener(this);  setSize(400,400); setVisible(true); requestFocus();
		addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						dispose();}});}
		public void mouseClicked(MouseEvent e)
		{
			msg="Mouse clicked";repaint();}
		public void mouseEntered(MouseEvent e)
		{
			setVisible(true); msg="Mouse Entered"; repaint();}
		public void mouseExited(MouseEvent e)
		{
			msg="Mouse Exited"; repaint();}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void paint(Graphics g)
		{
			g.drawString(msg, MAXIMIZED_BOTH, ABORT);}
		public static void main(String [] args)
		{
			new Experiment2();}
	}
